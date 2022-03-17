package com.trainingapp.javaconfigdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;

@PropertySource("classpath:application.properties")
@ComponentScan("com.trainingapp.javaconfigdemo")
@Configuration
public class JavaConfig {
/*
    @Scope("prototype")
    @Bean
    public Square square(){
        return new Square(6);
    }
*/

}
