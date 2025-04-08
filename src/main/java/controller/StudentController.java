package controller;

import model.Student;
import service.StudentService;
import view.StudentFrame;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

/**
 * The StudentController class manages the interaction between the user interface and the underlying services.
 * It handles user actions, such as searching for a student, and communicates with the StudentService.
 */
public class StudentController {

    private final StudentFrame studentRegistrationFrame;
    private final StudentService studentService;


    /**
     * Constructor for the StudentController class.
     * Initializes the UI components and assigns event listeners.
     */
    public StudentController() {
        this.studentRegistrationFrame = new StudentFrame();
        this.studentService = new StudentService();

        // Adding an event listener for the search button
        studentRegistrationFrame.getSearchButton().addActionListener(e -> searchStudent());
        studentRegistrationFrame.getDeleteButton().addActionListener(e -> deleteStudent());
        studentRegistrationFrame.getUpdateButton().addActionListener(e -> updateStudent());
        studentRegistrationFrame.getAllStudentButton().addActionListener(e -> showAllStudents());
        studentRegistrationFrame.getRegisterButton().addActionListener(e -> addStudent());
    }

    /**
     * Searches for a student based on the name entered in the search field.
     * If the input field is empty, an error message is displayed.
     * If a student is found, their details are shown in a dialog box.
     * If no student is found, a warning message is displayed.
     */
    private void searchStudent() {
        int studentID = studentRegistrationFrame.getStudentID();

        if (studentID <= 0) {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Error! Please enter a student ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = studentService.findStudentById(studentID);
        if (student != null) {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Found student: " + student.getFirstname() + " " + student.getLastname(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Student with ID '" + studentID + "' not found.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void deleteStudent() {
        int studentID = studentRegistrationFrame.getStudentID();

        if (studentID <= 0) {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Error! Please enter a student ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int comfirmation = JOptionPane.showConfirmDialog(studentRegistrationFrame, "Remove a student with ID " + studentID + "?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (comfirmation == JOptionPane.YES_OPTION) {
            studentService.deleteStudentById(studentID);
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Student deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateStudent() {
        int studentID = studentRegistrationFrame.getStudentID();

        if (studentID <= 0) {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Error! Please enter a student ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String firstName = studentRegistrationFrame.getFirstName();
        String lastName = studentRegistrationFrame.getLastName();
        String email = studentRegistrationFrame.getEmail();
        String phoneNumber = studentRegistrationFrame.getPhoneNumber();
        String dayOfBirthStr = studentRegistrationFrame.getDayOfBirth();
        String grade = studentRegistrationFrame.getGrade();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || grade.isEmpty() || phoneNumber.isEmpty() || dayOfBirthStr.isEmpty()) {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Error! Please enter all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate dayOfBirth = null;
        try {
             dayOfBirth = LocalDate.parse(dayOfBirthStr);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Error! Invalid date format. Please use yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student updatedStudent = new Student(studentID, firstName, lastName, email, grade, phoneNumber, dayOfBirth);
        studentService.updateStudent(studentID, firstName, lastName, email, grade, phoneNumber, dayOfBirth);

        JOptionPane.showMessageDialog(studentRegistrationFrame, "Student updated", "Success", JOptionPane.INFORMATION_MESSAGE);
    }


    private void showAllStudents() {
        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Error! No students found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Define table columns
        String[] columnNames = {"ID", "First Name", "Last Name", "Email", "Phone", "Date of Birth", "Grade"};

        // Create a 2D array to store student data
        String[][] data = new String[students.size()][columnNames.length];

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            data[i][0] = String.valueOf(student.getId());
            data[i][1] = student.getFirstname();
            data[i][2] = student.getLastname();
            data[i][3] = student.getEmail();
            data[i][4] = student.getPhoneNumber();
            data[i][5] = student.getDayOfBirth().toString();
            data[i][6] = student.getGrade();
        }

        // Create JTable and put it inside JScrollPane
        JTable studentTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        // Create JFrame to display student details
        JFrame studentsJFrame = new JFrame("All Students");
        studentsJFrame.setSize(700, 400);
        studentsJFrame.add(scrollPane);
        studentsJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        studentsJFrame.setVisible(true);
    }

    private void addStudent() {
        String firstName = studentRegistrationFrame.getFirstName();
        String lastName = studentRegistrationFrame.getLastName();
        String email = studentRegistrationFrame.getEmail();
        String phoneNumber = studentRegistrationFrame.getPhoneNumber();
        String dayOfBirthStr = studentRegistrationFrame.getDayOfBirth();
        String grade = studentRegistrationFrame.getGrade();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || grade.isEmpty() || phoneNumber.isEmpty() ||
                dayOfBirthStr.isEmpty()) {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Error! Please enter all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate dayOfBirth = null;
        try {
            dayOfBirth = LocalDate.parse(dayOfBirthStr);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Error! Invalid date format. Please use yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student addedStudent = new Student(firstName, lastName, email, grade, phoneNumber, dayOfBirth);
        int id = studentService.addStudent(addedStudent);

        if (id > 0) {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Student registered successfully with ID: " + id, "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(studentRegistrationFrame, "Error! Student not registrired.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * The main method to run the application.
     * Creates an instance of StudentController to initialize the program.
     */
    public static void main(String[] args) {
        new StudentController();
    }

}
















    /*
    private final StudentSearchFrame studentSearchFrame;
    private StudentRegistrationFrame studentRegistrationFrame;
    private final StudentService studentService;
*/
    /**
     * Constructor for the StudentController class.
     * Initializes the UI components and assigns event listeners.
     */
/*    public StudentController() {
        this.studentSearchFrame = new StudentSearchFrame();
        this.studentService = new StudentService();

        // Adding an event listener for the search button
        this.studentSearchFrame.addActionListenerToButton(e -> searchStudent());
    }
*/
    /**
     * Searches for a student based on the name entered in the search field.
     * If the input field is empty, an error message is displayed.
     * If a student is found, their details are shown in a dialog box.
     * If no student is found, a warning message is displayed.
     */
/*    private void searchStudent() {
        String studentName = studentSearchFrame.getStudentNameField();

        if (studentName.isEmpty()) {
            JOptionPane.showMessageDialog(studentSearchFrame, "Error! Please enter a student name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = studentService.getStudentByLastName(studentName);
        if (student != null) {
            JOptionPane.showMessageDialog(studentSearchFrame, "Found student: " + student.getFirstname() + " " + student.getLastname(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(studentSearchFrame, "Student with name '" + studentName + "' not found.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
*/
    /**
     * The main method to run the application.
     * Creates an instance of StudentController to initialize the program.
     */






