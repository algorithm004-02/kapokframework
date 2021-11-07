package com.kapokframework.notification.sms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-12-27 00:11
 * @since
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AliyunSmsRequest {

    @NotBlank
    private String phoneNumber;
    private String signName;
    private String templateCode;
    private String templateParam;

}
