package com.yewen.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ShadowStart
 * @create 2021-07-03 9:26
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 开启负载均衡服务
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
