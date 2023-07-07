package com.aalvarez.hexagonal.adapters.configuration;

import com.aalvarez.hexagonal.adapters.persistence.JpaUserRepositoryAdapter;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaPostRepository;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaUserRepository;
import com.aalvarez.hexagonal.application.ports.out.GetUserPort;
import com.aalvarez.hexagonal.application.ports.out.SaveUserPort;
import com.aalvarez.hexagonal.application.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@ComponentScan(basePackages = "com.aalvarez.hexagonal")
public class AppConfig {

    @Bean("UserService")
    public UserService userService(GetUserPort getUserPort, SaveUserPort saveUserPort){
        return new UserService(getUserPort, saveUserPort);
    }

    @Bean("JpaUserRepositoryAdapter")
    public JpaUserRepositoryAdapter jpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository, ModelMapper modelMapper){
        return new JpaUserRepositoryAdapter(jpaUserRepository, modelMapper);
    }

}
