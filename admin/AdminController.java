package data.base.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import data.base.register.RegisterView;
import data.base.login.LoginView;
import data.base.login2.AdminLoginView;

public class AdminController {
    public AdminLoginView viewAdLog;
    public RegisterView viewRegister;
    public LoginView viewLogin;
    AdminView viewAdmin;

    public AdminController(AdminView viewAdmin){

        this.viewAdmin = viewAdmin;
        this.viewRegister = new RegisterView();
        this.viewLogin = new LoginView();
        this.viewAdLog = new AdminLoginView();
    }
    public ActionListener getCreateBtn(JFrame frame){

        return new ActionListener(){

            public void actionPerformed(ActionEvent e){

                frame.getContentPane().removeAll();
                frame.repaint();
                viewRegister.registerGui(frame);
                
            }
        };
    }
    public ActionListener getLogoutBtn(JFrame frame){
        return new ActionListener(){

            public void actionPerformed(ActionEvent e){

                frame.getContentPane().removeAll();
                frame.repaint();
                viewAdLog.login2Gui(frame);
            }
        };
    }
    
}