package com.mastek.training.hrapp.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class APIConfig extends ResourceConfig{

	public APIConfig() {
		//Register each Service class in ResourceConfig
		//register the CORS Settingg
		register(CORSFilter.class);
		register(EmployeeService.class);
		register(DepartmentService.class);
		register(ProjectService.class);
	}

}
