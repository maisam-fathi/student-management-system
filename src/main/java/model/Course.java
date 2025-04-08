package model;
/**
 * The Course class represents a course in the system.
 * Each course is associated with a unique course ID and a student ID.
 * The class provides constructors, getter and setter methods, and a toString method for debugging.
 */
public class Course {

    private int courseID, studentID;
    private String courseName;

    /**
     * Constructs a new Course with the specified course ID, student ID, and course name.
     *
     * @param courseID   The unique identifier for the course.
     * @param studentID  The ID of the student enrolled in the course.
     * @param course_Name The name of the course.
     */
    public Course(int courseID, int studentID, String course_Name) {
        this.courseID = courseID;
        this.studentID = studentID;
        this.courseName = course_Name;
    }

    /**
     * Returns a string representation of the Course object.
     *
     * @return A formatted string with course details.
     */
    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", studentID=" + studentID +
                ", course_Name='" + courseName + '\'' +
                '}';
    }

    // Getters and setters

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


}
