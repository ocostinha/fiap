package com.fiap.exercicio.condomino.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CondominoDTO {

    private String id;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String nome;

    @NotNull
    @Size(min = 2, max = 2)
    private Integer ddd;

    @NotNull
    @Size(min = 8, max = 9)
    private Integer telefone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 1, max = 4)
    private String bloco;

    @NotBlank
    @Size(min = 1, max = 4)
    private String apto;

    @NotBlank
    @Size(min = 11, max = 11, message = "Informe os 11 dígitos do CPF sem formatação")
    private String cpf;

}
