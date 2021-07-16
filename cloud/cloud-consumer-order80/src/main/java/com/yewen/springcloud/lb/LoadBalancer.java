package com.yewen.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;


/**
 * @author ShadowStart
 * @create 2021-07-05 19:30
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
