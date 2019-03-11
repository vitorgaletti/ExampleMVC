
package trabalhomvc.componentes;

import javax.swing.JTextField;


public class MeuCampoInteiro extends JTextField implements MeuComponente{
    
    private String nome;
    
    
    public MeuCampoInteiro(int tamanho, String nome) {
        
        this.nome = nome;
        setColumns(tamanho);
        setHorizontalAlignment(JTextField.RIGHT);
        
     }

    @Override
    public Object getValor() {
         return (Integer.parseInt("0" + getText()));
    }

    @Override
    public void setValor(Object valor) {
         setText(String.valueOf((Integer) valor));
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void limpar() {
        setText("0");
    }

 
    
}
