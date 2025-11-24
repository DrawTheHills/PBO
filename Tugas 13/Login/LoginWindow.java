import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow {
    
    private final String validUser = "naufal";
    private final String validPass = "12345";

    private JFrame frame;
    private JTextField fieldUser;
    private JPasswordField fieldPass;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginWindow().createUI());
    }

    public void createUI() {
        frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 8, 8));
        
        JLabel lblUser = new JLabel("Enter Username:");
        JLabel lblPass = new JLabel("Enter Password:");

        fieldUser = new JTextField(15);
        fieldPass = new JPasswordField(15);

        JButton btnSubmit = new JButton("Login");
        JButton btnClear = new JButton("Clear");

        btnSubmit.addActionListener(new LoginHandler());
        btnClear.addActionListener(e -> {
            fieldUser.setText("");
            fieldPass.setText("");
            fieldUser.requestFocus();
        });

        panel.add(lblUser);
        panel.add(fieldUser);
        panel.add(lblPass);
        panel.add(fieldPass);
        panel.add(btnSubmit);
        panel.add(btnClear);

        frame.add(panel);
        frame.setSize(330, 160);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class LoginHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String u = fieldUser.getText();
            String p = new String(fieldPass.getPassword());

            if (u.equals(validUser) && p.equals(validPass)) {
                JOptionPane.showMessageDialog(frame,
                    "Login berhasil! Selamat datang, " + u);
            } else {
                JOptionPane.showMessageDialog(frame,
                    "Username atau Password salah!",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
