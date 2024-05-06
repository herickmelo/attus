package br.com.attus.desafio.model.mapper;

import br.com.attus.desafio.model.dto.PersonCreateDTO;
import br.com.attus.desafio.model.dto.PersonDTO;
import br.com.attus.desafio.model.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "id", ignore = true)
    Person toObject(PersonDTO personDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    Person createToObject(PersonCreateDTO personCreateDTO);

    PersonDTO toDTO(Person person);
}
