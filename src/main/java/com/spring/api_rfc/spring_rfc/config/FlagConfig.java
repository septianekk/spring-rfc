package com.spring.api_rfc.spring_rfc.config;


import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("classpath: flag.properties")
public class FlagConfig {

    private static String flagLogging;

    public static String getFlagLogging() {
        return flagLogging;
    }

    public static void setFlagLogging(String flagLogging) {
        FlagConfig.flagLogging = flagLogging;
    }
}
