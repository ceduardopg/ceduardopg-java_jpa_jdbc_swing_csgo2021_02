package br.edu.ifsul.lpoo.cs.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */

@Entity
@Table(name = "tb_arma")
@DiscriminatorValue("A")
public class Arma extends Artefato {
    
    @Column(precision = 2, nullable = true)
    private Float comprimento_cano;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    
    @ManyToMany
    @JoinTable(name = "tb_arma_municao", joinColumns = {@JoinColumn(name = "artefato_id")},
                                       inverseJoinColumns = {@JoinColumn(name = "municao_id")})
    private List<Municao> municoes;
        
    public Arma(){
        
    }

    public Float getComprimento_cano() {
        return comprimento_cano;
    }

    public void setComprimento_cano(Float comprimento_cano) {
        this.comprimento_cano = comprimento_cano;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Municao> getMunicoes() {
        return municoes;
    }

    public void setMunicoes(List<Municao> municoes) {
        this.municoes = municoes;
    }
    
}