import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Tela de Login");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Usuário:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Verificar as credenciais e realizar o login
                // Por exemplo, você pode comparar com valores fixos ou verificar em um banco de dados
                if (username.equals("usuario") && password.equals("senha")) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login bem-sucedido!");
                    // Aqui você pode abrir a próxima tela após o login
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Credenciais inválidas. Tente novamente.");
                }
            }
        });

        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implemente a lógica para abrir a tela de registro de usuários
                JOptionPane.showMessageDialog(LoginFrame.this, "Funcionalidade de registro ainda não implementada.");
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        });
    }
}