package br.com.attus.desafio.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String state;
    private String city;
    private String street;
    private String number;
    private Boolean isMainAddress;

    @Column(nullable = false)
    private Long idPerson;
}