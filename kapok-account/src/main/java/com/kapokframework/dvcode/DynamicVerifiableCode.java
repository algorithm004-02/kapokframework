package com.kapokframework.dvcode;

import lombok.Builder;
import lombok.Data;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-23 13:35
 * @since
 */
@Data
@Builder
public class DynamicVerifiableCode {

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 动态验证码
     */
    private String dvCode;

    /**
     * 生成时间戳
     */
    private Long generateAt;

    /**
     * 校验 hash
     */
    private String hash;

}
