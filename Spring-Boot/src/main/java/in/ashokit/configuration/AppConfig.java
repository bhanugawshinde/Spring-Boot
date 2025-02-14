package in.ashokit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.ashokit.security.AppSecurity;

@Configuration
public class AppConfig {

	@Bean
	AppSecurity getAppSecurity() {
		AppSecurity appSecurity = new AppSecurity();
		return appSecurity;
	}
}
