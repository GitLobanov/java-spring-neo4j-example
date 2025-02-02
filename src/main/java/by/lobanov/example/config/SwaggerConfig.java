package by.lobanov.example.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(
            @Value("${APPLICATION_NAME:SCIENCE-SERVICE}") String appName,
            @Value("${APPLICATION_DESCRIPTION: Science publication project}") String appDescription,
            @Value("${APPLICATION_VERSION: 0.0.1-SNAPSHOT}") String appVersion) {

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("ApiKeyAuth"))
                .components(new Components().addSecuritySchemes("ApiKeyAuth",
                        new SecurityScheme()
                                .name("Authorization")
                                .in(SecurityScheme.In.HEADER)
                                .type(SecurityScheme.Type.APIKEY)))
                .info(new Info().title(appName)
                        .version(appVersion)
                        .description(appDescription));
    }
}
