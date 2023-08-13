package dev.steelthedev.WealthWatch.API;

import dev.steelthedev.WealthWatch.API.Config.HomeProperties;
import dev.steelthedev.WealthWatch.API.Config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableConfigurationProperties({RsaKeyProperties.class, HomeProperties.class})
@SpringBootApplication
public class WealthWatchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WealthWatchApiApplication.class, args);
	}

}
