package com.kapokframework.springmvc.views.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kapokframework.springmvc.jackson.filter.PropertyFilter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Will WM. Zhang
 * @since 2016-12-20 11:49
 */
public class JsonView extends AbstractView {

    public static final String INCLUDE = "include";
    public static final String EXCLUDE = "exclude";
//    public static final String FILTER_NAME = "filterName"; 暂不支持自定义filter

    public static final String RESULT_CODE = "resultCode";
    public static final String RESULT_MSG = "resultMsg";
    public static final String RESULT = "result";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void renderMergedOutputModel(
            Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Object resultCode = model.get(RESULT_CODE);
        Object resultMsg = model.get(RESULT_MSG);
        Object result = model.get(RESULT);
        String filterName = "propertyFilter";//(String) model.get(FILTER_NAME); 暂不支持自定义filter
        String include = (String) model.get(INCLUDE);
        String exclude = (String) model.get(EXCLUDE);

        if (StringUtils.isEmpty(resultCode)) resultCode = 0;
        if (StringUtils.isEmpty(resultMsg)) resultMsg = "操作成功";
//        if (StringUtils.isEmpty(filterName)) filterName = "propertyFilter"; 暂不支持自定义filter

        Class<?> resultClass = result.getClass();

//        if (Collection.class.isAssignableFrom(resultClass)) {
//            Type resultClassGenericSuperclass = resultClass.getGenericSuperclass();
//            Type[] actualTypeArguments = ((ParameterizedType) resultClassGenericSuperclass).getActualTypeArguments();
//            resultClass = actualTypeArguments[0].getClass();
//        }

        // 暂时不支持“.”属性
        if (!StringUtils.isEmpty(include) && !StringUtils.isEmpty(exclude)) {
            Set<String> includeSet = StringUtils.commaDelimitedListToSet(include);
            Set<String> excludeSet = StringUtils.commaDelimitedListToSet(exclude);
            includeSet.removeAll(excludeSet);
            SimpleBeanPropertyFilter sbpf = SimpleBeanPropertyFilter.filterOutAllExcept(includeSet);
            objectMapper.setFilterProvider(new SimpleFilterProvider().addFilter(filterName, sbpf));
            objectMapper.addMixIn(resultClass, PropertyFilter.class);
        } else if (!StringUtils.isEmpty(include)) {
            Set<String> includeSet = StringUtils.commaDelimitedListToSet(include);
            SimpleBeanPropertyFilter sbpf = SimpleBeanPropertyFilter.filterOutAllExcept(includeSet);
            objectMapper.setFilterProvider(new SimpleFilterProvider().addFilter(filterName, sbpf));
            objectMapper.addMixIn(resultClass, PropertyFilter.class);
        } else if (!StringUtils.isEmpty(exclude)) {
            Set<String> excludeSet = StringUtils.commaDelimitedListToSet(exclude);
            SimpleBeanPropertyFilter sbpf = SimpleBeanPropertyFilter.serializeAllExcept(excludeSet);
            objectMapper.setFilterProvider(new SimpleFilterProvider().addFilter(filterName, sbpf));
            objectMapper.addMixIn(resultClass, PropertyFilter.class);
        }

        response.setContentType("application/json;charset=UTF-8");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(RESULT_CODE, resultCode);
        resultMap.put(RESULT_MSG, resultMsg);
        resultMap.put(RESULT, result);

        objectMapper.writeValue(response.getOutputStream(), resultMap);
    }

}
