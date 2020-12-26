package com.kapokframework.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AccountServiceBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceBootstrap.class, args);
	}

}
