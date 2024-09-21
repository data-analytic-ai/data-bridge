package com.fordevs.databridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
		"com.fordevs.databridge.config",
		"com.fordevs.databridge.processor"
})
public class DataBridgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataBridgeApplication.class, args);
    }

}
