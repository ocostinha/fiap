package com.fiap.exercicio.repository.adapter;

import com.fiap.exercicio.domain.Condomino;
import com.fiap.exercicio.repository.model.CondominoEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface CondominoAdapter {

    CondominoAdapter INSTANCE = getMapper(CondominoAdapter.class);

    CondominoEntity toEntity(Condomino condomino);

    Condomino fromEntity(CondominoEntity condominoEntity);

}
