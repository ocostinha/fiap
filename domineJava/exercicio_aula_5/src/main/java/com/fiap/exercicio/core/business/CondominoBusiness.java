package com.fiap.exercicio.core.business;

import com.fiap.exercicio.domain.Condomino;

public interface CondominoBusiness {

    Condomino cadastrar(Condomino condomino);

    Condomino atualizar(Condomino condomino);

    Condomino consultarPeloCPF(String cpf);

}
