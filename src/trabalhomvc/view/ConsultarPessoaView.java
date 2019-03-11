
package trabalhomvc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import trabalhomvc.controller.ConsultarPessoaController;
import trabalhomvc.model.ConexaoBanco;


public class ConsultarPessoaView extends JInternalFrame implements MouseListener{
    
    private ConsultarPessoaView consultarPessoaView;
     
    private DefaultTableModel dtm = new DefaultTableModel();
    
    private JPanel       jp           = new JPanel();
    private JTextField   jtfCampo     = new JTextField(40);
    private JButton      jbPesquisar  = new JButton("Pesquisar");
    private JButton      jbLimpar     = new JButton("Limpar");
    private JLabel       jlNome       = new JLabel("Nome: ");
    
    public String sql = ConsultarPessoaController.PESQUISASQL;
    public String[] colunas = {"Código", "Nome", "CPF", "Endereço", "CEP", "Telefone"};
    
   
    
    public ConsultarPessoaView() {
        super("Consultar Pessoa");
        this.consultarPessoaView = consultarPessoaView;
        
        tabela.getTableHeader().setReorderingAllowed(false);
              
        insereColunas(colunas);    
            
        getContentPane().add("North",jp);
        getContentPane().add("Center", jsp);
        
        jp.setLayout(new FlowLayout());
        jp.add(jlNome);
        jp.add(jtfCampo);
        jp.add(jbPesquisar);
        jp.add(jbLimpar);
                
        setVisible(true);
        
        tabela.addMouseListener(this);
        setSize(700, 350);
      
        centralizaTela();
        
        jbPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(jtfCampo.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Por favor digite um Nome");
                } else {
                   insereDados(sql);
                   pesquisar(); 
                }                            
            }
                       
        });
         
        jbLimpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                while (dtm.getRowCount() > 0) {
                    dtm.removeRow(0);
                }
                jtfCampo.setText("");
                
            }
        });
            
    }
       
    private JTable tabela = new JTable(dtm) {
        
        @Override
        public boolean isCellEditable(int linha, int coluna) {
            return false;
        }

        @Override
        public Component prepareRenderer(TableCellRenderer renderer,
                int linha, int coluna) {
            Component c = super.prepareRenderer(renderer, linha, coluna);
            if (linha % 2 == 0) {
                c.setBackground(Color.LIGHT_GRAY);
            } else {
                c.setBackground(getBackground());
            }
            if (isCellSelected(linha, coluna)) {
                c.setBackground(Color.YELLOW);
            }
            return c;
        }
    };
    
    private JScrollPane  jsp = new JScrollPane(tabela);
    
    
    public void centralizaTela() {
        Dimension tamanhoTela = getSize();
        Dimension tamanhoJDesktopPane =  SistemaView.jdp.getSize();
        int x = (tamanhoJDesktopPane.width - tamanhoTela.width) / 2;
        int y = (tamanhoJDesktopPane.height - tamanhoTela.height) / 2;
        setLocation(x, y);
    }

    public void insereColunas(String[] colunas) {
        for (int i = 0; i < colunas.length; i++) {
            dtm.addColumn(colunas[i]);
        }
    }
    
    public void insereDados(String sql) {
             
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
          
        List<String[]> dados = ConexaoBanco.executaQuery(sql);
        for (int i = 0; i < dados.size(); i++) {
            dtm.addRow(dados.get(i));
        }
   }
    
     public void pesquisar() {
             
             
            String sqlTemp = "SELECT * FROM (" + sql + ")";
            
            sqlTemp = sqlTemp + " WHERE UPPER(NOME) LIKE '%" + jtfCampo.getText().trim().toUpperCase() + "%'";
         
            insereDados(sqlTemp);    
                       
            if (dtm.getRowCount() == 0) {
                
            JOptionPane.showMessageDialog(null,
                    "Não existem dados cadastrados.");
            
            return;              
           
        }
            
     }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2) {
          dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
