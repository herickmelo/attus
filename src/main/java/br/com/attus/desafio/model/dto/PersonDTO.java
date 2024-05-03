package br.com.attus.desafio.model.dto;

import br.com.attus.desafio.model.entity.Address;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonDTO {
    private String name;
    private LocalDate birthDate;
    private List<Address> addresses;
}