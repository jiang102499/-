package com.example.novel.config;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/23
 * Description: com.kuang.config
 * version: 1.0
 */

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * @ClassName RedisConfig
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/23 9:21
 * @Version 1.0
 **/
@Configuration
public class RedisConfig {

  //编写我们自己的RedisTemplate
  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory)
    throws UnknownHostException {
    RedisTemplate<String, Object> template = new RedisTemplate<>();

    //配置具体的序列化方式
    template.setConnectionFactory(connectionFactory);

    //自定义Jackson序列化配置
    Jackson2JsonRedisSerializer jsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
    jsonRedisSerializer.setObjectMapper(objectMapper);

    //key使用String的序列化方式
    StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    template.setKeySerializer(stringRedisSerializer);
    //hash的key也是用String的序列化方式
    template.setHashKeySerializer(stringRedisSerializer);
    //value的key使用jackson的序列化方式
    template.setValueSerializer(jsonRedisSerializer);
    //hash的value也是用jackson的序列化方式
    template.setHashValueSerializer(jsonRedisSerializer);
    template.afterPropertiesSet();

    return template;
  }
}
