package gui;

import model.User;
import util.BCryptUtil;

import javax.swing.*;

import View.ViewUsersFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class LoginFrame extends JFrame {
    private List<User> users;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame(List<User> users) {
        this.users = users;
        setTitle("Đăng nhập");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Tên đăng nhập:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Mật khẩu:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Đăng nhập");
        JButton registerButton = new JButton("Đăng ký");
        panel.add(loginButton);
        panel.add(registerButton);

        loginButton.addActionListener(e -> handleLogin());
        registerButton.addActionListener(e -> new RegisterFrame(users).setVisible(true));

        add(panel);
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        for (User user : users) {
            if (user.getUsername().equals(username) &&
                BCryptUtil.checkPassword(password, user.getHashedPassword())) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                // 👉 Mở cửa sổ hiển thị danh sách người dùng
                new ViewUsersFrame(users).setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu");
    }

}
