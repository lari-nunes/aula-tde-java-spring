package com.br.larissa.aulatde.service;

import com.br.larissa.aulatde.repository.VeiculoRepository;
import com.br.larissa.aulatde.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo gravarVeiculo(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> buscarTudo(){
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscaId(Long id){
        return veiculoRepository.findById(id);
    }

    public void deletaVeiculo(Optional<Veiculo> veiculo){
        veiculoRepository.delete(veiculo.get());
    }
}
