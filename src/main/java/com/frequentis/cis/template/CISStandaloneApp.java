package com.frequentis.cis.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class CISStandaloneApp {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(CISStandaloneApp.class, args);
        
    }

}
