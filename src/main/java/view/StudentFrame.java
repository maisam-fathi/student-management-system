package view;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import service.CourseService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;


/**
 * This class represents the GUI for student registration.
 * It provides fields for inputting student details and buttons for performing operations.
 * The class extends JFrame and contains multiple UI components for user interaction.
 */
public class StudentFrame extends JFrame {
    // UI components
    private JPanel studentInfoPanel;
    private JLabel firstNameLabel, lastNameLabel, studentIdLabel, emailLabel, courseLabel, dayOfBirthLabel, gradeLabel, phoneNumberLabel;
    private JTextField firstNameField, lastNameField, studentIdField, emailField, dayOfBirthField, gradeField, phoneNumberField;
    private JComboBox<String> courseComboBox;
    private JPanel buttonPanel;
    private JButton registerButton, allStudentButton, updateButton, deleteButton, searchButton;

    //private StudentDAO studentDAO = new StudentDAOImpl();
    private CourseService courseService = new CourseService();

    /**
     * Constructs the student registration window.
     * Initializes the UI components, sets the layout, and adds event listeners.
     * The window contains fields for student details and buttons for CRUD operations.
     */
    public StudentFrame() {
        // Set the title of the window and its size
        setTitle("Student Frame");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the panel for student information input
        studentInfoPanel = new JPanel();
        studentInfoPanel.setLayout(new GridLayout(8, 2, 5, 5));

        // Create labels and text fields
        studentIdLabel = new JLabel("Student ID:");
        studentIdField = new JTextField(20);
        firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);
        lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);
        emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        dayOfBirthLabel = new JLabel("Day Of Birth:");
        dayOfBirthField = new JTextField(20);
        gradeLabel = new JLabel("Grade:");
        gradeField = new JTextField(20);
        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField(20);
        courseLabel = new JLabel("Select the Course:");

        // Field filled with courses until the database is connected
        List<String> courses = courseService.getAllCourses();
        courseComboBox = new JComboBox<>(courses.toArray(new String[0]));

        // Add components to the panel
        studentInfoPanel.add(studentIdLabel);
        studentInfoPanel.add(studentIdField);
        studentInfoPanel.add(firstNameLabel);
        studentInfoPanel.add(firstNameField);
        studentInfoPanel.add(lastNameLabel);
        studentInfoPanel.add(lastNameField);
        studentInfoPanel.add(emailLabel);
        studentInfoPanel.add(emailField);
        studentInfoPanel.add(dayOfBirthLabel);
        studentInfoPanel.add(dayOfBirthField);
        studentInfoPanel.add(gradeLabel);
        studentInfoPanel.add(gradeField);
        studentInfoPanel.add(phoneNumberLabel);
        studentInfoPanel.add(phoneNumberField);
        studentInfoPanel.add(courseLabel);
        studentInfoPanel.add(courseComboBox);

        // Create panel for the button and set its layout to center the button
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create the buttons
        allStudentButton = new JButton("All Students");
        updateButton = new JButton("Update");
        registerButton = new JButton("Register a Student");
        deleteButton = new JButton("Delete");
        searchButton = new JButton("Search");

        // Add the buttons to the button panel
        buttonPanel.add(allStudentButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);

        // Add panels to the frame
        add(studentInfoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Make the window visible
        setVisible(true);

        // Set default values for all fields
        setDefaultValues();
    }

    /**
     * Adds an ActionListener to all buttons in the frame.
     * This allows handling user actions such as registering, updating, deleting, or searching for students.
     *
     * @param aL the ActionListener to be added to the buttons.
     */
    public void addActionListenerToButton(ActionListener aL) {
        registerButton.addActionListener(aL);
        allStudentButton.addActionListener(aL);
        updateButton.addActionListener(aL);
        deleteButton.addActionListener(aL);
        searchButton.addActionListener(aL);
        System.out.println("Button pressed");
    }

    public String getFirstName() {
        return firstNameField.getText().trim();
    }

    public String getLastName() {
        return lastNameField.getText().trim();
    }

    public int getStudentID() {
        try {
            return Integer.parseInt(studentIdField.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String getEmail() {
        return emailField.getText().trim();
    }

    public String getCourse() {
        return courseComboBox.getSelectedItem().toString();
    }

    public String getDayOfBirth() {
        return dayOfBirthField.getText().trim();
    }

    public String getGrade() {
        return gradeField.getText().trim();
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText().trim();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getAllStudentButton() {
        return allStudentButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void setDefaultValues() {
        firstNameField.setText("Peter");
        lastNameField.setText("Müller");
        //studentIdField.setText("0");
        emailField.setText("peter.mueller@gmail.com");
        dayOfBirthField.setText("1996-12-10");
        gradeField.setText("A");
        phoneNumberField.setText("+1234567890");
    }

    /**
     * Main method to run the application.
     * It creates an instance of StudentFrame to display the GUI.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        new StudentFrame();
    }
}
