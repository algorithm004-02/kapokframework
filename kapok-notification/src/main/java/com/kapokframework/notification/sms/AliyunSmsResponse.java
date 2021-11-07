package com.kapokframework.notification.sms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-25 00:45
 * @since
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AliyunSmsResponse {

    private String code;
    private String message;

}
