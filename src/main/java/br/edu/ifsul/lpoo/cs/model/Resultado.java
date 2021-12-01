package br.edu.ifsul.lpoo.cs.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */

@Entity
@Table(name = "tb_resultado")
public class Resultado implements Serializable{
    
    @EmbeddedId
    private ResultadoID id;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    
    public Resultado(){
        
    }

    public ResultadoID getId() {
        return id;
    }

    public void setId(ResultadoID id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
