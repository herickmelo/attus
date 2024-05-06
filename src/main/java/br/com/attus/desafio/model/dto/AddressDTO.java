package br.com.attus.desafio.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressDTO {
    private String cep;
    private String state;
    private String city;
    private String street;
    private String number;
    private Boolean isMainAddress;
    private Long idPerson;
}
