package com.riwi.filtro.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
  title = "API to filter",
  version = "1.0",
  description = "Documentation to the API"
))
public class OpenApiConfig {

}
