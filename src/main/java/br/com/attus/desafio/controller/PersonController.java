package br.com.attus.desafio.controller;

import br.com.attus.desafio.model.dto.PersonDTO;
import br.com.attus.desafio.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person", produces = "application/json")
@Tag(name = "Person")
public class PersonController {
    @Autowired
    private PersonService service;

    @Operation(summary = "Consulta os dados de uma pessoa por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a consulta"),
    })
    @GetMapping("/{personId}")
    public PersonDTO get(@PathVariable("personId") Long id){
        return service.findById(id);
    }

    /*@Operation(summary = "Atualiza um orçamento com os dados fornecidos", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar atualização dos dados"),
    })
    @PutMapping("/budget/{insuranceId}")
    public PersonDTO update(@PathVariable("insuranceId") Long id, @RequestBody PersonDTO insurance){
        return service.updateById(id, insurance);
    }

    @Operation(summary = "Cadastra um orçamento com os dados fornecidos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar cadastro dos dados"),
    })
    @PostMapping(path = "/budget", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO create(@RequestBody PersonDTO insurance){
        return service.create(insurance);
    }

    @Operation(summary = "Remove um orçamento com os dados fornecidos", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Remoção realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar remoção dos dados"),
    })
    @DeleteMapping("/budget/{insuranceId}")
    public void delete(@PathVariable("insuranceId") Long id){
        service.deleteById(id);
    }*/
}