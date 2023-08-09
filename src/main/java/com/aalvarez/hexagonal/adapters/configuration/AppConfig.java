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

    @Bean()
    public UserService userService(GetUserPort getUserPort, SaveUserPort saveUserPort, JpaUserRepository jpaUserRepository){
        return new UserService(getUserPort, saveUserPort, jpaUserRepository);
    }

    @Bean()
    public JpaUserRepositoryAdapter jpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository, ModelMapper modelMapper){
        return new JpaUserRepositoryAdapter(jpaUserRepository, modelMapper);
    }

}
