package com.br.larissa.aulatde.service;

import com.br.larissa.aulatde.model.Pessoa;
import com.br.larissa.aulatde.model.Produto;
import com.br.larissa.aulatde.model.Veiculo;
import com.br.larissa.aulatde.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

//    public Produto gravaProduto(Produto produto){
//        if (!produto.getClassificacao().isEmpty()){
//            for(Produto p : produto.getClassificacao()){
//                p.setClassificacao(produto);
//            }
//        }
//        return produtoRepository.save(produto);
//    }

    public Optional<Produto> buscaProduto(Long id){
        return produtoRepository.findById(id);
    }

    public List<Produto> listaProduto(){
        return produtoRepository.findAll();
    }

    public void deletaProduto(Optional<Produto> produto){
        produtoRepository.delete(produto.get());
    }
}
