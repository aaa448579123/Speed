package org.phoenix.speed.redis.config;//package com.xxy.redis.springbootredislettuce.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author yangzhenjiang
// * @version 1.0
// * @description
// * @date 2020/4/20 18:39
// */
//@Configuration
//public class RedisConfig {
//    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory factory){
//        RedisTemplate<String,Object> template = new RedisTemplate<>();
//        //设置连接工厂
//        template.setConnectionFactory(factory);
//        //序列化
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        //在使用注解@Bean返回RedisTemplate的时候，同时配置hashKey与hashValue的序列化方式。
//        //key采用String的序列化方式
//        template.setKeySerializer(stringRedisSerializer);
//        //value序列化方式采用Jackson
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//
//        //hash的key也采用String的序列化方式
//        template.setHashKeySerializer(stringRedisSerializer);
//        //hash的value序列化方式采用Jackson
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
//}
