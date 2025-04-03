package universityms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentManager {
    private Connection connection;

    public EnrollmentManager(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void enrollStudentToClass(int studentID, int classID) throws SQLException {
        String query = "INSERT INTO Learn (StudentID, ClassID) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, studentID);
        statement.setInt(2, classID);
        statement.executeUpdate();
    }

    public void listStudentsInClass(int classID) throws SQLException {
        String query = "SELECT * FROM Student WHERE StudentID IN (SELECT StudentID FROM Learn WHERE ClassID=?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, classID);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            System.out.println("StudentID: " + rs.getInt("StudentID") +
                               ", Name: " + rs.getString("name") +
                               ", Age: " + rs.getInt("age") +
                               ", Email: " + rs.getString("email") +
                               ", GPA: " + rs.getDouble("gpa"));
        }
    }
}

