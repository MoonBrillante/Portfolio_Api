package com.Portfolio_Api.config;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(@NotNull CorsRegistry registry ){
        registry
                .addMapping("/api/v1/projects") // Ruta de la API
                .allowedOrigins("http://localhost:5173") // Corrige la URL del origen permitido
                .allowedMethods("GET", "POST","PUT", "DELETE") // Metodos http permitidos
                .allowCredentials(true)  // Permitir cookies y encabezados personalizados
                .maxAge(3688); // Duracion en segundos para mantener la configuracion de CORS en chaché en el navegador
    }}

