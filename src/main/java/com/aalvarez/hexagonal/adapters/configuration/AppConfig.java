package com.aalvarez.hexagonal.adapters.configuration;

import com.aalvarez.hexagonal.application.ports.in.GetUserUseCase;
import com.aalvarez.hexagonal.application.ports.out.GetUserPort;
import com.aalvarez.hexagonal.application.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    private GetUserPort getUserPort;

    public AppConfig(GetUserPort getUserPort) {
        this.getUserPort = getUserPort;
    }

    @Bean
    public GetUserUseCase getUserUseCase(){
        return new UserService(getUserPort);
    }
}
