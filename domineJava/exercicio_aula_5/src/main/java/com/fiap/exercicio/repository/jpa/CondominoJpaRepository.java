package com.fiap.exercicio.repository.jpa;

import com.fiap.exercicio.repository.model.CondominoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CondominoJpaRepository extends JpaRepository<CondominoEntity, String> {

    Optional<CondominoEntity> findByCpf(String cpf);

    Optional<CondominoEntity> findByEmail(String email);

}
