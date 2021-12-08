package br.edu.ifsul.lpoo.cs.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */

@Entity
@Table(name = "tb_endereco")
@NamedQueries({      
    @NamedQuery(name="Endereco.list_order_by_id_asc",
               query="SELECT e From Endereco e order by e.id asc")
})
public class Endereco implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_endereco", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    
    @Column(nullable = false, length = 8)    
    private String cep;
    
    @Column(nullable = true, length = 100)
    private String complemento;
        
    public Endereco(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
                    
        this.id = id;          
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
          
}
