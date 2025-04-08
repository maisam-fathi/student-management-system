package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StudentSearchFrame extends JFrame {
    // Declare the variable
    private JPanel studentPanel;
    private JLabel studentLabel;
    private JTextField studdentTextField;
    private JButton studentButton;

    // Constructor to create the window
    public StudentSearchFrame(){
        //getContentPane();
        // Set the title of the window and its size
        setTitle("Student search");
        setSize(500, 200);
        // Exit when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the window on the screen
        setLocationRelativeTo(null);

        // Create a panel
        studentPanel = new JPanel(new GridBagLayout());
        // Set the background color of the panel
        studentPanel.setBackground(Color.GRAY);

        // Create label and text field for student name input
        studentLabel = new JLabel("Enter the student's name: ");
        studentPanel.add(studentLabel);

        // Create a text field for user input
        studdentTextField = new JTextField(20);
        // Add the text field to the panel
        studentPanel.add(studdentTextField);

        // Create a button with text "Search"
        studentButton = new JButton("Search");
        // Add the button to the panel
        studentPanel.add(studentButton);

        // Add the panel to the center of the window
        add(studentPanel, BorderLayout.CENTER);

        // Make the window visible
        setVisible(true);

    }
    // Method to add an action listener to the button
    public void addActionListenerToButton(ActionListener aL) {
        studentButton.addActionListener(aL);
    }

    public String getStudentNameField() {
        return studdentTextField.getText();
    }

}
