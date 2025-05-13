package com.program.app;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.program.app.config.ConfigurationService;
import com.program.app.interfaz.PaymentMethod;
import com.program.app.interfaz.impl.PaymentService;


@SpringBootApplication
public class JavaGofApplication {

	public static void main(String[] args) {
		
		principio_creacional();
		principio_factory_method();
		//SpringApplication.run(JavaGofApplication.class, args);
	}
	
	private static void principio_creacional() {
		ConfigurationService service = ConfigurationService.getInstance();
		System.out.println("principio de creación Singleton");
		System.out.println(service.getConfig("app.version"));
	}
	
	private static void principio_factory_method() {
		PaymentService service = new PaymentService();
		PaymentMethod creditcard = service.createPaymentMethod("creditcard");
		System.out.println("principio factory method");
		BigDecimal amount = new BigDecimal("123.45");
		creditcard.processPayment(amount);
	}

}
