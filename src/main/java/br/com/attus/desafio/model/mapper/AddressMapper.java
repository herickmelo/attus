package br.com.attus.desafio.model.mapper;

import br.com.attus.desafio.model.dto.AddressDTO;
import br.com.attus.desafio.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO toDTO(Address address);

    @Mapping(target = "id", ignore = true)
    Address toObject(AddressDTO addressDTO);

}
