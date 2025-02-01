package com.fiap.exercicio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CondominoRepository extends JpaRepository<CondominoEntity, String> {

    Optional<CondominoEntity> findByCpf(String cpf);

    Optional<CondominoEntity> findByEmail(String email);

}
