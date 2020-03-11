package com.kapokframework.authserver.account.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Will WM. Zhang
 * @since 2020-03-11 10:40
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountMap.get(username);
    }

    private static Map<String, UserDetails> accountMap = new HashMap<>();
    static {
        accountMap.put("zhangsan", User.withUsername("zhangsan").password("123").authorities("p1").build());
        accountMap.put("lisi", User.withUsername("lisi").password("456").authorities("p2").build());
    }

}
