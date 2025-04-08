package service;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * The StudentService class provides methods to interact with the StudentDAO
 * for retrieving student data.
 */
public class StudentService {

    private final StudentDAO studentDAO;

    /**
     * Constructs a new StudentService and initializes the StudentDAO implementation.
     */
    public StudentService() {
        studentDAO = new StudentDAOImpl();
    }

    /**
     * Finds a student by their ID.
     *
     * @param id The unique identifier of the student.
     * @return The Student object if found, otherwise null.
     */
    public Student findStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    /**
     * Retrieves a student by their last name.
     *
     * @param studentName The last name of the student.
     * @return The Student object if found, otherwise null.
     */
    public Student getStudentByLastName(String studentName) {
        return studentDAO.getStudentByLastName(studentName);
    }

    public void updateStudent(int studentID, String firstname, String lastname, String email, String grade, String phoneNumber, LocalDate dayOfBirth) {
        if (studentID <= 0 || firstname == null || lastname == null || email == null || grade == null || phoneNumber == null || dayOfBirth == null) {
            System.out.println("Error.");
        }
        studentDAO.updateStudent(studentID,firstname,lastname,email,grade,phoneNumber,dayOfBirth);
        System.out.println("Student updated successfully.");
    }

    public void deleteStudentById(int id) {
        studentDAO.deleteStudent(id);
    }

    public static Date parseDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(dateStr);
            return new Date(utilDate.getTime());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public int addStudent(Student student) {
        if (student ==  null || student.getFirstname() == null || student.getLastname() == null ||
                student.getEmail() == null || student.getGrade() == null || student.getPhoneNumber() == null ||
                student.getDayOfBirth() == null) {
            System.out.println("Error.");
            return 0;
        }
        int id = studentDAO.addStudent(student);
        System.out.println("Student added successfully.");
        return id;
    }

    /**
     * Main method for testing the StudentService class.
     * It retrieves a student with a specific ID and prints it.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student = studentService.findStudentById(1);
        System.out.println(student);
    }

}
