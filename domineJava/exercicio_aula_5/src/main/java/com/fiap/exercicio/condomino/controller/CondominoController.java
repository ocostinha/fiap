package com.fiap.exercicio.condomino.controller;

import com.fiap.exercicio.condomino.adapter.CondominoAdapter;
import com.fiap.exercicio.condomino.dto.CondominoDTO;
import com.fiap.exercicio.core.business.CondominoBusiness;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/condomino")
public class CondominoController {

    @Autowired
    private CondominoBusiness condominoBusiness;

    private final CondominoAdapter condominoAdapter = CondominoAdapter.INSTANCE;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CondominoDTO cadastrar(@Valid @RequestBody CondominoDTO condominoDTO) {
        return condominoAdapter.fromDomain(
                condominoBusiness.cadastrar(condominoAdapter.toDomain(condominoDTO))
        );
    }

    @PutMapping("/{id}")
    public CondominoDTO atualizar(@PathVariable final String id,
                                  @Valid @RequestBody CondominoDTO condominoDTO) {
        condominoDTO.setId(id);

        return condominoAdapter.fromDomain(
                condominoBusiness.atualizar(condominoAdapter.toDomain(condominoDTO))
        );
    }

    @GetMapping("/filtro/{cpf}")
    public CondominoDTO consultarPeloCPF(@PathVariable final String cpf) {
        return condominoAdapter.fromDomain(
            condominoBusiness.consultarPeloCPF(cpf)
        );
    }

    @GetMapping("/{id}")
    public CondominoDTO consultarPeloId(@PathVariable final String id) {
        return condominoAdapter.fromDomain(
            condominoBusiness.consultarPorId(id)
        );
    }

    @GetMapping
    public List<CondominoDTO> consultarTodos() {
        return condominoBusiness.consultarTodos()
                .stream()
                .map(condominoAdapter::fromDomain)
                .toList();
    }

}
