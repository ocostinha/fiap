package com.fiap.exercicio;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condomino")
public class CondominoController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrar(@Valid @RequestBody CondominoDTO condominoDTO) {
        return "Condômino cadastrado com sucesso!";
    }

    @PutMapping
    public String atualizar(@Valid @RequestBody CondominoDTO condominoDTO) {
        return "Condômino atualizado com sucesso!";
    }

    @GetMapping("/{cpf}")
    public String consultarPeloCPF(@PathParam("cpf") String cpf) {
        return "Condômino consultado com sucesso!";
    }

}
