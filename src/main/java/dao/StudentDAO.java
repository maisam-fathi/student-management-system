package dao;

import model.Student;

import java.time.LocalDate;
import java.util.List;

/**
 * The StudentDAO interface defines the data access operations for the Student entity.
 * It provides methods to retrieve, add, update, and delete student records.
 */
public interface StudentDAO {

    /**
     * Retrieves a student from the database using their unique ID.
     *
     * @param id The unique identifier of the student.
     * @return The Student object if found, otherwise null.
     */
    Student getStudentById(int id);

    /**
     * Retrieves a student from the database using their last name.
     *
     * @param name The last name of the student.
     * @return The Student object if found, otherwise null.
     */
    Student getStudentByLastName(String name);

    /**
     * Retrieves a list of all students from the database.
     *
     * @return A list of Student objects.
     */
    List<Student> getAllStudents();

    /**
     * Adds a new student to the database.
     *
     * @param student The Student object to be added.
     * @return
     */
    int addStudent(Student student);

    void addStudent(int studentID, String firstname, String lastname, String email, String grade, String phoneNumber, LocalDate dateOfBirth);

    /**
     * Updates an existing student's information in the database.
     *
     * The Student object containing updated information.
     */
    void updateStudent(int studentID, String firstname, String lastname, String email, String grade, String phoneNumber, LocalDate dateOfBirth);

    /**
     * Deletes a student from the database using their unique ID.
     *
     * @param id The unique identifier of the student to be deleted.
     */
    void deleteStudent(int id);


}
