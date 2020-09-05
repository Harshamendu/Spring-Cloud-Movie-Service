package com.harsha.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class MovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//	    return new JedisConnectionFactory();
//	}
//	 
//	@Bean
//	public RedisTemplate<?, ?> redisTemplate() {
//	    RedisTemplate<?, ?> template = new RedisTemplate<>();
//	    template.setConnectionFactory(jedisConnectionFactory());
//	    return template;
//	}
}
