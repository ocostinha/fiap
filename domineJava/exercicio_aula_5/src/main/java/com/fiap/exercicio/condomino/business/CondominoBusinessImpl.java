package com.fiap.exercicio.condomino.business;

import com.fiap.exercicio.core.business.CondominoBusiness;
import com.fiap.exercicio.core.exception.BusinessException;
import com.fiap.exercicio.core.exception.NotFoundException;
import com.fiap.exercicio.core.repository.CondominoRepository;
import com.fiap.exercicio.domain.Condomino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class CondominoBusinessImpl implements CondominoBusiness {

    @Autowired
    private CondominoRepository condominoRepository;

    @Override
    public Condomino cadastrar(final Condomino condomino) {
        condominoRepository.consultarPeloCPF(condomino.getCpf())
                .ifPresent(_ -> {
                    throw new BusinessException("CPF já cadastrado");
                });

        condominoRepository.consultarPeloEmail(condomino.getEmail())
                .ifPresent(_ -> {
                    throw new BusinessException("Email já cadastrado");
                });

        condomino.setId(UUID.randomUUID().toString());

        return condominoRepository.cadastrar(condomino);
    }

    @Override
    public Condomino atualizar(final Condomino condomino) {
        Condomino condominoCadastrado = condominoRepository.consultarPeloId(condomino.getId())
                .orElseThrow(() -> new BusinessException("Condômino não encontrado"));

        if (!Objects.equals(condominoCadastrado.getEmail(), condomino.getEmail())) {
            condominoRepository.consultarPeloEmail(condomino.getEmail())
                    .ifPresent(_ -> {
                        throw new BusinessException("Email já cadastrado");
                    });
        }

        if (!Objects.equals(condominoCadastrado.getCpf(), condomino.getCpf())) {
            condominoRepository.consultarPeloCPF(condomino.getCpf())
                    .ifPresent(_ -> {
                        throw new BusinessException("CPF já cadastrado");
                    });
        }

        return condominoRepository.atualizar(condomino);
    }

    @Override
    public Condomino consultarPeloCPF(final String cpf) {
        return condominoRepository.consultarPeloCPF(cpf)
                .orElseThrow(() -> new NotFoundException("Condômino não encontrado"));
    }

}
