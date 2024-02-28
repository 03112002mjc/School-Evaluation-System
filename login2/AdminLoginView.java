package data.base.login2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginView{

    private AdminLoginController controlAdLog;
    private JPanel loginPanel, contentPanel;
    private JTextField idField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelBtn;

    public void login2Gui(JFrame frame) {
        controlAdLog = new AdminLoginController(this);

        loginPanel = new JPanel();
        loginPanel.setBackground(new Color(44, 0, 62));
        loginPanel.setSize(600,800);
        loginPanel.setLayout(null);
        frame.add(loginPanel);

        try {
            String imagePath = "pictures\\avatar.jpg";
            ImageIcon schoolImage = new ImageIcon(imagePath);
            Image img = schoolImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);

            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(200, 100, 200, 200);
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
        JLabel citeLabel = new JLabel("CITE Admin");
        citeLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
        citeLabel.setForeground(new Color(255, 255, 255));
        citeLabel.setBounds(150, 60, 300, 40);
        contentPanel.add(citeLabel);

        JLabel idLabel = new JLabel("Username");
        idLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        idLabel.setForeground(new Color(255, 255, 255));
        idLabel.setBounds(70, 165, 100, 17);
        contentPanel.add(idLabel);

        idField = new JTextField();
        idField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        idField.setBounds(70, 190, 380, 40);
        contentPanel.add(idField);

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
        loginButton.setBounds(130, 330, 250, 30);
        loginButton.setFocusable(false);
        loginButton.addActionListener(controlAdLog.getLoginBtn(frame, idField, passwordField));
        contentPanel.add(loginButton);

        cancelBtn = new JButton("RETURN");
        cancelBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        cancelBtn.setForeground(new Color(255, 255, 255, 255));
        cancelBtn.setBackground(new Color(128, 0, 181));
        cancelBtn.setBounds(130, 380, 250, 30);
        cancelBtn.setFocusable(false);
        cancelBtn.addActionListener(controlAdLog.getCancelBtn(frame));
        contentPanel.add(cancelBtn);

        
}

   
}