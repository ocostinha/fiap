package com.fiap.exercicio;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/condomino")
public class CondominoController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CondominoDTO cadastrar(@Valid @RequestBody CondominoDTO condominoDTO) {
        return condominoDTO;
    }

    @PutMapping("/{id}")
    public CondominoDTO atualizar(@PathVariable final String id,
                                  @Valid @RequestBody CondominoDTO condominoDTO) {
        return condominoDTO;
    }

    @GetMapping("/{cpf}")
    public CondominoDTO consultarPeloCPF(@PathVariable final String cpf) {
        return new CondominoDTO();
    }

    @GetMapping
    public List<CondominoDTO> consultarTodos() {
        return new ArrayList<>();
    }

}
