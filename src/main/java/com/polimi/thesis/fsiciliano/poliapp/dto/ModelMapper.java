package com.polimi.thesis.fsiciliano.poliapp.dto;

import com.polimi.thesis.fsiciliano.poliapp.dto.event.EventMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapper {

    @Bean
    public EventMapperImpl eventMapper() {
        return new EventMapperImpl();
    }
}
