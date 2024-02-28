package data.base.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {

    public String[] loginFileHandling(String getIdNo, String getPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("database\\user.dat"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");

                if (parts.length >= 4) {
                    String section = parts[0];
                    String idNo = parts[1];          
                    String fullName = parts[2];
                    String password = parts[3];

                    if (getIdNo.equals(idNo) && getPassword.equals(password)) {
                        return new String[]{fullName, section, idNo};
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}