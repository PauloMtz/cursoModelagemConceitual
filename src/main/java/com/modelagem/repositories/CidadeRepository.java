package com.modelagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modelagem.domain.Cidade;

// essa interface vai comunicar com o banco de dados
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
