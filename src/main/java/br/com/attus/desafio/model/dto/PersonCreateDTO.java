package br.com.attus.desafio.model.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonCreateDTO {
    private String name;
    private LocalDate birthDate;
}
