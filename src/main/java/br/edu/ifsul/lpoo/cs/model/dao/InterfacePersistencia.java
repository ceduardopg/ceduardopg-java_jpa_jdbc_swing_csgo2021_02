package br.edu.ifsul.lpoo.cs.model.dao;

import br.edu.ifsul.lpoo.cs.model.Endereco;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface InterfacePersistencia {
    
    public Boolean conexaoAberta();
    
    public void fecharConexao();
    
    public Object find(Class c, Object id) throws Exception;//select.
    
    public void persist(Object o) throws Exception;//insert ou update.
    
    public void remover(Object o) throws Exception;//delete.
    
    public List<Endereco> listEnderecos();
    
}
