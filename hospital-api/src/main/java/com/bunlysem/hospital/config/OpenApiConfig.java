package com.bunlysem.hospital.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI hospitalOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Hospital API")
                .version("v1")
                .description("Hospital API for patient management and healthcare payloads."));
    }
}
