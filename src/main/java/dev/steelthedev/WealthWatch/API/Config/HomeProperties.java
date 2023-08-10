package dev.steelthedev.WealthWatch.API.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public record HomeProperties (
        String welcomeMessage, String about, String version
){
}
