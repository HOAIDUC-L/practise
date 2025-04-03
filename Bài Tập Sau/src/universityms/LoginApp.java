package universityms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginApp extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginApp() {
        
        setTitle("Đăng Nhập Hệ Thống");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo panel cho giao diện đăng nhập
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Mật Khẩu:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Đăng Nhập");
        panel.add(new JLabel()); // Khoảng trống
        panel.add(loginButton);

        add(panel);

        // Sự kiện nhấn nút "Đăng Nhập"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticateUser(email, password)) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                    dispose(); // Đóng giao diện đăng nhập
                    new UniversityManagementApp(); // Mở giao diện chính
                } else {
                    JOptionPane.showMessageDialog(null, "Email hoặc mật khẩu không đúng!");
                }
            }
        });

        setVisible(true);
    }

    // Phương thức xác thực người dùng từ CSDL
    private boolean authenticateUser(String email, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM User WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi kết nối cơ sở dữ liệu!");
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginApp());
    }
}
