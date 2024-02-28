package data.base.register;

import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Register {
    

    public boolean doesIdExist(String id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("database\\user.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split("\t");
    
                if (userData.length > 1) {
                    String existingId = userData[1]; 
                    if (existingId.equals(id)) {
                        return true;
                    }
                } else {
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();    
        }
        return false;
    }
    public boolean doesFullNameExist(String fullName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("database\\user.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split("\t");

                if (userData.length > 2) {
                    String existingFullName = userData[2]; 

                    if (existingFullName.equals(fullName)) {
                        return true; 
                    }
                } else {
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public boolean registerUser(String fullname, String section, String idNo, String password) {
        boolean idExists = doesIdExist(idNo);
        boolean fullNameExists = doesFullNameExist(fullname);

        if (idExists || fullNameExists) {
            return false; 
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("database\\user.dat", true))) {
            writer.write(section + "\t" + idNo + "\t" + fullname + "\t" + password + "\n");
            return true; 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; 
    }
    public List<String> getRegisteredUsers() {
        List<String> userList = new ArrayList<>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader("database\\user.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split("\t");
                if (userData.length > 2) {
                    String fullName = userData[2];
                    userList.add(fullName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return userList;
    }
    public List<String> getRegisteredStudentsInSameSection(String section) {
        List<String> studentList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("database\\user.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split("\t");
                if (userData.length > 2 && userData[1].startsWith("STDNT") && userData[0].equals(section)) {
                    String fullName = userData[2];
                    studentList.add(fullName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentList;
    }
}