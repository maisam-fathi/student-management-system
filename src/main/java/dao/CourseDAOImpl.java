package dao;

import model.Course;
import model.Student;
import singleton.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The CourseDAOImpl class provides an implementation of the CourseDAO interface.
 * It includes methods for retrieving, adding, updating, and deleting course records.
 *
 * Note: The current implementation contains placeholder methods that need to be implemented
 * with actual database interactions.
 */
public class CourseDAOImpl implements CourseDAO {

private final Connection conn = DatabaseConnection.getConnection();
    /**
     * Retrieves a course from the database using its unique ID.
     *
     * @param id The unique identifier of the course.
     * @return The Course object if found, otherwise null.
     */
    @Override
    public Course getCourseByID(int id) {
        // TODO: Implement database query to retrieve course by ID (Don)
        Course course = null; // Declare variable to hold the course
        String query = "SELECT courseID, course_Name, studentID FROM course WHERE courseID = ?"; // SQL query to get course by ID

        try (Connection conn = DatabaseConnection.getConnection(); // Assuming DatabaseConnection is a class that provides DB connection
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id); // Set the provided courseID into the query
            ResultSet rs = stmt.executeQuery(); // Execute the query

            // Check if a result was returned
            if (rs.next()) {
                // Create a new Course object and populate it with the result set
                int courseID = rs.getInt("courseID");
                String courseName = rs.getString("course_Name");
                int studentID = rs.getInt("studentID");

                course = new Course(courseID,studentID,courseName); // Assuming Course constructor with 3 arguments
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle exceptions
        }
        return course; // Return the course object or null if no course was found
    }

    /**
     * Retrieves a course from the database using its name.
     *
     * @param name The name of the course.
     * @return The Course object if found, otherwise null.
     */
    @Override
    public Course getCourseByName(String name) {
        return null; // TODO: Implement database query to retrieve course by name
    }

    /**
     * Adds a new course to the database.
     *
     * @param course The Course object to be added.
     */
    @Override
    public void addCourse(Course course) {
        // TODO: Implement database insertion logic for a new course (Don)
        // SQL query to insert a new course into the course table
        String query = "INSERT INTO course (course_Name, studentID) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); // Get database connection
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the course name and studentID from the Course object into the query
            stmt.setString(1, course.getCourseName());
            stmt.setInt(2, course.getStudentID());

            // Execute the update to insert the course into the database
            stmt.executeUpdate();

            System.out.println("Course added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle any SQL exceptions
        }
    }

    /**
     * Updates an existing course in the database.
     *
     * @param course The Course object containing updated information.
     */
    @Override
    public void updateCourse(Course course) {
        // TODO: Implement database update logic for an existing course (Don)
        // SQL query to update an existing course in the course table
        String query = "UPDATE course SET course_Name = ?, studentID = ? WHERE courseID = ?";

        try (Connection conn = DatabaseConnection.getConnection(); // Get database connection
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the updated course data into the query
            stmt.setString(1, course.getCourseName()); // Update course name
            stmt.setInt(2, course.getStudentID()); // Update student ID
            stmt.setInt(3, course.getCourseID()); // Specify the courseID of the course to update

            // Execute the update query
            int rowsAffected = stmt.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {
                System.out.println("Course updated successfully.");
            } else {
                System.out.println("Course update failed, no course with the given ID found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle any SQL exceptions
        }
    }

    /**
     * Deletes a course from the database using its unique ID.
     *
     * @param id The unique identifier of the course to be deleted.
     */
    @Override
    public void deleteCourse(int id) {
        // TODO: Implement database deletion logic for a course (Don)
        // SQL query to delete a course from the course table by its courseID
        String query = "DELETE FROM course WHERE courseID = ?";

        try (Connection conn = DatabaseConnection.getConnection(); // Get database connection
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the courseID in the query
            stmt.setInt(1, id); // Set the courseID to the provided id

            // Execute the delete query
            int rowsAffected = stmt.executeUpdate();

            // Check if the deletion was successful
            if (rowsAffected > 0) {
                System.out.println("Course deleted successfully.");
            } else {
                System.out.println("No course found with the given ID to delete.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle any SQL exceptions
        }
    }

    @Override
    public List<String> getAllCourses() {
        List<String> courses = new ArrayList<>();
        String sql = "SELECT course_Name FROM course";

        try (PreparedStatement p = conn.prepareStatement(sql); ResultSet rs = p.executeQuery()) {
            while (rs.next()) {
                courses.add(rs.getString("course_Name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }
}
