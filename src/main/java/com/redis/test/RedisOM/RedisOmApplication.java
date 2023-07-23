package com.redis.test.RedisOM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableRedisDocumentRepositories(basePackages = "com.redis.test.RedisOM.*")
@EnableSwagger2
@SpringBootApplication
public class RedisOmApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisOmApplication.class, args);
	}
	
	
}
