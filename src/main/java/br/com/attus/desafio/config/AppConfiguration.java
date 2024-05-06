package br.com.attus.desafio.config;

import br.com.attus.desafio.model.mapper.AddressMapper;
import br.com.attus.desafio.model.mapper.PersonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public PersonMapper personMapper() {
        return PersonMapper.INSTANCE;
    }

    @Bean
    public AddressMapper addressMapper() {
        return AddressMapper.INSTANCE;
    }
}