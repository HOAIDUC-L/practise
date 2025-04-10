package View;

import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewUsersFrame extends JFrame {
    public ViewUsersFrame(List<User> users) {
        setTitle("Danh sách người dùng");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnNames = {"Tên đăng nhập", "Mật khẩu (hash)"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (User user : users) {
            model.addRow(new Object[]{user.getUsername(), user.getHashedPassword()});
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}
