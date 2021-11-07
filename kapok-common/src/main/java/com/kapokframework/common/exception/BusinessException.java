package com.kapokframework.common.exception;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-12-29 13:59
 * @since
 */
public class BusinessException extends RuntimeException {

    /**
     * status:
     *     >0: 业务异常
     *     =0: 正常
     *     <0: 系统异常
     * message:
     *     ""
     * result:
     *     {}
     * @param message
     */
    public BusinessException(String message) {
        super(message, null, false, false);
    }

}
