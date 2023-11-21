package com.br.larissa.aulatde.repository;

import com.br.larissa.aulatde.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*A anotação @Repository é utilizada para indicar que uma classe é responsável
por acessar e manipular db ou em outra fonte de dados externa.
 Em outras palavras, ela é utilizada para indicar que a classe é um repositório de dados.*/
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
