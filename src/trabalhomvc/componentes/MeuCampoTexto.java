
package trabalhomvc.componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;


public class MeuCampoTexto extends JTextField implements MeuComponente, FocusListener{
    
    private String nome;
    
    public MeuCampoTexto(int tamanhoCampo, int qtdeCaracteres, String nome) {
        
        this.nome = nome;
        setColumns(tamanhoCampo);
        setDocument(new MeuDocument(qtdeCaracteres));
        
    }

    @Override
    public Object getValor() {
        return getText();
    }

    @Override
    public void setValor(Object valor) {
        setText((String) valor);
    }

    @Override
    public String getNome() {
            return nome;
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
       
    }

    @Override
    public void limpar() {
        setText("");
    }
}
   
    
    class MeuDocument extends PlainDocument {
        
        private Integer tamanho;
        
        public MeuDocument(int tamanho) {
            this.tamanho = tamanho;
        }
        
        @Override
        public void insertString(int offs, String str, AttributeSet a) {
            
            try {
                if((getLength() + str.length()) > tamanho) {
                    return; 
                } 
                Pattern padrao = Pattern.compile("[aA-zZ,0-9,'' ]");
                Matcher matcher = padrao.matcher(str);
                
                if(!matcher.find()) {
                    return;
                }
                
                super.insertString(offs, str.toUpperCase(), a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
    

