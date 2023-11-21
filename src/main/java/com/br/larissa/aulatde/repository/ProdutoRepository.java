package com.br.larissa.aulatde.repository;

import com.br.larissa.aulatde.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
