package trabalhomvc.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFormattedTextField;

public class MeuCampoFormatado2 extends JFormattedTextField implements MeuComponente {

    private String nome;
   
    public MeuCampoFormatado2(int colunas, String nome) {
        setColumns(colunas);
        this.nome = nome;    

    }

    @Override
    public String getNome() {
        return nome;
    }


    @Override
    public Object getValor() {
        return getText();
    }

    @Override
    public void setValor(Object valor) {
        setText("" + valor);
    }

    @Override
    public void limpar() {
        setText("");
    }

}