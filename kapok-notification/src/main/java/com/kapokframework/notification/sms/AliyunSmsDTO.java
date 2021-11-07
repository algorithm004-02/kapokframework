package com.kapokframework.notification.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-24 12:23
 * @since
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AliyunSmsDTO implements SmsDTO {

    @JsonProperty("Message")
    private String message;

    @JsonProperty("RequestId")
    private String requestId;

    @JsonProperty("BizId")
    private String bizId;

    @JsonProperty("Code")
    private String code;

}