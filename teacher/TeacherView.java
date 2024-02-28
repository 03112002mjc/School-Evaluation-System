package data.base.teacher;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import data.base.register.Register;

public class TeacherView {
    private JPanel teacherPanel;
    private TeacherController controlTeacher;
    private Register register;
    private JComboBox<String> studentComboBox;
    private JButton viewBtn;
    

   

    public void teacherGui(JFrame frame, String displayName, String section, String idno) {

        this.controlTeacher = new TeacherController(this);
        this.register = new Register();
        

        teacherPanel = new JPanel();
        teacherPanel.setBackground(new Color(18, 22, 43));
        teacherPanel.setBounds(0, 0, 600, 800);
        teacherPanel.setLayout(null);
        frame.add(teacherPanel);

        JLabel teacherL = new JLabel("Teacher");
        teacherL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        teacherL.setForeground(new Color(255, 255, 255));
        teacherL.setBounds(220, 20, 200, 30);
        teacherPanel.add(teacherL);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(30, 70, 520, 5);
        teacherPanel.add(separator);

        try {
            String imagePath = "pictures\\avatar.jpg";
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image img = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);

            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(30, 100, 200, 200);
            teacherPanel.add(imageLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel nameL = new JLabel("Name: ");
        Font nameF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        nameL.setForeground(new Color(255, 255, 255));
        nameL.setBounds(250, 200, 80, 15);
        nameL.setFont(nameF);
        teacherPanel.add(nameL);

        JLabel displayL = new JLabel(displayName);
        Font displayF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        displayL.setForeground(new Color(255, 255, 255));
        displayL.setBounds(330, 200, 300, 15);
        displayL.setFont(displayF);
        teacherPanel.add(displayL);

        JLabel classL = new JLabel("Class: ");
        Font classF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        classL.setForeground(new Color(255, 255, 255));
        classL.setBounds(250, 240, 80, 15);
        classL.setFont(classF);
        teacherPanel.add(classL);

        JLabel sectionL = new JLabel(section);
        Font sectionF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        sectionL.setForeground(new Color(255, 255, 255));
        sectionL.setBounds(330, 240, 300, 15);
        sectionL.setFont(sectionF);
        teacherPanel.add(sectionL);

        JLabel idL = new JLabel("ID No: ");
        Font idF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        idL.setForeground(new Color(255, 255, 255));
        idL.setBounds(250, 280, 80, 15);
        idL.setFont(idF);
        teacherPanel.add(idL);

        JLabel NoL = new JLabel(idno);
        Font NoF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        NoL.setForeground(new Color(255, 255, 255));
        NoL.setBounds(330, 280, 300, 15);
        NoL.setFont(NoF);
        teacherPanel.add(NoL);

        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator1.setBounds(30, 330, 520, 5); 
        teacherPanel.add(separator1);

        List<String> registeredStudents = register.getRegisteredStudentsInSameSection(section);
        Comparator<String> idComparator = Comparator.comparing(str -> {
            String[] userData = str.split("\t");
            if (userData.length > 1) {
                String id = userData[1];
                String numericPart = id.substring(id.lastIndexOf('-') + 1);
                return Integer.parseInt(numericPart);
            } else {
                return 0;
            }
        });

        Collections.sort(registeredStudents, idComparator);
        registeredStudents.add(0, "STUDENT " + "of "+ section);
        String[] studentArray = registeredStudents.toArray(new String[0]);

        studentComboBox = new JComboBox<>(studentArray);
        studentComboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        studentComboBox.setBounds(130, 400, 300, 30);
        teacherPanel.add(studentComboBox);

        JButton logoutBtn = new JButton("LOGOUT");
        logoutBtn.setBounds(460,30,100,25);
        logoutBtn.setBackground(new Color(18, 22, 43));
        logoutBtn.setForeground(new Color(44, 66, 184));
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.addActionListener(controlTeacher.getLogoutBtn(frame));
        teacherPanel.add(logoutBtn); 
        
        viewBtn = new JButton("View Account");
        viewBtn.setBounds(200, 500, 150, 50);
        viewBtn.addActionListener(controlTeacher.getViewBtn(studentComboBox));         
        teacherPanel.add(viewBtn);

    
    }
    public void displayAccountInformation( String selectedStudent) {
        // Add your logic here to display the account information on the GUI
        // For example, you might update JLabels with the relevant information.
        // Parse the accountInformation string as needed.
        // This is a placeholder method, and you need to customize it based on your GUI design.
        System.out.println("Selected student: " + selectedStudent);

    }
   
}
