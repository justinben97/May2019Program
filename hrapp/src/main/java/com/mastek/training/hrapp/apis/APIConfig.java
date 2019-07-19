package com.mastek.training.hrapp.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class APIConfig extends ResourceConfig{

	public APIConfig() {
		//Register each Service class in ResourceConfig
		register(EmployeeService.class);
		register(DepartmentService.class);
	}

}
