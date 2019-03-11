
package trabalhomvc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import trabalhomvc.componentes.MeuComponente;


public class PessoaView extends JInternalFrame implements ActionListener {
    
    
    public JPanel jpComponentes = new JPanel();
    private JPanel jpBotoes = new JPanel();
    private boolean temDadosNaTela = false;
      
    private JButton jbConfirmar = new JButton("Confirmar");
    private JButton jbCancelar = new JButton("Cancelar");
    
    public static final int ESQUERDA = 0; //
    public static final int CIMA =1; //
    
    public List<JLabel> rotulos = new ArrayList();
    private List<MeuComponente> campos = new ArrayList();
    
    public PessoaView(String titulo) {
        
        super(titulo, true, true, true, false);
        getContentPane().add("West", jpComponentes);
        getContentPane().add("South", jpBotoes);
        
        jpComponentes.setLayout(new GridBagLayout());
        jpBotoes.setLayout(new GridLayout());
       
        adicionarBotao(jbConfirmar);
        adicionarBotao(jbCancelar);
        pack();
       
        setVisible(true);
            
    }
    
     public void limparCampos() {
         for(int i =0; i < campos.size(); i++) {
             campos.get(i).limpar();
         }
     }
    
     public JLabel getRotulo(JComponent componente) {
        for (int i = 0; i < campos.size(); i ++ ) {
            if (campos.get(i) == componente) {
                return rotulos.get(i);
            }
        }
        return null;
    }
    
    public void adicionarComponente(int linha,
            int coluna,
            int linhas,
            int colunas,
            JComponent componente,
             int alinhamento) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        if(alinhamento == ESQUERDA) {
            gbc.anchor = GridBagConstraints.EAST;
        } else {
            gbc.anchor = GridBagConstraints.WEST;
        }
        
        if (componente instanceof MeuComponente) {
             String nome = "<html><body>" + ((MeuComponente) componente).getNome() + ":";
             
             nome = nome +"</body></html>";
             JLabel rotulo = new JLabel(nome);
             jpComponentes.add(rotulo, gbc);
             rotulos.add(rotulo);
             if (alinhamento == ESQUERDA) {
                gbc.gridx++;
                gbc.insets = new Insets(5, 0, 5, 5);
            } else {
                gbc.gridy++;
                gbc.insets = new Insets(0, 0, 5, 5);
            }
             campos.add((MeuComponente) componente);
        }
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        jpComponentes.add((JComponent) componente, gbc);
    }
          
     private void adicionarBotao(JButton botao) {
        jpBotoes.add(botao);
        botao.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == jbConfirmar) {
            confirmar();
        } else if (e.getSource() == jbCancelar){
            cancelar();
        }
    }
    
    public void cancelar(){
        limparCampos();
    }
    
    public void confirmar(){
        incluirBD();
        limparCampos();
    }
    
    public boolean incluirBD() {
        return true;
    }
      
}
