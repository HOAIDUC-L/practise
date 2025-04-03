package universityms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class UniversityManagementApp extends JFrame {
    private JTextField studentIDField, nameField, ageField, gpaField;
    private JTextArea studentsListArea;

    public UniversityManagementApp() {
        // Thiết lập cửa sổ chính
        setTitle("Quản Lý Sinh Viên VKU");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo tab panel
        JTabbedPane tabbedPane = new JTabbedPane();

        // Tab "Thêm Sinh Viên"
        JPanel addStudentPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        addStudentPanel.add(new JLabel("Mã Sinh Viên:"));
        studentIDField = new JTextField();
        addStudentPanel.add(studentIDField);

        addStudentPanel.add(new JLabel("Tên Sinh Viên:"));
        nameField = new JTextField();
        addStudentPanel.add(nameField);

        addStudentPanel.add(new JLabel("Tuổi:"));
        ageField = new JTextField();
        addStudentPanel.add(ageField);

        addStudentPanel.add(new JLabel("Điểm GPA:"));
        gpaField = new JTextField();
        addStudentPanel.add(gpaField);

        JButton addStudentButton = new JButton("Thêm Sinh Viên");
        addStudentPanel.add(new JLabel()); // Để tạo khoảng trống
        addStudentPanel.add(addStudentButton);

        tabbedPane.add("Thêm Sinh Viên", addStudentPanel);

        // Tab "Hiển Thị Danh Sách"
        JPanel viewStudentsPanel = new JPanel(new BorderLayout());
        studentsListArea = new JTextArea();
        studentsListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(studentsListArea);
        viewStudentsPanel.add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Làm Mới Danh Sách");
        viewStudentsPanel.add(refreshButton, BorderLayout.SOUTH);

        tabbedPane.add("Hiển Thị Danh Sách", viewStudentsPanel);

        // Sự kiện thêm sinh viên
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Lấy thông tin từ các ô nhập liệu
                    int studentID = Integer.parseInt(studentIDField.getText());
                    String name = nameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    double gpa = Double.parseDouble(gpaField.getText());
                    String email = name.toLowerCase().replaceAll(" ", "") + "@vku.udn.vn";

                    // Thêm sinh viên vào CSDL
                    addStudentToDatabase(studentID, name, age, email, gpa);

                    // Thông báo thành công
                    JOptionPane.showMessageDialog(null, "Thêm sinh viên thành công!");

                    // Xóa dữ liệu trong ô nhập
                    studentIDField.setText("");
                    nameField.setText("");
                    ageField.setText("");
                    gpaField.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi: Vui lòng nhập dữ liệu hợp lệ!");
                }
            }
        });

        // Sự kiện làm mới danh sách
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadStudentsFromDatabase();
            }
        });

        // Thêm tab panel vào JFrame
        add(tabbedPane);

        // Hiển thị cửa sổ
        setVisible(true);
    }

    // Hàm thêm sinh viên vào CSDL
    private void addStudentToDatabase(int studentID, String name, int age, String email, double gpa) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Student (StudentID, name, age, email, gpa) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, studentID);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.setString(4, email);
            statement.setDouble(5, gpa);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể thêm sinh viên!");
        }
    }

    // Hàm tải danh sách sinh viên từ CSDL
    private void loadStudentsFromDatabase() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Student";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            studentsListArea.setText(""); // Xóa nội dung cũ
            while (rs.next()) {
                int id = rs.getInt("StudentID");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                double gpa = rs.getDouble("gpa");

                studentsListArea.append(String.format("ID: %d | Tên: %s | Tuổi: %d | Email: %s | GPA: %.2f%n",
                        id, name, age, email, gpa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể tải danh sách sinh viên!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UniversityManagementApp());
    }
}
