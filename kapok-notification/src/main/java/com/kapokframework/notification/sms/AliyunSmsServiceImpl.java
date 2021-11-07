package com.kapokframework.notification.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapokframework.common.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-23 12:05
 * @since
 */
@Service
@RequiredArgsConstructor
public class AliyunSmsServiceImpl implements SmsService {

    private final IAcsClient smsAcsClient;

    private final AliyunSmsServiceProperties properties;

    private final ObjectMapper objectMapper = new ObjectMapper();


    public SmsDTO sendSms(String phoneNumber, String templateCode, String templateParam) {

        String signName = properties.getSignName();

        return this.sendSms(phoneNumber, signName, templateCode, templateParam);

    }


    // @Async(AppConfig.ASYNC_EXECUTOR_NAME) TODO 需要修改为多线程
    public SmsDTO sendSms(String phoneNumber, String signName,
                          String templateCode, String templateParam) {

        // TODO 考虑如何处理参数检查
        Assert.hasLength(phoneNumber, "手机号码不能为空");
        Assert.hasLength(templateCode, "templateCode不能为空");
        Assert.hasLength(signName, "签名不能为空");

        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setSysDomain(properties.getSysDomain());
        commonRequest.setSysVersion(properties.getSysVersion());
        commonRequest.setSysAction("SendSms");

        commonRequest.putQueryParameter("PhoneNumbers", phoneNumber);
        commonRequest.putQueryParameter("SignName", signName);
        commonRequest.putQueryParameter("TemplateCode", templateCode);
        commonRequest.putQueryParameter("TemplateParam", templateParam);

        CommonResponse commonResponse;
        try {
            commonResponse = smsAcsClient.getCommonResponse(commonRequest);
        } catch (ClientException e) {
            e.printStackTrace(); // TODO 这里需要记录日志，不要直接打印
            throw new ServiceException("阿里云 Sms 调用发生错误"); // TODO 检查异常是否需要抛出
        }

        AliyunSmsDTO aliyunSmsDTO;
        try {
            aliyunSmsDTO = objectMapper.readValue(commonResponse.getData(), AliyunSmsDTO.class);
            return aliyunSmsDTO;
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // TODO 这里需要记录日志，不要直接打印
            throw new ServiceException("数据转换出错"); // TODO 检查异常是否需要抛出
        }

    }

}
