package universityms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/universityms"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Chỉ cần kết nối trực tiếp mà không cần đăng ký driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            System.err.println("Lỗi: Không thể kết nối với cơ sở dữ liệu!");
            e.printStackTrace();
        }
        return connection;
    }


    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Đóng kết nối thành công!");
            } catch (SQLException e) {
                System.err.println("Lỗi: Không thể đóng kết nối!");
                e.printStackTrace();
            }
        }
    }
}
