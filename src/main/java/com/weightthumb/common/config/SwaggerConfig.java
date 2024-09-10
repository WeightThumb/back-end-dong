package com.weightthumb.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private static final String REFERENCE = "Authorization";

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("default")
                .packagesToScan("com.weightthumb")
                .addOpenApiCustomizer(openApiCustomizer())
                .build();
    }

    private OpenApiCustomizer openApiCustomizer() {
        return openApi -> {
            openApi.info(new Info().title("건강 웹 만들기")
                    .version("v1")
                    .description("일단 공부하면서 인아웃을 따라해보자")
                    .contact(new Contact().name("권동휘").email("hocci0222@kakao.com"))
            );
            openApi.addSecurityItem(new SecurityRequirement().addList(REFERENCE));
            openApi.components(new Components()
                    .addSecuritySchemes(REFERENCE, new SecurityScheme()
                            .name(REFERENCE)
                            .type(SecurityScheme.Type.HTTP)
                            .in(SecurityScheme.In.HEADER)
                            .scheme("Bearer")
                            .name("Authorization Bearer도 붙여라^^")
                    )
                    .addSchemas("KakaoLoginParams", new Schema<>().$ref("#/components/schemas/KakaoLoginParams"))
                    .addSchemas("AuthTokens", new Schema<>().$ref("#/components/schemas/AuthTokens"))
                    .addSchemas("Member", new Schema<>().$ref("#/components/schemas/Member"))
            );
        };
    }
}
