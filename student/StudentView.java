package data.base.student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StudentView {

    StudentController controlStudent;
    
    JPanel studentPanel;

    public void studentGui(JFrame frame, String displayName, String section, String idno) {

        controlStudent = new StudentController(this);

        

        studentPanel = new JPanel();
        studentPanel.setLayout(null);
        studentPanel.setBackground(new Color(18, 22, 43));
        studentPanel.setBounds(0, 0, 600, 800);
        studentPanel.setLayout(null);
        frame.add(studentPanel);

        JLabel infoL = new JLabel("YOUR INFORMATION");
        infoL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        infoL.setForeground(new Color(255, 255, 255));
        infoL.setBounds(120, 20, 500, 40);
        studentPanel.add(infoL);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(30, 70, 520, 5);
        studentPanel.add(separator);

        try {
            String imagePath = "pictures\\avatar.jpg";
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image img = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);

            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(30, 100, 200, 200);
            studentPanel.add(imageLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel nameL = new JLabel("Name: ");
        Font nameF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        nameL.setForeground(new Color(255, 255, 255));
        nameL.setBounds(250, 200, 80, 15);
        nameL.setFont(nameF);
        studentPanel.add(nameL);

        JLabel displayL = new JLabel(displayName);
        Font displayF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        displayL.setForeground(new Color(255, 255, 255));
        displayL.setBounds(330, 200, 300, 15);
        displayL.setFont(displayF);
        studentPanel.add(displayL);


        JLabel classL = new JLabel("Section: ");
        Font classF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        classL.setForeground(new Color(255, 255, 255));
        classL.setBounds(250, 240, 80, 15);
        classL.setFont(classF);
        studentPanel.add(classL);

        JLabel sectionL = new JLabel(section);
        Font sectionF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        sectionL.setForeground(new Color(255, 255, 255));
        sectionL.setBounds(330, 240, 300, 15);
        sectionL.setFont(sectionF);
        studentPanel.add(sectionL);

        JLabel idL = new JLabel("ID No: ");
        Font idF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        idL.setForeground(new Color(255, 255, 255));
        idL.setBounds(250, 280, 80, 15);
        idL.setFont(idF);
        studentPanel.add(idL);

        JLabel NoL = new JLabel(idno);
        Font NoF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        NoL.setForeground(new Color(255, 255, 255));
        NoL.setBounds(330, 280, 300, 15);
        NoL.setFont(NoF);
        studentPanel.add(NoL);

        JLabel evaluationL = new JLabel("EVALUATION: ");
        Font evaluationF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        evaluationL.setForeground(new Color(255, 255, 255));
        evaluationL.setBounds(50, 310, 200, 15);
        evaluationL.setFont(evaluationF);
        studentPanel.add(evaluationL);

        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator1.setBounds(30, 350, 520, 5); // Adjust position and size of the separator
        studentPanel.add(separator1);

        JLabel yearLabel1 = new JLabel("YEAR GRADE");
        Font yearFont1 = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
        yearLabel1.setBounds(220, 410, 200, 30); // Adjust position and size
        yearLabel1.setFont(yearFont1);
        yearLabel1.setForeground(new Color(255, 255, 255)); // Set text color
        studentPanel.add(yearLabel1);

        // Create a rectangle and set it as the background for the JLabel
        JPanel rectPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(44, 66 ,184));
                g.fillRect(0, 0, 520, 50);
            }
        };
        rectPanel1.setBounds(30, 400, 520, 50);
        studentPanel.add(rectPanel1);

        // Creating the table for the first year
        String[] columnNames1 = { "Subject", "1st Sem", "2nd Sem", "Finals" };
        Object[][] data1 = {
                { "Math", "", "", "" },
                { "Science", "", "", "" },
                { "History", "", "", "" },
                { "OOP", "", "", "" },
                { "DSA", "", "", "" },
                // Add more rows as needed
        };

        DefaultTableModel tableModel1 = new DefaultTableModel(data1, columnNames1);
        JTable table1 = new JTable(tableModel1);
        JScrollPane scrollPane1 = new JScrollPane(table1);
        scrollPane1.setBounds(30, 450, 520, 250);
        studentPanel.add(scrollPane1);

        JButton logoutBtn = new JButton("LOGOUT");
        logoutBtn.setBounds(460,30,100,25);
        logoutBtn.setBackground(new Color(18, 22, 43));
        logoutBtn.setForeground(new Color(44, 66, 184));
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.addActionListener(controlStudent.getLogoutBtn(frame));
        studentPanel.add(logoutBtn);
    }
    public void displayStudentAccount(String selectedStudent) {
        // Implement logic to display the student's account information
        // For example, update JLabels or open a new window with the relevant information
        System.out.println("Selected student: " + selectedStudent);
    }

}