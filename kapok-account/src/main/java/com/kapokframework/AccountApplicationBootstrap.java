package com.kapokframework;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@Slf4j
@SpringBootApplication
public class AccountApplicationBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplicationBootstrap.class, args);
	}

	@Bean
	public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
		return new JPAQueryFactory(entityManager);
	}
}
