
package trabalhomvc.controller;

import trabalhomvc.model.Pessoa;

public class ListarPessoaController {
    
    private Pessoa pessoa;
    
     public static final String SQL_PESQUISAR =
            "SELECT * FROM PESSOA ORDER BY NOME";
     

     
     public ListarPessoaController(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
     
}
