package br.com.attus.desafio.controller;

import br.com.attus.desafio.model.dto.AddressDTO;
import br.com.attus.desafio.model.dto.PersonCreateDTO;
import br.com.attus.desafio.model.dto.PersonDTO;
import br.com.attus.desafio.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address", produces = "application/json")
@Tag(name = "Address")
public class AddressController {
    @Autowired
    private AddressService service;

    @Operation(summary = "Consulta os dados de um address por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a consulta"),
    })
    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDTO> get(@PathVariable("addressId") Long id){
        return service.findById(id);
    }

    @GetMapping("/findAll")
    @Operation(summary = "Buscar todos os endereços cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar consulta")
    })
    public ResponseEntity<List<AddressDTO>> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Cadastra um endereço com os dados fornecidos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar cadastro dos dados"),
    })
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO){
        return service.create(addressDTO);
    }

    @Operation(summary = "Atualiza os dados de um endereço com os dados fornecidos", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar atualização dos dados"),
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) {
        return service.updateById(id, addressDTO);
    }
}
