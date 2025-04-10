package View;

import gui.LoginFrame;
import model.User;
import util.XMLUtil;

import javax.swing.*;
import java.util.*;

public class Main {
    private static List<User> users = new ArrayList<>(); // biến static toàn cục

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                users = XMLUtil.importFromXML("user.xml");
            } catch (Exception e) {
                System.out.println("Không thể đọc file XML, bắt đầu danh sách rỗng.");
            }

            LoginFrame login = new LoginFrame(users);
            login.setVisible(true);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    XMLUtil.exportToXML(users, "user.xml");
                } catch (Exception e) {
                    System.out.println("Lỗi khi lưu XML: " + e.getMessage());
                }
            }));
        });
    }
}
