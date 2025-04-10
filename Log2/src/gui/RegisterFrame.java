package gui;

import model.User;
import util.BCryptUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class RegisterFrame extends JFrame {
    private List<User> users;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public RegisterFrame(List<User> users) {
        this.users = users;
        setTitle("Đăng ký người dùng");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Tên đăng nhập:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Mật khẩu:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton registerButton = new JButton("Đăng ký");
        panel.add(registerButton);

        registerButton.addActionListener(e -> handleRegister());
        add(panel);
    }

    private void handleRegister() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                JOptionPane.showMessageDialog(this, "Người dùng đã tồn tại");
                return;
            }
        }

        String hashed = BCryptUtil.hashPassword(password);
        users.add(new User(username, hashed));
        JOptionPane.showMessageDialog(this, "Đăng ký thành công");
        dispose();
    }
}