package com.cts.adb.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.adb.model.GroupModel;

@FeignClient(name="group-service")
@RibbonClient(name="group-service")
public interface GroupProxyService {
	
	@GetMapping("/groups/{id}")
	public GroupModel getGroupModel(@PathVariable(name="id")String id);
}
