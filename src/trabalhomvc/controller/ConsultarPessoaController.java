
package trabalhomvc.controller;

import trabalhomvc.model.Pessoa;

public class ConsultarPessoaController {
    
    private Pessoa pessoa;
    
     public static final String PESQUISASQL = 
             "SELECT ID, NOME, CPF, ENDERECO, CEP, TELEFONE FROM PESSOA ORDER BY NOME";
     
    
     public ConsultarPessoaController(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
     
}
