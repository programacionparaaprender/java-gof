package com.program.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.program.app.config.ConfigurationService;
import com.program.app.interfaz.impl.PaymentService;

@SpringBootApplication
public class JavaGofApplication {

	public static void main(String[] args) {
		
		principio_creacional();
		//SpringApplication.run(JavaGofApplication.class, args);
	}
	
	private static void principio_creacional() {
		ConfigurationService service = ConfigurationService.getInstance();
		System.out.println("principio de creación Singleton");
		System.out.println(service.getConfig("app.version"));
	}
	
	private static void principio_factory_method() {
		PaymentService service = new PaymentService();
		System.out.println("principio de creación Singleton");
		System.out.println(service.getConfig("app.version"));
	}

}
