package com.oficinaPrime.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficinaPrime.backend.domain.enums.State;
import com.oficinaPrime.backend.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByCpf(String cpf);

    List<Client> findByUf(State uf);
}