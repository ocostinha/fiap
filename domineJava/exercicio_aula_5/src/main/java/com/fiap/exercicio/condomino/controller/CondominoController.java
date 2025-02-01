package com.fiap.exercicio.condomino.controller;

import com.fiap.exercicio.condomino.adapter.CondominoAdapter;
import com.fiap.exercicio.condomino.dto.CondominoDTO;
import com.fiap.exercicio.core.business.CondominoBusiness;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public CondominoDTO atualizar(@PathParam("id") String id,
                                  @Valid @RequestBody CondominoDTO condominoDTO) {
        condominoDTO.setId(id);

        return condominoAdapter.fromDomain(
                condominoBusiness.atualizar(condominoAdapter.toDomain(condominoDTO))
        );
    }

    @GetMapping("/{cpf}")
    public CondominoDTO consultarPeloCPF(@PathParam("cpf") String cpf) {
        return condominoAdapter.fromDomain(
                condominoBusiness.consultarPeloCPF(cpf)
        );
    }

}
