package com.joaodesenvolvimento.carrinhocompras.repository;

import com.joaodesenvolvimento.carrinhocompras.model.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Long> {
}
