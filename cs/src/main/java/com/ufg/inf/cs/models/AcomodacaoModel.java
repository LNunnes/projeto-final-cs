package com.ufg.inf.cs.models;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACOMODACOES")
@SequenceGenerator(name = "SEQ_ACOMODACOES", sequenceName = "SEQ_ACOMODACOES", allocationSize = 1, initialValue = 1)
public class AcomodacaoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACOMODACOES")
    private Long id;

    @Column(nullable = false)
    private int capacidade;

    @Column(nullable = false)
    private char status = 'L';

    @Column(nullable = false)
    private int numeroOcupantes = 0;

    @ManyToOne(targetEntity = RepublicaModel.class)
	@JoinColumn(
            name = "REPUBLICA_ID", 
            nullable = false, 
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_ACOMODACOES_REPUBLICA_ID")
    )
    private RepublicaModel republica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getNumeroOcupantes() {
        return numeroOcupantes;
    }

    public void setNumeroOcupantes(int numeroOcupantes) {
        this.numeroOcupantes = numeroOcupantes;
    }

    public RepublicaModel getRepublica() {
        return republica;
    }

    public void setRepublica(RepublicaModel republica) {
        this.republica = republica;
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
        AcomodacaoModel other = (AcomodacaoModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
