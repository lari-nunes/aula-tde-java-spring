package com.br.larissa.aulatde.service;


import com.br.larissa.aulatde.model.Pessoa;
import com.br.larissa.aulatde.model.Veiculo;
import com.br.larissa.aulatde.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    /*O Autowired (@Autowired) é a anotação mais utilizada com relação à injeção de dependências.
    Como o próprio nome diz, o Autowired, indica um ponto onde a injeção automática deve ser aplicada.
    Isso pode ser usado em métodos, atributos e construtores. */
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa gravaPessoa(Pessoa pessoa){
        if (!pessoa.getVeiculos().isEmpty()){
            for(Veiculo v : pessoa.getVeiculos()){
                v.setPessoa(pessoa);
            }
        }
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> buscaPessoa(Long id){
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> listaPessoas(){
        return pessoaRepository.findAll();
    }

    public void deletaPessoa(Optional<Pessoa> pessoa){
        pessoaRepository.delete(pessoa.get());
    }
}
