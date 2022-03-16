package com.trainingapp.javaconfigdemo;

import org.springframework.context.annotation.*;

@PropertySource("classpath:application.properties")
@ComponentScan("com.trainingapp.javaconfigdemo")
@Configuration
public class JavaConfig {

    @Scope("prototype")
    @Bean
    public Square square(){
        return new Square(6);
    }


}
