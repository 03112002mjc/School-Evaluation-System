package data.base.login;

import javax.swing.*;
import java.awt.*;

public class GuiFrame extends JFrame{
    LoginView viewLogin;

    public GuiFrame(){

        viewLogin = new LoginView();
        viewLogin.loginGui(this);

        setTitle("SCHOOL EVALUATION SYSTEM");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
}