package com.kapokframework.notification.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-24 17:25
 * @since
 */
@Data
@Validated
@ConfigurationProperties(prefix = "kapok-notification.sms.aliyun")
public class AliyunSmsServiceProperties {

    private String reginId = "default";

    @NotEmpty(message = "accessKeyId不能为空")
    private String accessKeyId;

    @NotEmpty(message = "accessKeySecret不能为空")
    private String accessKeySecret;

    private String sysDomain = "dysmsapi.aliyuncs.com";
    private String sysVersion = "2017-05-25";

    private String signName;

}
