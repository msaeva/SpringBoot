package com.example.mobileproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
