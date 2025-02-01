package com.fiap.exercicio.condomino.adapter;

import com.fiap.exercicio.condomino.dto.CondominoDTO;
import com.fiap.exercicio.domain.Condomino;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface CondominoAdapter {
    CondominoAdapter INSTANCE = getMapper(CondominoAdapter.class);

    Condomino toDomain(CondominoDTO condominoDTO);

    CondominoDTO fromDomain(Condomino condomino);

}
