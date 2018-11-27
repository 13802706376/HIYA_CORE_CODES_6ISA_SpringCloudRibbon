package com.hiya.cloud;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController
{
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private DiscoveryClient discoveryClient;

    // discoveryClient获取服务列表中，应用名为sc-eureka-first-provider一个服务注册信息
    public String serviceUrl()
    {
        List<ServiceInstance> list = discoveryClient.getInstances("eureka_provider");
        if (list != null && list.size() > 0)
        {
            return String.valueOf(list.get(0).getUri());
        }
        return null;
    }

    @RequestMapping("/hiya/user/{id}")
    public OrderModel findByIdByEurekaServer(@PathVariable Integer id)
    {
        String providerServiceUrl = serviceUrl();
        logger.info("providerServiceUrl: {}",providerServiceUrl);
        ResponseEntity<OrderModel> om = this.restTemplate.getForEntity(providerServiceUrl + "hiya/order/" + id, OrderModel.class);
        logger.info("om: {}",om);
        return om.getBody();
    }
}