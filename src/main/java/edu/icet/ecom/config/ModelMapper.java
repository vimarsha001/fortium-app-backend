package edu.icet.ecom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapper {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
