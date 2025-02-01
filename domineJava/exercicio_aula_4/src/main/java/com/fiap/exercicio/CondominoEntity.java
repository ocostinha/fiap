package com.fiap.exercicio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
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

    public CondominoEntity() {

    }

    public CondominoEntity(CondominoDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.ddd = dto.getDdd();
        this.telefone = dto.getTelefone();
        this.email = dto.getEmail();
        this.bloco = dto.getBloco();
        this.apto = dto.getApto();
        this.cpf = dto.getCpf();
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
