package universityms;

import java.sql.*;

public class StudentManager {
    private Connection connection;

    public StudentManager(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO Student (StudentID, name, age, email, gpa) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, student.getStudentID());
        statement.setString(2, student.getName());
        statement.setInt(3, student.getAge());
        statement.setString(4, student.getEmail());
        statement.setDouble(5, student.getGpa());
        statement.executeUpdate();
    }

    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE Student SET name=?, age=?, gpa=? WHERE StudentID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, student.getName());
        statement.setInt(2, student.getAge());
        statement.setDouble(3, student.getGpa());
        statement.setInt(4, student.getStudentID());
        statement.executeUpdate();
    }

    public void deleteStudent(int studentID) throws SQLException {
        String query = "DELETE FROM Student WHERE StudentID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, studentID);
        statement.executeUpdate();
    }

    public Student getStudent(int studentID) throws SQLException {
        String query = "SELECT * FROM Student WHERE StudentID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, studentID);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return new Student(
                rs.getInt("StudentID"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getDouble("gpa")
            );
        }
        return null;
    }
}

