package com.bunlysem.lis.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI lisOpenApi() {
        return new OpenAPI().info(new Info()
                .title("LIS API")
                .version("v1")
                .description("Laboratory Information System API for patients, laboratory tests, and results."));
    }
}
