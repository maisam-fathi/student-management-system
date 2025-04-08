package dao;

import model.Student;
import singleton.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private final Connection conn = DatabaseConnection.getConnection();

    /**
     * Executes a SQL query to retrieve a student based on a given parameter.
     * This method handles the query for both student ID and student last name.
     *
     * @param sql   The SQL query to execute.
     * @param param The parameter (ID or last name) to filter the student records.
     * @return A Student object if found, otherwise null.
     */

    private Student getStudentFromQuery(String sql, Object param) {
        Student student = null;
        try (PreparedStatement p = conn.prepareStatement(sql)) {
            //Checking the parameter type and setting it appropriately
            if (param instanceof Integer) {
                p.setInt(1, (Integer) param);
            } else if (param instanceof String) {
                p.setString(1, (String) param);
            }
            try (ResultSet rs = p.executeQuery()) {
                if (rs.next()) {
                    student = new Student(
                            rs.getInt("studentID"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getString("eMail"),
                            rs.getString("grade"),
                            rs.getString("phoneNumber"),
                            rs.getDate("dayOfBirth").toLocalDate()
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    /**
     * Retrieves a student from the database using their unique ID.
     *
     * @param id The unique identifier of the student.
     * @return The Student object if found, otherwise null.
     */
    @Override
    public Student getStudentById(int id) {
        return getStudentFromQuery("select * from student where studentID = ?", id);
    }

    /**
     * Retrieves a student from the database using their last name.
     *
     * @param name The last name of the student.
     * @return The Student object if found, otherwise null.
     */
    @Override
    public Student getStudentByLastName(String name) {
        return getStudentFromQuery("select * from student where lastname = ?", name);
    }

    /**
     * Retrieves a list of all students from the database.
     * This method fetches all student records from the database and returns them as a list.
     *
     * @return A list of Student objects containing all students from the database.
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Student student = null;
        String sql = "select studentID, firstname, lastname, eMail, grade, phoneNumber, dayOfBirth from student";
        try (PreparedStatement p = conn.prepareStatement(sql); ResultSet rs = p.executeQuery()) {
            while (rs.next()) {
                    student = new Student(
                            rs.getInt("studentID"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getString("eMail"),
                            rs.getString("grade"),
                            rs.getString("phoneNumber"),
                            rs.getDate("dayOfBirth").toLocalDate()
                    );
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }

    @Override
    public void addStudent(int studentID, String firstname, String lastname, String email, String grade, String phoneNumber, LocalDate dateOfBirth) {

        final String sql = "INSERT INTO student (firstname, lastname, eMail, grade, phoneNumber, dayOfBirth) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, studentID);
            p.setString(2, firstname);
            p.setString(3, lastname);
            p.setString(4, email);
            p.setString(5, grade);
            p.setString(6, phoneNumber);
            p.setDate(7, Date.valueOf(dateOfBirth));

            int studentUpdate = p.executeUpdate();
            if (studentUpdate > 0) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateStudent(int studentID, String firstname, String lastname, String email, String grade, String phoneNumber, LocalDate dateOfBirth) {
        final String sql = "UPDATE student SET firstname = ?, lastname = ?, eMail = ?, grade = ?, phoneNumber = ?, dayOfBirth = ? WHERE studentID = ?";
        try (PreparedStatement p = conn.prepareStatement(sql)) {
            p.setString(1, firstname);
            p.setString(2, lastname);
            p.setString(3, email);
            p.setString(4, grade);
            p.setString(5, phoneNumber);
            p.setDate(6, Date.valueOf(dateOfBirth));
            p.setInt(7, studentID);
            int studentUpdate = p.executeUpdate();
            if (studentUpdate > 0) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int id) {
        final String sql = "DELETE FROM student WHERE studentID = ?";
        try (PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, id);
            int studentDeleted = p.executeUpdate();
            if (studentDeleted > 0) {
                System.out.println("Student with ID " + id + " has been deleted.");
            } else {
                System.out.println("Student with ID " + id + " has not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
