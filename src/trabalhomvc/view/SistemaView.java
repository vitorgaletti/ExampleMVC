
package trabalhomvc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class SistemaView extends JFrame implements ActionListener {

    public static JDesktopPane jdp = new JDesktopPane();
    public JMenuBar jmb = new JMenuBar();
    public JMenu jmPessoa = new JMenu("Pessoa");
    public JMenuItem jmiCadastrar = new JMenuItem("Cadastrar");
    public JMenuItem jmiConsultar = new JMenuItem("Consultar");
    public JMenuItem jmiListar = new JMenuItem("Listar");
    
    public SistemaView(){
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Sistema MVC 2019");
        getContentPane().add(jdp);
        setJMenuBar(jmb);
        jmb.add(jmPessoa);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionaJMenuItem(jmPessoa, jmiCadastrar);
        adicionaJMenuItem(jmPessoa, jmiConsultar);
        adicionaJMenuItem(jmPessoa, jmiListar);
        setVisible(true);
    }
    
    public void adicionaJMenuItem(JMenu menu, JMenuItem item){
        menu.add(item);
        item.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jmiCadastrar){
            CadastrarPessoaView cadastrarPessoaView = new CadastrarPessoaView();
            jdp.add(cadastrarPessoaView);
                 
        } else if (e.getSource() == jmiConsultar){
            ConsultarPessoaView consultarPessoaView = new ConsultarPessoaView();
            jdp.add(consultarPessoaView);
            
        } else if (e.getSource() == jmiListar){
            ListarPessoaView listarPessoaView = new ListarPessoaView();
            jdp.add(listarPessoaView);
                
            
            
        }
    }
    
        
    
}
