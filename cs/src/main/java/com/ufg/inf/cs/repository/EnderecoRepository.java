package com.ufg.inf.cs.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufg.inf.cs.models.EnderecoModel;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

    @Query(value = "SELECT * FROM ENDERECOS WHERE UPPER(LOGRADOURO) LIKE UPPER(CONCAT('%', :logradouro, '%'))", nativeQuery = true)
    ArrayList<EnderecoModel> buscarPeloLogradouro(@Param("logradouro") String logradouro);
    
}
