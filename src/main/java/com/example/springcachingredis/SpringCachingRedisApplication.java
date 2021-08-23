package com.example.springcachingredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCachingRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCachingRedisApplication.class, args);
	}

}
