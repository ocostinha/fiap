package com.fiap.exercicio.core.business;

import com.fiap.exercicio.domain.Condomino;

import java.util.List;

public interface CondominoBusiness {

    Condomino cadastrar(Condomino condomino);

    Condomino atualizar(Condomino condomino);

    Condomino consultarPeloCPF(String cpf);

    List<Condomino> consultarTodos();

}
