package owl.vehiclehireplatform.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.*;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.components(new Components()
						            .addSecuritySchemes("bearer-token",
						                                new SecurityScheme()
								                                .type(SecurityScheme.Type.HTTP)
								                                .scheme("bearer")
								                                .bearerFormat("JWT")
						            ))
				.info(new Info()
						      .title("Vehicle-Hire-Platform")
						      .description("Vehicle-Hire-Platform RestAPI")
						      .version("2025-0001"))
				.addSecurityItem(new SecurityRequirement().addList("bearer-token"));
	}
}
