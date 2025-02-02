package com.fiap.exercicio.repository.repository;

import com.fiap.exercicio.core.repository.CondominoRepository;
import com.fiap.exercicio.domain.Condomino;
import com.fiap.exercicio.repository.adapter.CondominoAdapter;
import com.fiap.exercicio.repository.jpa.CondominoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CondominoRepositoryImpl implements CondominoRepository {

    @Autowired
    private CondominoJpaRepository jpaRepository;

    private final CondominoAdapter condominoAdapter = CondominoAdapter.INSTANCE;

    @Override
    public Condomino cadastrar(final Condomino condomino) {
        return condominoAdapter.fromEntity(
                jpaRepository.save(condominoAdapter.toEntity(condomino))
        );
    }

    @Override
    public Condomino atualizar(final Condomino condomino) {
        return condominoAdapter.fromEntity(
                jpaRepository.save(condominoAdapter.toEntity(condomino))
        );
    }

    @Override
    public Optional<Condomino> consultarPeloCPF(final String cpf) {
        return Optional.ofNullable(
                condominoAdapter.fromEntity(jpaRepository.findByCpf(cpf).orElse(null))
        );
    }

    @Override
    public Optional<Condomino> consultarPeloEmail(final String email) {
        return Optional.ofNullable(
                condominoAdapter.fromEntity(jpaRepository.findByEmail(email).orElse(null)));
    }

    @Override
    public Optional<Condomino> consultarPeloId(final String id) {
        return Optional.ofNullable(
                condominoAdapter.fromEntity(jpaRepository.findById(id).orElse(null)));
    }

    @Override
    public List<Condomino> consultarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(condominoAdapter::fromEntity)
                .toList();
    }

}
