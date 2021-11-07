package com.kapokframework.notification.sms;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-24 22:35
 * @since
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AliyunSmsServiceImplTest {

    @Autowired
    private AliyunSmsServiceImpl aliyunSmsService;

    @Test
    public void testSendAuthCode() {

        String phoneNumber = "13824543893";
        String signName = "阿里云短信测试专用";
        String templateCode = "SMS_106520003";
        String templateParam = "{\"code\":\"1234\"}";

        SmsDTO smsDTO = aliyunSmsService.sendSms(phoneNumber, signName, templateCode, templateParam);

        Assertions.assertEquals("OK", smsDTO.getCode());

    }

}
