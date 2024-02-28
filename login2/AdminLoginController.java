package data.base.login2;

import javax.swing.*;

import data.base.login.LoginView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.base.admin.AdminView;

public class AdminLoginController {

    AdminLoginView viewAdLog;
    AdminView viewAdmin;
    LoginView viewLogin;

    public AdminLoginController(AdminLoginView viewAdLog){

        this.viewAdLog = viewAdLog;
        this.viewLogin = new LoginView();
        this.viewAdmin = new AdminView();
    }

    public ActionListener getCancelBtn(JFrame frame){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e){

                frame.getContentPane().removeAll();
                frame.repaint();
                viewLogin.loginGui(frame);
            }
        };
    }
    public ActionListener getLoginBtn(JFrame frame, JTextField idNo, JPasswordField password){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String getIdNo = idNo.getText();
                String getPassword = new String(password.getPassword());

                if (getIdNo.equals("admin") && getPassword.equals("password")) {
                    frame.getContentPane().removeAll();
                    frame.repaint();
                    viewAdmin.adminGui(frame);
 
                 }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                    
                    idNo.setText("");
                    password.setText("");
                 }
               
            }
        };
    }
    
}
