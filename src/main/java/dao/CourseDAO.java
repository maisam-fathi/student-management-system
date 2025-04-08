package dao;

import model.Course;
import java.util.List;

/**
 * The CourseDAO interface defines the data access operations for the Course entity.
 * It provides methods to retrieve, add, update, and delete course records.
 */
public interface CourseDAO {

    /**
     * Retrieves a course from the database using its unique ID.
     *
     * @param id The unique identifier of the course.
     * @return The Course object if found, otherwise null.
     */
    Course getCourseByID(int id);

    /**
     * Retrieves a course from the database using its name.
     *
     * @param name The name of the course.
     * @return The Course object if found, otherwise null.
     */
    Course getCourseByName(String name);

    /**
     * Adds a new course to the database.
     *
     * @param course The Course object to be added.
     */
    void addCourse(Course course);

    /**
     * Updates an existing course in the database.
     *
     * @param course The Course object containing updated information.
     */
    void updateCourse(Course course);

    /**
     * Deletes a course from the database using its unique ID.
     *
     * @param id The unique identifier of the course to be deleted.
     */
    void deleteCourse(int id);

    List<String> getAllCourses();

}
