
package trabalhomvc.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import trabalhomvc.model.ConexaoBanco;
import trabalhomvc.model.Pessoa;


public class PessoaController {
    
    private Pessoa pessoa;
    
    private final String SQL_INCLUIR =
            "INSERT INTO PESSOA VALUES (?, ?, ?, ?, ?, ?)";
    
    
    public PessoaController(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
  
    public boolean incluir() {
        try {
           PreparedStatement ps = ConexaoBanco.getConexao().prepareStatement(SQL_INCLUIR);
     
           ps.setInt(1, pessoa.getId());
           ps.setString(2, pessoa.getNome());
           ps.setString(3, pessoa.getCpf());
           ps.setString(4, pessoa.getEndereco());
           ps.setString(5, pessoa.getCep());
           ps.setString(6, pessoa.getTelefone());
           
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Cadastro realizado com Sucesso.","Mensagem", JOptionPane.INFORMATION_MESSAGE);
           return  true;
          
        } catch (Exception e) {
            
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Houve um problema ao tentar incluir a Pessoa.", "Erro", JOptionPane.ERROR_MESSAGE);
           
            }
            return false;
                  
    } 
    
}
