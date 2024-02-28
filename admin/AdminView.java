package data.base.admin;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//import data.base.register.*;

public class AdminView {

    AdminController controlAdmin;

    JPanel adminPanel;
    JButton updateBtn, createBtn, deleteBtn;
      DefaultListModel<String> studentList;
      JList<String> Lists;


    public void adminGui(JFrame frame) {
        
        controlAdmin = new AdminController(this);

        adminPanel = new JPanel();
        adminPanel.setBackground(new Color(18, 22, 43));
        adminPanel.setBounds(0, 0, 600, 800);
        adminPanel.setLayout(null);
        frame.add(adminPanel);

        JLabel adminL = new JLabel("ADMIN");
        adminL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        adminL.setForeground(new Color(255, 255, 255));
        adminL.setBounds(120, 20, 200, 40);
        adminPanel.add(adminL);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(30, 70, 520, 5); // Adjust position and size of the separator
        adminPanel.add(separator);

        try {
            ImageIcon originalIcon = new ImageIcon("pictures\\avatar.jpg");
            Image img = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);

            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(30, 100, 200, 200);
            adminPanel.add(imageLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel nameL = new JLabel("Name: ");
        Font nameF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        nameL.setForeground(new Color(255, 255, 255));
        nameL.setBounds(250, 200, 100, 15);
        nameL.setFont(nameF);
        adminPanel.add(nameL);

        JLabel adminName = new JLabel("CITE Admin");
        adminName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        adminName.setForeground(new Color(255, 255, 255));
        adminName.setBounds(320, 200, 100, 15);
        adminPanel.add(adminName);

        JLabel classL = new JLabel("Class: ");
        Font classF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        classL.setForeground(new Color(255, 255, 255));
        classL.setBounds(250, 240, 100, 15);
        classL.setFont(classF);
        adminPanel.add(classL);

        JLabel idL = new JLabel("ID No: ");
        Font idF = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
        idL.setForeground(new Color(255, 255, 255));
        idL.setBounds(250, 280, 100, 15);
        idL.setFont(idF);
        adminPanel.add(idL);

        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator1.setBounds(30, 330, 520, 5); // Adjust position and size of the separator
        adminPanel.add(separator1);

        DefaultListModel<String> studentList = new DefaultListModel<>();
        JList<String> Lists = new JList<>(studentList);
        Lists.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        Lists.setBounds(30, 420, 520, 200);
        adminPanel.add(Lists);

        createBtn = new JButton("CREATE NEW ACCOUNT");
        createBtn.setBackground(new Color(44, 66, 184));
        createBtn.setForeground(new Color(255, 255, 255));
        createBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        createBtn.setBounds(30, 660, 240, 50);
        createBtn.setFocusable(false);
        createBtn.addActionListener(controlAdmin.getCreateBtn(frame));
        adminPanel.add(createBtn);

        updateBtn = new JButton("UPDATE PROFILE");
        updateBtn.setBackground(new Color(44, 66, 184));
        updateBtn.setForeground(new Color(255, 255 ,255));
        updateBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        updateBtn.setBounds(310, 660, 240, 50);
        updateBtn.setFocusable(false);
        adminPanel.add(updateBtn);

        JButton logoutBtn = new JButton("LOGOUT");
        logoutBtn.setBounds(450,30,100,25);
        logoutBtn.setBackground(new Color(18, 22, 43));
        logoutBtn.setForeground(new Color(44, 66, 184));
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.addActionListener(controlAdmin.getLogoutBtn(frame));
        adminPanel.add(logoutBtn);

           }
              
 public void readRegisteredUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("database\\user.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split("\t");

                // Assuming the format is: section\tidNo\tfullname\tpassword
                if (userData.length >= 3) {
                    String fullName = userData[2];
                    studentList.addElement(fullName);
                }
            }

            // Update your JList
            Lists.setModel(studentList);

            // Refresh the GUI to reflect the changes immediately
            //Lists.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}