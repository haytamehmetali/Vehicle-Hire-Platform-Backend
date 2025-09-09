package owl.vehiclehireplatform.config;

import lombok.extern.slf4j.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;

@Configuration
@Slf4j
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(req -> {
			req.requestMatchers(
					   "/swagger-ui/**", "/api-docs/**")
			   .permitAll()
			   .anyRequest().permitAll();
		});
		http.csrf(AbstractHttpConfigurer::disable);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
