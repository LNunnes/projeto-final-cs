package com.ufg.inf.cs.repository;

import com.ufg.inf.cs.models.UsuarioModel;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Query(value = "SELECT * FROM USUARIOS WHERE TIPO_CONTA = 'R' AND REPUBLICA_ID = :republicaId", nativeQuery = true)
    List<UsuarioModel> listarResidentes(@Param("republicaId") Long republicaId);

    @Query(value = "SELECT * FROM USUARIOS WHERE TIPO_CONTA = 'G' AND REPUBLICA_ID = :republicaId", nativeQuery = true)
    List<UsuarioModel> listarGerentes(@Param("republicaId") Long republicaId);
}
