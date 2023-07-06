package com.aalvarez.hexagonal.adapters.configuration;

import com.aalvarez.hexagonal.application.ports.in.GetUserUseCase;
import com.aalvarez.hexagonal.application.ports.out.GetUserPort;
import com.aalvarez.hexagonal.application.ports.out.SaveUserPort;
import com.aalvarez.hexagonal.application.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private GetUserPort getUserPort;
    private SaveUserPort saveUserPort;

    public AppConfig(GetUserPort getUserPort,
                     SaveUserPort saveUserPort) {
        this.getUserPort = getUserPort;
        this.saveUserPort = saveUserPort;
    }

    @Bean
    public GetUserUseCase getUserUseCase(){
        return new UserService(getUserPort, saveUserPort);
    }
}
