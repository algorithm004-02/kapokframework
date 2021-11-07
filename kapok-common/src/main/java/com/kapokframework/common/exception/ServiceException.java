package com.kapokframework.common.exception;

import com.kapokframework.common.api.ResultCode;
import lombok.Getter;

/**
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-11-18 17:47
 * @since
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -2823387234735895466L;

    @Getter
    private final ResultCode resultCode;

    public ServiceException(String message) {
        super(message);
        this.resultCode = ResultCode.FAILURE;
    }

    public ServiceException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

}
