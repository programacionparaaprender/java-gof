package com.program.app;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import com.program.app.adapter.impl.LegacyUserServiceAdapter;
import com.program.app.config.ConfigurationService;
import com.program.app.decorador.DataService;
import com.program.app.interfaz.PaymentMethod;
import com.program.app.interfaz.impl.PaymentService;
import com.program.app.models.Product;
import com.program.app.observer.OrderObserver;
import com.program.app.observer.models.Order;
import com.program.app.observer.services.OrderService;
import com.program.app.strategy.impl.service.ProductService;
import com.program.app.observer.observable.EmailNotificationService;
import com.program.app.observer.observable.InventoryService;


@SpringBootApplication
@EnableCaching
public class JavaGofApplication {

    public static void main(String[] args) {
    	//SpringApplication.run(JavaGofApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(JavaGofApplication.class, args);
        
        // Ejecutar pruebas de patrones
        testSingleton(context);
        testFactoryMethod();
        testAdapter(context);
        testCachingDecorator(context);
        testStrategy(context);
        testObserverPattern(context);
        context.close();
    }
    
    private static void testObserverPattern(ConfigurableApplicationContext context) {
        System.out.println("\n=== Probando Patrón Observer ===");
        
        // Obtener el OrderService del contexto
        OrderService orderService = context.getBean(OrderService.class);
        
        // Registrar observadores (Spring los inyectaría automáticamente en producción)
        // Pero para la prueba los agregamos manualmente
        OrderObserver emailObserver = context.getBean(EmailNotificationService.class);
        OrderObserver inventoryObserver = context.getBean(InventoryService.class);
        
        orderService.addObserver(emailObserver);
        orderService.addObserver(inventoryObserver);
        
        // Crear una orden de prueba
        Order order = new Order("ORD-001", 149.99, "cliente@ejemplo.com");
        
        System.out.println("Colocando orden y notificando observadores...");
        orderService.placeOrder(order);
        
        System.out.println("Prueba completada. Verifica los mensajes de notificación arriba.");
    }
    
    private static void testCachingDecorator(ConfigurableApplicationContext context) {
        DataService dataService = context.getBean(DataService.class);
        
        System.out.println("Primera llamada (debe ser lenta):");
        System.out.println(dataService.fetchData());
        
        System.out.println("Segunda llamada (debe ser rápida - cache):");
        System.out.println(dataService.fetchData());
    }
    
    private static void testSingleton(ConfigurableApplicationContext context) {
        System.out.println("\n=== Probando Singleton ===");
        ConfigurationService service = context.getBean(ConfigurationService.class);
        System.out.println("Configuración de versión: " + service.getConfig("app.version"));
    }
    
    private static void testFactoryMethod() {
        System.out.println("\n=== Probando Factory Method ===");
        PaymentService service = new PaymentService();
        PaymentMethod creditcard = service.createPaymentMethod("creditcard");
        creditcard.processPayment(BigDecimal.valueOf(100.00));
    }
    
    private static void testAdapter(ConfigurableApplicationContext context) {
        System.out.println("\n=== Probando Adapter ===");
        LegacyUserServiceAdapter adapter = context.getBean(LegacyUserServiceAdapter.class);
        System.out.println("Usuario adaptado: " + adapter.getUser("testuser"));
    }
    
    private static void testStrategy(ConfigurableApplicationContext context) {
        System.out.println("\n=== Probando Strategy ===");
        ProductService productService = context.getBean(ProductService.class);
        
        List<Product> products = List.of(
            new Product("Laptop", BigDecimal.valueOf(1200.99)),
            new Product("Mouse", BigDecimal.valueOf(25.50)),
            new Product("Teclado", BigDecimal.valueOf(59.99)),
            new Product("Monitor", BigDecimal.valueOf(299.99))
        );
        
        System.out.println("Productos ordenados por precio:");
        productService.getSortedProducts(products).forEach(System.out::println);
    }
}