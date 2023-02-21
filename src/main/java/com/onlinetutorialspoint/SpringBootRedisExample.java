package com.onlinetutorialspoint;

import com.onlinetutorialspoint.model.Item;
import io.keploy.servlet.KeployMiddleware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@Import(KeployMiddleware.class)
public class SpringBootRedisExample {

	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, Item> redisTemplate(){
		RedisTemplate<String,Item> redisTemplate = new RedisTemplate<String, Item>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisExample.class, args);
	}
}
