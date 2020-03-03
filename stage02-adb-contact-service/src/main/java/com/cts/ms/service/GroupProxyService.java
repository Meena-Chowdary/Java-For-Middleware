package com.cts.ms.service;
//
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Repository;
//
////if youdon't want to use Ribbon client then we can use his
////@FeignClient(name="group-service",url="localhost:9100)
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.cts.ms.model.GroupModel;
//@FeignClient(name="group-service") //for communication btwn microservices
//@RibbonClient(name="group-service") //for creating ribbon of group-service which has group-service's URL
//public interface GroupProxyService {
//	@GetMapping("/group/{id}")
//	public GroupModel getGroupModel(@PathVariable(name="id") String id);
//}

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.ms.model.GroupModel;

@FeignClient(name="group-service")
@RibbonClient(name="group-service")
@Service
public interface GroupProxyService {

@GetMapping("/groups/{id}")
public GroupModel getGroupModel(@PathVariable(name="id")String id);
}