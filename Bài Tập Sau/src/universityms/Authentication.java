package universityms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {
    private Connection connection;

    public Authentication(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public boolean login(String email) throws SQLException {
        String query = "SELECT * FROM Student WHERE email=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();
        return rs.next(); // Return true if a matching record is found.
    }

    public void logout() {
        System.out.println("Logout successful.");
    }
}

