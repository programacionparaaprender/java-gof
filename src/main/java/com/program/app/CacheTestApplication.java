package com.program.app;

import org.springframework.boot.SpringApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import com.program.app.decorador.DataService;

@EnableCaching
public class CacheTestApplication {
	public static void patron_decorator1(String[] args) {
        // Iniciar el contexto de Spring Boot
        ConfigurableApplicationContext context = SpringApplication.run(CacheTestApplication.class, args);
        
        // Obtener el servicio decorado del contexto de Spring
        DataService dataService = context.getBean(DataService.class);
        
        // Primera llamada - debería ejecutar el método real
        System.out.println("=== Primera llamada (debería cargar datos frescos) ===");
        long startTime1 = System.currentTimeMillis();
        String data1 = dataService.fetchData();
        long endTime1 = System.currentTimeMillis();
        System.out.println("Datos obtenidos: " + data1);
        System.out.println("Tiempo de ejecución: " + (endTime1 - startTime1) + "ms");
        
        // Segunda llamada - debería devolver los datos de la caché
        System.out.println("\n=== Segunda llamada (debería usar caché) ===");
        long startTime2 = System.currentTimeMillis();
        String data2 = dataService.fetchData();
        long endTime2 = System.currentTimeMillis();
        System.out.println("Datos obtenidos: " + data2);
        System.out.println("Tiempo de ejecución: " + (endTime2 - startTime2) + "ms");
        
        // Verificar si son el mismo objeto (la caché debería devolver el mismo)
        System.out.println("\n¿Misma referencia?: " + (data1 == data2));
        System.out.println("¿Contenido igual?: " + data1.equals(data2));
        
        // Limpiar la caché para demostración
        System.out.println("\n=== Limpiando caché ===");
        context.getBean(CacheManager.class).getCache("dataCache").clear();
        
        // Tercera llamada - después de limpiar caché
        System.out.println("\n=== Tercera llamada (después de limpiar caché) ===");
        long startTime3 = System.currentTimeMillis();
        String data3 = dataService.fetchData();
        long endTime3 = System.currentTimeMillis();
        System.out.println("Datos obtenidos: " + data3);
        System.out.println("Tiempo de ejecución: " + (endTime3 - startTime3) + "ms");
        
        // Cerrar el contexto
        context.close();
    }
}
