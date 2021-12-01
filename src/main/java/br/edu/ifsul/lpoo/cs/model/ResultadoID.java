package br.edu.ifsul.lpoo.cs.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Carlos
 */

@Embeddable
public class ResultadoID implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "round_id", nullable = false)
    private Round round;
    
    @ManyToOne
    @JoinColumn(name = "objetivo_id", nullable = false)
    private Objetivo objetivo;
    
    public ResultadoID(){
        
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
    
    
}