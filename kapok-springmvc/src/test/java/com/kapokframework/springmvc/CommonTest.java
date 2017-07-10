package com.kapokframework.springmvc;

import com.kapokframework.springmvc.entity.Car;
import com.kapokframework.springmvc.entity.Person;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Will WM. Zhang
 * @since 2017-01-27 21:13
 */
public class CommonTest {

    @Test
    public void PatternTest() throws Exception {

        String yyyy = "(\\d{4})";
        String MM = "(0[1-9]|1[1-2])";
        String dd = "(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
        String HH = "(0[0-9]|1[0-9]|2[0-3])";
        String mm = "(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])";
        String ss = "(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])";

        // 按指定模式在字符串查找
        String str = "109-23";
        String yMM = "(\\d)-(0[1-9]|1[1-2])";


        DateFormat df = new SimpleDateFormat("yMM-dd");
        df.setLenient(false);

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(yMM);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(str);
        if (m.find()) {
            System.out.println("Found value: " + m.group());
        } else {
            System.out.println("NO MATCH");
        }
        System.out.println("Found value: " + df.parse(str));
    }

    @Test
    public void test() throws Exception {

        List<Person> persons = new LinkedList<>();
        Type personsSuperclass = persons.getClass().getGenericSuperclass();
        Type[] personsTypes = ((ParameterizedType) personsSuperclass).getActualTypeArguments();

        Map<String, Car> carMap = new HashMap<>();
        Type carMapSuperclass = carMap.getClass().getGenericSuperclass();
        Type[] carMapTypes = ((ParameterizedType) carMapSuperclass).getActualTypeArguments();

        System.out.println(personsTypes.length);
        System.out.println(carMapTypes[0]);
        System.out.println(carMapTypes[1]);
        System.out.println(24*60);
    }

}
