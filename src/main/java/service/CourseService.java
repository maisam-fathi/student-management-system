package service;

import dao.CourseDAO;
import dao.CourseDAOImpl;
import model.Course;

import java.util.List;

/**
 * The CourseService class provides methods to interact with CourseDAO
 * for retrieving and managing course data.
 */
public class CourseService {

    private final CourseDAO courseDAO;

    /**
     * Constructs a new CourseService and initializes the CourseDAO implementation.
     */
    public CourseService() {
        courseDAO = new CourseDAOImpl();
    }

    /**
     * Finds a course by its ID.
     *
     * @param id The unique identifier of the course.
     * @return The Course object if found, otherwise null.
     * @throws IllegalArgumentException if the course ID is invalid.
     */
    public Course findCourseById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid course ID!");
        }
        return courseDAO.getCourseByID(id);
    }

    /**
     * Finds a course by its name.
     *
     * @param name The name of the course.
     * @return The Course object if found, otherwise null.
     * @throws IllegalArgumentException if the course name is null or empty.
     */
    public Course findCourseByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty!");
        }
        return courseDAO.getCourseByName(name);
    }

    /**
     * Deletes a course by its unique ID.
     *
     * @param id The unique identifier of the course to be deleted.
     * @throws IllegalArgumentException if the course ID is invalid.
     */
    public void deleteCourseById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid course ID!");
        }
        courseDAO.deleteCourse(id);
    }

    /**
     * Adds a new course to the database.
     *
     * @param course The Course object containing course details.
     * @throws IllegalArgumentException if the course is null or has an empty name.
     */
    public void addCourse(Course course) {
        if (course == null || course.getCourseName().trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty!");
        }
        courseDAO.addCourse(course);
    }

    /**
     * Updates an existing course with new details.
     *
     * @param course The Course object containing updated course details.
     * @throws IllegalArgumentException if the course is null, has an invalid ID, or has an empty name.
     */
    public void updateCourse(Course course) {
        if (course == null || course.getCourseID() <= 0 || course.getCourseName().trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid course data!");
        }
        courseDAO.updateCourse(course);
    }

    /**
     * Deletes a course by its ID.
     * This method is a duplicate of deleteCourseById and should be removed or refactored.
     *
     * @param id The unique identifier of the course to be deleted.
     * @throws IllegalArgumentException if the course ID is invalid.
     */
    public void deleteCourse(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid course ID!");
        }
        courseDAO.deleteCourse(id);
    }

    public List<String> getAllCourses() {
        return courseDAO.getAllCourses();
    }
    /**
     * Main method for testing the CourseService class.
     * It retrieves a course with a specific ID and prints its details.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        Course course = courseService.findCourseById(1);

        if (course != null) {
            System.out.println(course);
        } else {
            System.out.println("Course not found!");
        }
    }
}
