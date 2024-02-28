package data.base.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.base.teacher.TeacherView;

public class DataModel {
    private static DataModel instance = new DataModel();

    private Map<String, List<TeacherView>> teacherObservers;

    private DataModel() {
        teacherObservers = new HashMap<>();
    }

    public static DataModel getInstance() {
        return instance;
    }

    public void registerTeacherObserver(String section, TeacherView teacherView) {
        teacherObservers.computeIfAbsent(section, k -> new ArrayList<>()).add(teacherView);
    }

    public void notifyStudentRegistered(String studentName, String studentSection) {
        List<TeacherView> observers = teacherObservers.get(studentSection);
        if (observers != null) {
            for (TeacherView observer : observers) {
                observer.updateStudentList(studentName);
            }
        }
    }
}
