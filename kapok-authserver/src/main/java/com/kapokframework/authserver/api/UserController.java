package com.kapokframework.authserver.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Will WM. Zhang
 * @since 2019-09-06 10:52
 */
@Controller
public class UserController {

    // 资源API
    @RequestMapping("/api/userinfo")
    public ResponseEntity<UserInfo> getUserInfo() {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String email = user.getUsername()+"@kapok.com";

        UserInfo userInfo = UserInfo.builder()
                .name(user.getUsername())
                .email(email)
                .build();
        return ResponseEntity.ok(userInfo);
    }
}
