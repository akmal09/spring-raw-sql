package com.raw.springsql.configuration;

import com.raw.springsql.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {

//    @Bean
//    public AddressService employeeBean(){
//        return new AddressService();
//    }

    @Bean
    public ModelMapper modeMapperBean(){
        return new ModelMapper();
    }
}
