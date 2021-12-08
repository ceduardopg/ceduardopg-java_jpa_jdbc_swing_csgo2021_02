/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.cs.test;

import br.edu.ifsul.lpoo.cs.model.Patente;
import br.edu.ifsul.lpoo.cs.model.dao.PersistenciaJDBC;
import org.junit.Test;

/**
 *
 * @author Carlos
 */
public class TestPersistenciaJDBC {
    
    //@Test
    public void testarConexao() throws Exception{
        PersistenciaJDBC persistencia = new PersistenciaJDBC();
        
        if(persistencia.conexaoAberta()){
            System.out.println("Conexao com o BD aberta utilizando JDBC");
            persistencia.fecharConexao();
        }else{
            System.out.println("Não abriu conexão via JDBC");
        }
    }
    
    @Test
    public void testarPersistenciaPatente() throws Exception{
        PersistenciaJDBC persistencia = new PersistenciaJDBC();
        
        if(persistencia.conexaoAberta()){
            Patente p = (Patente) persistencia.find(Patente.class, new Integer(1));
            if(p == null){
                System.out.println("Não encontrou a patente.");
            }else{
                System.out.println("Encontrou a patente: \nNome:"+p.getNome()+
                                                        "\nCor:"+p.getCor());
            }
            persistencia.fecharConexao();
        }else{
            System.out.println("Não abriu conexão via JDBC");
        }
    }
}
