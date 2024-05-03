package br.com.attus.desafio.service;

import br.com.attus.desafio.model.dto.PersonDTO;
import br.com.attus.desafio.model.entity.Person;
import br.com.attus.desafio.model.mapper.PersonMapper;
import br.com.attus.desafio.repository.AddressRepository;
import br.com.attus.desafio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonMapper personMapper;

    public PersonDTO findById(Long id){
        Optional<Person> optPerson = repository.findById(id);
        if (optPerson.isEmpty()){
            //TODO: throw new Exception();
        }
        return personMapper.toDTO(optPerson.get());
    }
}