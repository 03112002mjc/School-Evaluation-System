package data.base.register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import data.base.admin.AdminView;
import data.base.admin.AdminController;
import data.base.login.LoginView;

public class RegisterController {
    Register register;
    RegisterView viewRegister;
    public AdminController controlAdmin;
    public AdminView viewAdmin;
    public LoginView viewLogin;

    public RegisterController(RegisterView viewRegister){

        this.viewRegister = viewRegister;
        this.viewAdmin = new AdminView();
        this.register = new Register();
        this.viewLogin = new LoginView();
       
       

    }
    public ActionListener getCancelBtn(JFrame frame){
        return new ActionListener(){

            public void actionPerformed(ActionEvent e){

                frame.getContentPane().removeAll();
                frame.repaint();
                viewAdmin.adminGui(frame);
            }

        };
    }
    public ActionListener getRegisterBtn(JFrame frame, JTextField fullname, JTextField section, JTextField idNo, JTextField password) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fullNameText = fullname.getText();
                String sectionText = section.getText();
                String idNoText = idNo.getText();
                String passwordText = password.getText();

                if (fullNameText.isEmpty() || sectionText.isEmpty() || idNoText.isEmpty() || passwordText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the required fields");
                } else {
                    boolean isRegistered = register.registerUser(fullNameText, sectionText, idNoText, passwordText);

                    if (isRegistered) {
                        JOptionPane.showMessageDialog(frame, "Registration Successful");
                        
                        fullname.setText("");
                        section.setText("");
                        idNo.setText("");
                        password.setText("");
                    } else {
                        boolean idExists = register.doesIdExist(idNoText);
                        boolean fullNameExists = register.doesFullNameExist(fullNameText);

                        if (idExists) {
                            JOptionPane.showMessageDialog(frame, "ID number already exists. Please use a different ID number.");
                        } else if (fullNameExists) {
                            JOptionPane.showMessageDialog(frame, "This Account Name already exists. Create new!");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Registration Failed. Please try again.");
                        }
                    }
                }
            }
        };
    }
    public ActionListener getStudentBtn(){

     return new ActionListener(){

        public void actionPerformed(ActionEvent e){

            viewRegister.idNo.setText("STDNT-");
            viewRegister.teacherBtn.setSelected(false);
         }
        };
    }
    public ActionListener getTeacherBtn(){

    return new ActionListener(){

        public void actionPerformed(ActionEvent e){

            viewRegister.idNo.setText("TCHR-");
            viewRegister.studentBtn.setSelected(false); 
         }
        };
    }
    public ActionListener getHomeBtn(JFrame frame){

        return new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
    
                frame.getContentPane().removeAll();
                frame.repaint();
                viewLogin.loginGui(frame);
             }
            };
        }
}