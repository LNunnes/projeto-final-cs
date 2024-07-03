package com.ufg.inf.cs.models;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "FOTOS")
@SequenceGenerator(sequenceName = "SEQ_FOTOS", name = "SEQ_FOTOS", allocationSize = 1, initialValue = 1)
public class FotoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FOTOS")
    private Long id;

    @Column(nullable = false)
    private String descricao;
    
    @Lob
    private byte[] arquivo;
    
    @ManyToOne(targetEntity = RepublicaModel.class)
    @JoinColumn(
        name = "REPUBLICA_ID",
        nullable = false, 
        foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_FOTOS_REPUBLICA_ID")
    )
    private RepublicaModel republica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
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
        FotoModel other = (FotoModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
}
