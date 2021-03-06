package br.edu.ifsul.lpoo.cs.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */

@Entity
@Table(name = "tb_mapa")
public class Mapa {
    
    @Id
    @SequenceGenerator(name = "seq_mapa", sequenceName = "seq_mapa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_mapa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false, length = 200)
    private String nome;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_mapa_local", joinColumns = {@JoinColumn(name = "mapa_id")},
                                       inverseJoinColumns = {@JoinColumn(name = "local_id")})
    private List<Local> locais;
    
    public Mapa(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
