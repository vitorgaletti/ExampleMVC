package trabalhomvc.view;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import trabalhomvc.controller.ListarPessoaController;
import trabalhomvc.model.ConexaoBanco;
import trabalhomvc.model.Pessoa;

public class ListarPessoaView extends JInternalFrame implements MouseListener{
    
    public Pessoa pessoa = new Pessoa();
    private ListarPessoaView listarPessoaView;
    
    private DefaultTableModel dtm = new DefaultTableModel();
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
    private JScrollPane jsp = new JScrollPane(tabela);
    
        public ListarPessoaView(){
        super("Listar Pessoa");
        
        this.listarPessoaView = listarPessoaView;
        tabela.getTableHeader().setReorderingAllowed(false);
        
        String[] colunas = {"Código", "Nome", "CPF", "Endereço", "CEP", "Telefone"};
        insereColunas(colunas);
        insereDados(ListarPessoaController.SQL_PESQUISAR);
        if (dtm.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Não existem dados cadastrados.");
            return;
        }
        getContentPane().add(jsp);
        pack();
        setVisible(true);
        centralizaTela();
        tabela.addMouseListener(this);
       
    }

    public void centralizaTela() {
        Dimension tamanhoTela = getSize();
        Dimension tamanhoJDesktopPane = SistemaView.jdp.getSize();
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
        List<String[]> dados = ConexaoBanco.executaQuery(sql);
        for (int i = 0; i < dados.size(); i++) {
            dtm.addRow(dados.get(i));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getClickCount() == 2) {
             dispose();
             
         }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

 
   

}