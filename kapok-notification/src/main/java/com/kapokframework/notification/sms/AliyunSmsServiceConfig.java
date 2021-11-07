package com.kapokframework.notification.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里短信服务配置
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-24 22:06
 * @since v1.0
 */
@Configuration
@RequiredArgsConstructor
public class AliyunSmsServiceConfig {

    private final AliyunSmsServiceProperties properties;

    @Bean
    public IAcsClient iAcsClient() {
        DefaultProfile defaultProfile = DefaultProfile.getProfile(
            properties.getReginId(),
            properties.getAccessKeyId(),
            properties.getAccessKeySecret());
        return new DefaultAcsClient(defaultProfile);
    }

}
