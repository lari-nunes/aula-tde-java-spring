package com.br.larissa.aulatde.service;

import com.br.larissa.aulatde.model.Classificacao;
import com.br.larissa.aulatde.model.Produto;
import com.br.larissa.aulatde.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClassificacaoService {

    @Autowired
    private ClassificacaoRepository classificacaoRepository;

    public Optional<Classificacao> buscaClassificacaoId(Long id){
        return classificacaoRepository.findById(id);
    }

    public List<Classificacao> buscaClassificacoes(){
        return classificacaoRepository.findAll();
    }

    public void deletaClassificacao(Optional<Classificacao> classificacao){
        classificacaoRepository.delete(classificacao.get());
    }
}
