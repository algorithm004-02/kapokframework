package com.kapokframework.notification.sms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-28 18:01
 * @since
 */
@Controller
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SmsEndpoint {

    private final AliyunSmsServiceImpl aliyunSmsService;

    @GetMapping(headers = {"Action=sendSms"})
    public AliyunSmsResponse sendSms(@Valid AliyunSmsRequest aliyunSmsRequest) {

        SmsDTO smsDTO = aliyunSmsService.sendSms(
            aliyunSmsRequest.getPhoneNumber(),
            aliyunSmsRequest.getSignName(),
            aliyunSmsRequest.getTemplateCode(),
            aliyunSmsRequest.getTemplateParam()
        );

        return AliyunSmsResponse.builder()
            .code(smsDTO.getCode())
            .message(smsDTO.getMessage())
            .build();
    }

}
