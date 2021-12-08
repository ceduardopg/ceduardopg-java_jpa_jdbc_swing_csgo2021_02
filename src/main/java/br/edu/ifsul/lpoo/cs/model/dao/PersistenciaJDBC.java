package br.edu.ifsul.lpoo.cs.model.dao;

import br.edu.ifsul.lpoo.cs.model.Arma;
import br.edu.ifsul.lpoo.cs.model.Endereco;
import br.edu.ifsul.lpoo.cs.model.Municao;
import br.edu.ifsul.lpoo.cs.model.Patente;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class PersistenciaJDBC implements InterfacePersistencia {
    
    private final String DRIVER = "org.postgresql.Driver";
    private final String USER = "postgres";
    private final String SENHA = "123456";
    public static final String URL = "jdbc:postgresql://localhost:5432/csgo";
    private Connection con = null;

    public PersistenciaJDBC () throws Exception {
        Class.forName(DRIVER);
        System.out.println("Tentando estabelecer conexao JDBC com : "+URL+" ...");
            
        this.con = (Connection) DriverManager.getConnection(URL, USER, SENHA); 
        
    }
    
    
    @Override
    public Boolean conexaoAberta() {
        try {
            if(con != null)
                return !con.isClosed();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return false;
        
    }

    @Override
    public void fecharConexao() {        
        try{                               
            this.con.close();//fecha a conexao.
            System.out.println("Fechou conexao JDBC");
        }catch(SQLException e){            
            e.printStackTrace();
        } 
        
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        if(c == Endereco.class){
            
            PreparedStatement ps = this.con.prepareStatement("select id, cep, complemento from tb_endereco where id = ? ");
            ps.setInt(1, Integer.parseInt(id.toString()));
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            
                Endereco e = new Endereco();
                e.setId(rs.getInt("id"));
                e.setCep(rs.getString("cep"));
                e.setComplemento(rs.getString("complemento"));
                
                ps.close();
                
                return e;                
            }
            
        }else if(c == Patente.class){
            PreparedStatement ps = this.con.prepareStatement("select id, nome, cor from tb_patente where id = ? ");
            ps.setInt(1, Integer.parseInt(id.toString()));
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            
                Patente p = new Patente();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCor(rs.getString("cor"));
                
                ps.close();
                
                return p;         
            }        
        }
        
        return null;
    }
    
    @Override
    public void persist(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Endereco> listEnderecos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}