package com.br.larissa.aulatde.controller;

import com.br.larissa.aulatde.model.Classificacao;
import com.br.larissa.aulatde.model.Produto;
import com.br.larissa.aulatde.service.ClassificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classificacoes")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoService classificacaoService;

    @GetMapping
    public ResponseEntity<List<Classificacao>> todasClassificacoes(){
        return ResponseEntity.status(HttpStatus.OK).body(classificacaoService.buscaClassificacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> classificacaoId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(classificacaoService.buscaClassificacaoId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaClassificacaoId(@PathVariable(value = "id") Long id) {

        Optional<Classificacao> classificacao = classificacaoService.buscaClassificacaoId(id);
        if (classificacao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado !");
        }
        classificacaoService.deletaClassificacao(classificacao);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso !");

    }
}
