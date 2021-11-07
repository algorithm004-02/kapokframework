package com.kapokframework.notification;

import com.kapokframework.notification.sms.AliyunSmsServiceProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-24 16:14
 * @since
 */
@SpringBootApplication
@EnableConfigurationProperties({AliyunSmsServiceProperties.class})
public class NotificationServiceBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceBootstrap.class, args);
    }
}
