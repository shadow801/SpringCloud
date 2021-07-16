package com.yewen.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ShadowStart
 * @create 2021-07-03 21:39
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RoundRobinRule();
    }

}
