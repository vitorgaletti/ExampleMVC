package trabalhomvc.componentes;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class MeuCampoCPF extends MeuCampoFormatado2{

   
    public MeuCampoCPF(int tamanho, String nome) {
        super(tamanho, nome);
        try {
            MaskFormatter mf = new MaskFormatter("###.###.###-##");
            mf.install(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cria o campo CPF!");
        }
    }

 
  
}


