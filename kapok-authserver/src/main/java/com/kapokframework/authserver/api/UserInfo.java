package com.kapokframework.authserver.api;

import lombok.Builder;
import lombok.Data;

/**
 * @author Will WM. Zhang
 * @since 2019-09-06 10:52
 */
@Data
@Builder
public class UserInfo {

    private String name;

    private String email;
}
