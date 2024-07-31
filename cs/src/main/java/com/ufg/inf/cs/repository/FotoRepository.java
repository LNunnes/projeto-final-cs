package com.ufg.inf.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufg.inf.cs.models.FotoModel;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface FotoRepository extends JpaRepository<FotoModel, Long> {
    List<FotoModel> findByRepublicaId(Long republicaId);
}