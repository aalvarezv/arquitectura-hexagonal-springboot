package com.aalvarez.hexagonal.adapters.configuration;

import com.aalvarez.hexagonal.adapters.controllers.dto.PostDTO;
import com.aalvarez.hexagonal.domain.model.Post;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<PostDTO, Post>() {
            @Override
            protected void configure() {
                map().getUser().setId(source.getId_user());
            }
        });

        return modelMapper;
    }

}
