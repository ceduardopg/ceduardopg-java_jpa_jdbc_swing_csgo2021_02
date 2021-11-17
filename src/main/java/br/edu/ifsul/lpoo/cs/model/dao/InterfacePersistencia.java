package br.edu.ifsul.lpoo.cs.model.dao;
/**
 *
 * @author Carlos
 */
public interface InterfacePersistencia {
    
    public Boolean conexaoAberta();
    
    public void fecharConexao();
    
}
