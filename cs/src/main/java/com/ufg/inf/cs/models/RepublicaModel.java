package com.ufg.inf.cs.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "REPUBLICAS")
@SequenceGenerator(name = "SEQ_REPUBLICAS", sequenceName = "SEQ_REPUBLICAS", allocationSize = 1, initialValue = 1)
public class RepublicaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REPUBLICAS")
    private Long id;
    
    @Column(nullable = false)
    private int numeroQuartos;

    @Column(nullable = false)
    private int numeroOcupantes = 0;

    @Column(nullable = false)
    private Double valorMensal;

    @OneToOne(targetEntity = EnderecoModel.class, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "ENDERECO_ID", 
            nullable = false, 
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_REPUBLICAS_ENDERECO_ID")
    )
    private EnderecoModel endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public int getNumeroOcupantes() {
        return numeroOcupantes;
    }

    public void setNumeroOcupantes(int numeroOcupantes) {
        this.numeroOcupantes = numeroOcupantes;
    }

    public Double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RepublicaModel other = (RepublicaModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
