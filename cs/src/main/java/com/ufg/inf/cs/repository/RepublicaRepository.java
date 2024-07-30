package com.ufg.inf.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufg.inf.cs.models.RepublicaModel;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RepublicaRepository extends JpaRepository<RepublicaModel, Long> {

    
} 
