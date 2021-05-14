package com.joaodesenvolvimento.carrinhocompras.repository;

import com.joaodesenvolvimento.carrinhocompras.model.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {
}
