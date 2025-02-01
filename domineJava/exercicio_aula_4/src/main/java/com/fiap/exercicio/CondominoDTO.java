package com.fiap.exercicio;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    public CondominoDTO(final CondominoEntity condominoEntity) {
        this.id = condominoEntity.getId();
        this.nome = condominoEntity.getNome();
        this.ddd = condominoEntity.getDdd();
        this.telefone = condominoEntity.getTelefone();
        this.email = condominoEntity.getEmail();
        this.bloco = condominoEntity.getBloco();
        this.apto = condominoEntity.getApto();
        this.cpf = condominoEntity.getCpf();
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
