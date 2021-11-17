package br.edu.ifsul.lpoo.cs.model.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Carlos
 */

public class PersistenciaJPA implements InterfacePersistencia {
    
    public EntityManagerFactory factory;    
    public EntityManager entity;            
    
    public PersistenciaJPA(){
        
        factory = Persistence.createEntityManagerFactory("pu_csgo");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        
        return entity.isOpen();   
    }

    @Override
    public void fecharConexao() {
        
        entity.close();        
    }
    
}
