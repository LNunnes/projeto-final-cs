package com.ufg.inf.cs.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufg.inf.cs.models.EspacoComunitarioModel;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EspacoComunitarioRepository extends JpaRepository<EspacoComunitarioModel, Long>{
    
}