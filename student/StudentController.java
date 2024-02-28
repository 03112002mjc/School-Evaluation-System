package data.base.student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;
import data.base.login.LoginView;

public class StudentController {

    StudentView viewstudent;
    public LoginView viewLogin;

public StudentController(StudentView viewstudent){

    this.viewstudent = viewstudent;
    this.viewLogin = new LoginView();
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

    
}
