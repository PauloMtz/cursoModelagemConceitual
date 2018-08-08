package com.modelagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modelagem.domain.Produto;

// essa interface vai comunicar com o banco de dados
// essa classe foi copiada da classe CategoriaRepository
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
