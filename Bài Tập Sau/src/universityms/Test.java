package universityms;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            // Thực hiện các thao tác với cơ sở dữ liệu ở đây
            DatabaseConnection.closeConnection(connection);
        }
    }
}

