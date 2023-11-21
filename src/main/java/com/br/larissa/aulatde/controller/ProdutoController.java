package com.br.larissa.aulatde.controller;

import com.br.larissa.aulatde.model.Pessoa;
import com.br.larissa.aulatde.model.Produto;
import com.br.larissa.aulatde.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> todaosProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listaProduto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> produtoCodigo(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscaProduto(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaProduto(@PathVariable(value = "id") Long id) {

        Optional<Produto> produto = produtoService.buscaProduto(id);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado !");
        }

        produtoService.deletaProduto(produto);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso !");

    }

}
