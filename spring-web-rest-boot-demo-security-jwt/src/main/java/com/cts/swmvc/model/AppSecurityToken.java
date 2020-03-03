package com.cts.swmvc.model;

import java.io.Serializable;

public class AppSecurityToken implements Serializable {

	private static final long serialVersionUID = 2L;
	private final String jwttoken;
	
	public AppSecurityToken(String jwttoken) {
		this.jwttoken = jwttoken;                        //first value is assigned and after that it becomes constant
	}

	public String getToken() {
		return jwttoken;
	}

}
