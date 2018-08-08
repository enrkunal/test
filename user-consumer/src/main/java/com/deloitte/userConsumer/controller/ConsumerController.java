package com.deloitte.userConsumer.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.deloitte.userConsumer.entity.User;

@RestController
public class ConsumerController {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/client/usersA")
	public List<User> getUserDetailsA() throws RestClientException, IOException {
		List<ServiceInstance> instances=discoveryClient.getInstances("userRepository-producer");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/users";
		List<User> users = (new RestTemplate()).getForObject(baseUrl, List.class);
	    return users;
	}
	
	@RequestMapping("/client/usersB")
	public List<User> getUserDetailsB() throws RestClientException, IOException {
		List<User> users = this.restTemplate.getForObject("http://userRepository-producer/users", List.class);
	    return users;
	}
	
	
}

