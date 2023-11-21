package com.br.larissa.aulatde.controller;

import com.br.larissa.aulatde.model.Pessoa;
import com.br.larissa.aulatde.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Object> gravaPessoa(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.gravaPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> todasPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listaPessoas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> pessoaCodigo(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscaPessoa(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizaPessoa(@PathVariable(value = "id") Long id, @RequestBody Pessoa p1) {

        Optional<Pessoa> p = pessoaService.buscaPessoa(id);
        if (p.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado !");
        }

        Pessoa pessoa = p.get();
        pessoa.setNome(p1.getNome());
        pessoa.setCpf(p1.getCpf());
        //BeanUtils.copyProperties(p1, pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.gravaPessoa(pessoa));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaPessoa(@PathVariable(value = "id") Long id) {

        Optional<Pessoa> p = pessoaService.buscaPessoa(id);
        if (p.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado !");
        }

        pessoaService.deletaPessoa(p);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso !");

    }
}
