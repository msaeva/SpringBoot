package com.example.mobileproject.config;

import com.example.mobileproject.domain.beans.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public LoggedUser loggedUser(){
        return new LoggedUser();
    }
}
