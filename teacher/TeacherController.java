package data.base.teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

import data.base.login.LoginView;
import data.base.register.Register;
import data.base.student.StudentView;




public class TeacherController {

    public LoginView viewLogin;
    TeacherView viewTeacher;
    StudentView viewstudent;
    JFrame frame;


    public TeacherController(TeacherView viewTeacher){

        this.viewTeacher = viewTeacher;
        this.viewLogin = new LoginView();
        this.viewstudent = new StudentView();
        
        
       
    }

    public ActionListener getLogoutBtn(JFrame frame){
        return new ActionListener(){

            public void actionPerformed(ActionEvent e){

               
                frame.getContentPane().removeAll();
                frame.repaint();
                viewLogin.loginGui(frame);

                JOptionPane.showMessageDialog(null,"LOGOUT SUCCESSFULLY!");

            }
        };
    }

    public void displayStudentAccount(String selectedStudent, JFrame frame) {
        // Assuming studentGui is the method in StudentView to initialize and show the GUI
        frame.getContentPane().removeAll();
        frame.repaint();
        viewstudent.studentGui(new JFrame(),selectedStudent, "Section", "ID Number");
    }
    
    
    public ActionListener getViewBtn(JComboBox<String> studentComboBox) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedStudent = (String) studentComboBox.getSelectedItem();
    
                if (selectedStudent != null && !selectedStudent.startsWith("STUDENT")) {
                    // Call the method to display the student's account view
                    displayStudentAccount(selectedStudent,frame);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a valid student.");
                }
            }
        };
    }
    
    
    
}
   