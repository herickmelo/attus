package br.com.attus.desafio.service;

import br.com.attus.desafio.exception.PersonException;
import br.com.attus.desafio.model.dto.AddressDTO;
import br.com.attus.desafio.model.entity.Address;
import br.com.attus.desafio.model.entity.Person;
import br.com.attus.desafio.model.mapper.AddressMapper;
import br.com.attus.desafio.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    @Autowired
    private AddressMapper addressMapper;

    public ResponseEntity<AddressDTO> findById(Long id){
        Optional<Address> optAddress = repository.findById(id);
        return optAddress.map(address -> ResponseEntity.status(HttpStatus.OK).body(addressMapper.toDTO(address)))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    public ResponseEntity<List<AddressDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll().stream().map(address -> addressMapper.toDTO(address))
                .collect(Collectors.toList()));
    }

    public ResponseEntity<AddressDTO> create(AddressDTO addressDTO) {
        var addressToSave = addressMapper.toObject(addressDTO);
        var addressSaved = repository.save(addressToSave);
        return ResponseEntity.status(HttpStatus.OK).body(addressMapper.toDTO(addressSaved));
    }

    public ResponseEntity<AddressDTO> updateById(Long id, AddressDTO addressDTO) {
        Optional<Address> optAddress = repository.findById(id);
        if (optAddress.isPresent()){
            var address = Address.builder()
                    .id(id)
                    .cep(addressDTO.getCep())
                    .state(addressDTO.getState())
                    .city(addressDTO.getCity())
                    .street(addressDTO.getStreet())
                    .number(addressDTO.getNumber())
                    .isMainAddress(addressDTO.getIsMainAddress())
                    .idPerson(addressDTO.getIdPerson())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(addressMapper.toDTO(repository.save(address)));
        }else {
            return ResponseEntity.noContent().build();
        }
    }
}
