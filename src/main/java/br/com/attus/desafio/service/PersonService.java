package br.com.attus.desafio.service;

import br.com.attus.desafio.exception.PersonException.*;
import br.com.attus.desafio.model.dto.PersonCreateDTO;
import br.com.attus.desafio.model.dto.PersonDTO;
import br.com.attus.desafio.model.entity.Person;
import br.com.attus.desafio.model.mapper.PersonMapper;
import br.com.attus.desafio.repository.AddressRepository;
import br.com.attus.desafio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonMapper personMapper;

    public ResponseEntity<PersonDTO> findById(Long id){
        Optional<Person> optPerson = repository.findById(id);
        return optPerson.map(person -> ResponseEntity.status(HttpStatus.OK).body(personMapper.toDTO(person)))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    public ResponseEntity<List<PersonDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll().stream().map(person -> personMapper.toDTO(person))
                .collect(Collectors.toList()));
    }

    public ResponseEntity<PersonDTO> create(PersonCreateDTO personCreateDTO) {
        var personToSave = personMapper.createToObject(personCreateDTO);
        var personSaved = repository.save(personToSave);
        return ResponseEntity.status(HttpStatus.OK).body(personMapper.toDTO(personSaved));
    }

    public ResponseEntity<PersonDTO> updateById(Long id, PersonCreateDTO personCreateDTO) {
        Optional<Person> optPerson = repository.findById(id);
        if (optPerson.isPresent()){
            var person = Person.builder()
                    .id(id)
                    .name(personCreateDTO.getName())
                    .birthDate(personCreateDTO.getBirthDate())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(personMapper.toDTO(repository.save(person)));
        }else {
            throw new PersonNotFoundException(id);
        }
    }
}