package com.br.larissa.aulatde.controller;

import com.br.larissa.aulatde.model.Veiculo;
import com.br.larissa.aulatde.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {


    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("")
    public ResponseEntity<Object> gravaVeiculo(@RequestBody  Veiculo veiculo){
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.gravarVeiculo(veiculo));
    }
}
