package com.kapokframework.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 *
 * @author <a href="mailto:samposn@163.com">Will WM. Zhang</a>
 * Create At: 2020-12-26 15:03
 * @since
 */
@Controller
@RequestMapping("/account")
public class AccountEndpoint {

    @GetMapping
    public void abc() {
    }

}
