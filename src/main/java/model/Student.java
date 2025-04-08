package model;

import java.time.LocalDate;
import java.util.Date;

/**
 * The Student class represents a student entity in the system.
 * It stores the student's personal information, including their ID, name, email, grade, phone number, and date of birth.
 * The class provides a constructor, getter and setter methods, and a toString method for debugging purposes.
 */
public class Student {
    private int studentID;
    private String firstname, lastname, email, grade, phoneNumber;
    private LocalDate dateOfBirth;

    /**
     * Constructs a new Student with the specified details.
     *
     * @param studentID   The unique identifier for the student.
     * @param firstname   The first name of the student.
     * @param lastname    The last name of the student.
     * @param email       The email address of the student.
     * @param grade       The grade level of the student.
     * @param phoneNumber The contact number of the student.
     * @param dateOfBirth The date of birth of the student.
     */
    public Student(int studentID, String firstname, String lastname, String email, String grade, String phoneNumber, LocalDate dateOfBirth) {
        this.studentID = studentID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(String firstname, String lastname, String email, String grade, String phoneNumber, LocalDate dateOfBirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns a string representation of the Student object.
     *
     * @return A formatted string with student details.
     */
    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth + "\n" +
                '}';
    }

    // Getters and setters

    public int getId() {
        return studentID;
    }

    /**
     * Gets the student ID.
     *
     * @return The student ID.
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Sets the student ID.
     *
     * @param studentID The new student ID.
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Gets the first name of the student.
     *
     * @return The first name of the student.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstname The new first name.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the last name of the student.
     *
     * @return The last name of the student.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastname The new last name.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the date of birth of the student.
     *
     * @return The date of birth.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the student.
     *
     * @param dateOfBirth The new date of birth.
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the email address of the student.
     *
     * @return The email of the student.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the student.
     *
     * @param email The new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the grade level of the student.
     *
     * @return The grade level.
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the grade level of the student.
     *
     * @param grade The new grade level.
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Gets the phone number of the student.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the student.
     *
     * @param phoneNumber The new phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDayOfBirth() {
        return dateOfBirth.toString();
    }

}
