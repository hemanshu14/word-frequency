package com.ordina.assignment.wordfrequencyanalyzer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = { "com.ordina.assignment.wordfrequencyanalyzer.*" })
@OpenAPIDefinition( //
        info = @Info(title = "Word Frequency Analyzer Service", //
                description = "<p>Services which provide you the ability to find the Frequency of words in a given sentence</p>"))
public class WordfrequencyanalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordfrequencyanalyzerApplication.class, args);
    }

}
