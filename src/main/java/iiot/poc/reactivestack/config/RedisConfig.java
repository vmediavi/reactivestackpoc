package iiot.poc.reactivestack.config;

import iiot.poc.reactivestack.model.Film;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public ReactiveHashOperations<String, Long, Film> hashOperations(ReactiveRedisConnectionFactory redisConnectionFactory) {
        var template = new ReactiveRedisTemplate<>(
                redisConnectionFactory,
                RedisSerializationContext.<String, Film>newSerializationContext(new StringRedisSerializer())
                        .hashKey(new GenericToStringSerializer<>(Long.class))
                        .hashValue(new Jackson2JsonRedisSerializer<>(Film.class))
                        .build());
        return template.opsForHash();
    }
}
