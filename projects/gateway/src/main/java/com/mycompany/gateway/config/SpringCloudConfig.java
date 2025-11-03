package com.mycompany.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    
    @Bean
    /**
     * Configura y crea las rutas personalizadas para el API Gateway.
     * <p>
     * Este método define un bean de tipo {@link RouteLocator} que contiene las reglas
     * de enrutamiento. Utiliza {@link RouteLocatorBuilder} para mapear patrones de URL
     * de las peticiones entrantes a las URIs de los microservicios de destino.
     * <p>
     * Rutas definidas:
     * <ul>
     *     <li>Cualquier petición a {@code /price/**} es redirigida al servicio de precios.</li>
     *     <li>Cualquier petición a {@code /inventory/**} es redirigida al servicio de inventario.</li>
     * </ul>
     *
     * @param builder El constructor de rutas inyectado por Spring para definir las reglas de enrutamiento.
     * @return Un bean {@link RouteLocator} con todas las rutas configuradas para que Spring las gestione.
     */
    public RouteLocator buildRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/price/**").uri("http://localhost:8002"))
                .route(r -> r.path("/inventory/**").uri("http://localhost:8003"))
                .build();
    }
}
