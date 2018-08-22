package com.modelagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modelagem.domain.Pedido;

// essa interface vai comunicar com o banco de dados
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
