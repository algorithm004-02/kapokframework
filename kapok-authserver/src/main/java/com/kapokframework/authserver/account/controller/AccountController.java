package com.kapokframework.authserver.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Will WM. Zhang
 * @since 2019-09-06 10:52
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping
    public ResponseEntity<String> getUserInfo() {
        return ResponseEntity.ok("userInfo");
    }
}
