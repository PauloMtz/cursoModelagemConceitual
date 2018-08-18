package com.modelagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modelagem.domain.Endereco;

// essa interface vai comunicar com o banco de dados
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
