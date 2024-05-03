package br.com.attus.desafio.config;

import br.com.attus.desafio.model.mapper.PersonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public PersonMapper modelMapper() {
        return PersonMapper.INSTANCE;
    }
}