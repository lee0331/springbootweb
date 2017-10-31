package com.boot.conf.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Component
public class RedisHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		int errorCode = check();
		if(errorCode != 0) {
			return Health.down().withDetail("Error Code", errorCode).build();
		}
		return Health.up().build();
	}
	
	private int check() {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		try {
			jedis.ping();
		} catch (Exception e) {
			return HttpStatus.NO_CONTENT.value();
		} finally {
			jedis.close();
		}
		return 0;
	}
}
