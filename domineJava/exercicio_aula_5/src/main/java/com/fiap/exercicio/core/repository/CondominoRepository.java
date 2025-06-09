package com.fiap.exercicio.core.repository;

import com.fiap.exercicio.domain.Condomino;

import java.util.List;
import java.util.Optional;

public interface CondominoRepository {

    Condomino cadastrar(Condomino condomino);

    Condomino atualizar(Condomino condomino);

    Optional<Condomino> consultarPeloCPF(String cpf);

    Optional<Condomino> consultarPeloEmail(String email);

    Optional<Condomino> consultarPeloId(String id);

    List<Condomino> consultarTodos();

    void remover(String id);

}
