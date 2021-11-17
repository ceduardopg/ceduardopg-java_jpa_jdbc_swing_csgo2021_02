package br.edu.ifsul.lpoo.cs.test;

import br.edu.ifsul.lpoo.cs.model.dao.PersistenciaJPA;
import org.junit.Test;
/**
 *
 * @author Carlos
 */
public class TestPersistenciaJPA {
    
    @Test
    public void testConexaoGeracaoTabelas(){
        
        PersistenciaJPA persistencia = new PersistenciaJPA();
        if(persistencia.conexaoAberta()){
            System.out.println("Abriu a conexao com o BD via JPA");
            
            persistencia.fecharConexao();
            
        }else{
            System.out.println("Não abriu a conexao com o BD via JPA");
        }
        
    }
    
}