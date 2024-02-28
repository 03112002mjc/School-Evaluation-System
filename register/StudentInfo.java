package data.base.register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentInfo {
    private String fullName;
    private String section;
    private String idNo;

    public StudentInfo(String fullName, String section, String idNo) {
        this.fullName = fullName;
        this.section = section;
        this.idNo = idNo;
    }
    
    public String getFullName() {
        return fullName;
    }

    public String getSection() {
        return section;
    }

    public String getIdNo() {
        return idNo;
    }
    
}
