package controller;

import service.CourseService;
import view.StudentFrame;

import javax.swing.*;
import java.util.List;

public class CourseController {
    private final StudentFrame courseRegistrationFrame;
    private final CourseService courseService;

    public CourseController() {
        courseRegistrationFrame = new StudentFrame();
        courseService = new CourseService();
    }
    public void showAllCourses() {
        List<String> courses = courseService.getAllCourses();

        if (courses.isEmpty()) {
            JOptionPane.showMessageDialog(courseRegistrationFrame, "Error. Course list is empty.");
            return;
        }

        StringBuilder coursesBuilder = new StringBuilder();
        for (String course : courses) {
            coursesBuilder.append("\n");
        }
        JOptionPane.showMessageDialog(courseRegistrationFrame, coursesBuilder.toString());
    }

}

