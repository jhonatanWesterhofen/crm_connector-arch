package com.hubspot.integration.crm_connector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author Jhonatan
 */
@SpringBootApplication
@EnableFeignClients
public class CrmConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmConnectorApplication.class, args);
    }

}
