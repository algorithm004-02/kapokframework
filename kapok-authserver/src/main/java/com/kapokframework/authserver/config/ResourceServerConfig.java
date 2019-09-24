package com.kapokframework.authserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源服务
 *
 * @author Will WM. Zhang
 * @since 2019-09-06 10:20
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // TODO 资源管理也是授权服务器的必要功能之一，这里也是示例代码，也是必须实现的。
        http.authorizeRequests()
            .antMatchers("/api/**")
            .authenticated();
    }

}
