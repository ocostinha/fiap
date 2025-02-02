package com.fiap.exercicio;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/condomino")
public class CondominoController {

    @Autowired
    private CondominoRepository condominoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrar(@Valid @RequestBody CondominoDTO condominoDTO) {
        condominoDTO.setId(UUID.randomUUID().toString());

        condominoRepository.findByCpf(condominoDTO.getCpf())
                .ifPresent(_ -> {
                    throw new IllegalArgumentException("CPF já cadastrado");
                });

        condominoRepository.findByEmail(condominoDTO.getEmail())
                .ifPresent(_ -> {
                    throw new IllegalArgumentException("Email já cadastrado");
                });

        CondominoEntity condominoEntity = new CondominoEntity(condominoDTO);

        condominoRepository.save(condominoEntity);

        return "Condômino cadastrado com sucesso!";
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable("id") String id,
                            @Valid @RequestBody CondominoDTO condominoDTO) {
        condominoDTO.setId(id);

        CondominoEntity condominoCadastrado = condominoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Condômino não encontrado"));

        if (!Objects.equals(condominoCadastrado.getEmail(), condominoDTO.getEmail())) {
            condominoRepository.findByEmail(condominoDTO.getEmail())
                    .ifPresent(_ -> {
                        throw new IllegalArgumentException("Email já cadastrado");
                    });
        }

        if (!Objects.equals(condominoCadastrado.getCpf(), condominoDTO.getCpf())) {
            condominoRepository.findByCpf(condominoDTO.getCpf())
                    .ifPresent(_ -> {
                        throw new IllegalArgumentException("CPF já cadastrado");
                    });
        }

        CondominoEntity condominoEntity = new CondominoEntity(condominoDTO);

        condominoRepository.save(condominoEntity);

        return "Condômino atualizado com sucesso!";
    }

    @GetMapping("/{cpf}")
    public CondominoDTO consultarPeloCPF(@PathVariable final String cpf) {
        CondominoEntity condominoEntity = condominoRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Condômino não encontrado"));

        return new CondominoDTO(condominoEntity);
    }

    @GetMapping
    public List<CondominoDTO> consultarTodos() {
        List<CondominoEntity> condominosEntity = condominoRepository.findAll();
        List<CondominoDTO> condominoDTOS = new ArrayList<>();

        condominosEntity.forEach(
                condomino -> condominoDTOS.add(new CondominoDTO(condomino))
        );

        return condominoDTOS;
    }

}
