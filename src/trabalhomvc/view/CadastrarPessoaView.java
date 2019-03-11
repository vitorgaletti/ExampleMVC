
package trabalhomvc.view;

import trabalhomvc.componentes.MeuCampoCEP;
import trabalhomvc.componentes.MeuCampoCPF;
import trabalhomvc.componentes.MeuCampoInteiro;
import trabalhomvc.componentes.MeuCampoTelefone;
import trabalhomvc.componentes.MeuCampoTexto;
import trabalhomvc.controller.PessoaController;
import trabalhomvc.model.Pessoa;


public class CadastrarPessoaView extends PessoaView {

    public Pessoa pessoa = new Pessoa();
    public PessoaController pessoaController = new PessoaController(pessoa);
    public static CadastrarPessoaView tela;
    public MeuCampoInteiro campoCodigo = new MeuCampoInteiro(3, "Código");
    public MeuCampoTexto campoNome = new MeuCampoTexto(20, 50, "Nome" );
    public MeuCampoCPF campoCPF = new MeuCampoCPF(20, "CPF");
    public MeuCampoTexto campoEndereco = new MeuCampoTexto(20, 50, "Endereço" );
    public MeuCampoCEP campoCEP = new MeuCampoCEP(20, "CEP" );
    public MeuCampoTelefone campoTelefone = new MeuCampoTelefone(20, "Telefone" );
      
    
    public CadastrarPessoaView() {
        super("Cadastrar Pessoa");
        adicionarComponente(1, 1, 1, 1, campoCodigo, ESQUERDA);
        adicionarComponente(2, 1, 1, 1, campoNome, ESQUERDA);
        adicionarComponente(3, 1, 1, 1, campoCPF, ESQUERDA);
        adicionarComponente(4, 1, 1, 1, campoEndereco, ESQUERDA);
        adicionarComponente(5, 1, 1, 1, campoCEP, ESQUERDA);
        adicionarComponente(6, 1, 1, 1, campoTelefone, ESQUERDA);
        pack();
    }

   public void setPersistencia() {
      pessoa.setId((int) campoCodigo.getValor());
      pessoa.setNome((String) campoNome.getValor());
      pessoa.setCpf((String) campoCPF.getValor());
      pessoa.setEndereco((String) campoEndereco.getValor());
      pessoa.setCep((String) campoCEP.getValor());
      pessoa.setTelefone((String) campoTelefone.getValor());
                
    }
   
    public void getPersistencia() {
      campoCodigo.setValor(pessoa.getId());
      campoNome.setValor(pessoa.getNome());
      campoCPF.setValor(pessoa.getCpf());
      campoEndereco.setValor(pessoa.getEndereco());
      campoCEP.setValor(pessoa.getCep());
      campoTelefone.setValor(pessoa.getTelefone());
       
    }
    
    @Override
    public boolean incluirBD() {
      setPersistencia();
      getPersistencia(); 
      return pessoaController.incluir();
    }
    
  
}
