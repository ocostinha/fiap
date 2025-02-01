package com.fiap.exercicio.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CondominoEntity {

    @Id
    private String id;

    @Column
    private String nome;

    @Column
    private Integer ddd;

    @Column
    private Integer telefone;

    @Column
    private String email;

    @Column
    private String bloco;

    @Column
    private String apto;

    @Column
    private String cpf;

}
