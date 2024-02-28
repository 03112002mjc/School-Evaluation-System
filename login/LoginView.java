package data.base.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginView{

    private LoginController controlLogin;
    private JPanel loginPanel, contentPanel;
    private JTextField idNoField;
    private JPasswordField passwordField;
    private JButton loginButton;
    JProgressBar progressBar=new JProgressBar();

    public void loginGui(JFrame frame) {
        controlLogin = new LoginController(this);

        loginPanel = new JPanel();
        loginPanel.setBackground(new Color(44, 0, 62));
        loginPanel.setSize(600,800);
        loginPanel.setLayout(null);
        frame.add(loginPanel);

        try {
            String imagePath = "pictures\\school1.jpg";
            ImageIcon schoolImage = new ImageIcon(imagePath);
            Image img = schoolImage.getImage().getScaledInstance(525, 255, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);

            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(30, 70, 525, 255);
            loginPanel.add(imageLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(58, 0, 82));
        contentPanel.setBounds(30, 265, 525, 430);
        contentPanel.setLayout(null); // Use absolute positioning for components inside contentPanel
        loginPanel.add(contentPanel);

        // Create and position username label and field
        JLabel welcomeL = new JLabel("WELCOME !");
        welcomeL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
        welcomeL.setForeground(new Color(255, 255, 255));
        welcomeL.setBounds(70, 80, 300, 40);
        contentPanel.add(welcomeL);

        JLabel mottoL = new JLabel("We do ordinary things, extra ordinarily well!");
        mottoL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        mottoL.setForeground(new Color(175, 163, 182));
        mottoL.setBounds(70, 123, 400, 18);
        contentPanel.add(mottoL);

        JLabel idnoL = new JLabel("Id No.");
        idnoL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        idnoL.setForeground(new Color(255, 255, 255));
        idnoL.setBounds(70, 165, 100, 17);
        contentPanel.add(idnoL);

        idNoField = new JTextField();
        idNoField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        idNoField.setBounds(70, 190, 380, 40);
        contentPanel.add(idNoField);

        JLabel passwordL = new JLabel("Password");
        passwordL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        passwordL.setForeground(new Color(255, 255, 255));
        passwordL.setBounds(70, 245, 100, 17);
        contentPanel.add(passwordL);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        passwordField.setBounds(70, 270, 380, 40);
        contentPanel.add(passwordField);

        loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        loginButton.setForeground(new Color(255, 255, 255, 255));
        loginButton.setBackground(new Color(128, 0, 181));
        loginButton.setBounds(130, 350, 250, 45);
        loginButton.setFocusable(false);
        loginButton.addActionListener(controlLogin.getLoginBtn(frame, idNoField, passwordField));
        contentPanel.add(loginButton);

        JButton loginAdminBtn = new JButton("Login as ADMINISTRATOR");
        loginAdminBtn.setBounds(150,400,200,25);
        loginAdminBtn.setBackground(new Color(58, 0, 82));
        loginAdminBtn.setForeground(new Color(44, 66, 184));
        loginAdminBtn.setBorderPainted(false);
        loginAdminBtn.setFocusPainted(false);
        loginAdminBtn.addActionListener(controlLogin.getLoginAdmintBtn(frame));
        contentPanel.add(loginAdminBtn);
}
public void addProgressBar(){
    progressBar.setBounds(50,10,150,30); 
    progressBar.setBorderPainted(true);
    progressBar.setStringPainted(true);
    progressBar.setBackground(Color.black);
    progressBar.setForeground(new Color(0XFF6464));
    progressBar.setValue(0);
    loginPanel.add(progressBar);
}
public void runningPBar(){
    int i=0;
    while( i<=100)
    {
        try{
            Thread.sleep(40);   
            progressBar.setValue(i);    
            i++;
            if(i==100)
            loginPanel.repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
}