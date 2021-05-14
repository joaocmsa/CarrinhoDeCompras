package com.joaodesenvolvimento.carrinhocompras.repository;

import com.joaodesenvolvimento.carrinhocompras.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
