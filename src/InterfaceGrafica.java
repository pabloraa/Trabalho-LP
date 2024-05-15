import javax.swing.*;

public class InterfaceGrafica extends JFrame {
    private JPanel currentPanel;

    public InterfaceGrafica() {
        setTitle("Exemplo de Troca de Telas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Inicialmente, exibe o primeiro painel
        showPanel(new Panel1());
    }

    public void showPanel(JPanel panel) {
        getContentPane().removeAll(); // Remove todos os componentes do contêiner
        getContentPane().add(panel); // Adiciona o novo painel ao contêiner
        revalidate(); // Atualiza o layout do contêiner
        repaint(); // Redesenha o contêiner
        currentPanel = panel; // Define o painel atual
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfaceGrafica frame = new InterfaceGrafica();
            frame.setVisible(true);
        });
    }
}

class Panel1 extends JPanel {
    public Panel1() {
        JLabel label = new JLabel("Você está na tela 01");
        JButton switchButton = new JButton("Ir para o Painel 2");
        switchButton.addActionListener(e -> {
            InterfaceGrafica frame = (InterfaceGrafica) SwingUtilities.getWindowAncestor(this);
            frame.showPanel(new Panel2());
        });
        add(switchButton);
        add(label);
    }
}

class Panel2 extends JPanel {
    public Panel2() {
        JButton switchButton = new JButton("Ir para o Painel 1");
        JLabel label = new JLabel("Você está na tela 02");
        switchButton.addActionListener(e -> {
            InterfaceGrafica frame = (InterfaceGrafica) SwingUtilities.getWindowAncestor(this);
            frame.showPanel(new Panel1());
        });
        add(switchButton);
        add(label);
    }
}