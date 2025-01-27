package task3;

import java.util.HashMap;
import java.util.Map;

public class Hash_Map {
    private Map<String, Integer> grades = new HashMap<>();

    public void addStudent(String name, int grade) {
        grades.put(name, grade);
    }

    public void removeStudent(String name) {
        grades.remove(name);
    }

    public void printAllStudents() {
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Grade: " + entry.getValue());
        }//Kayipov Yerasyl
    }

    public void searchGrade(String name) {
        if (grades.containsKey(name)) {
            System.out.println("Grade for " + name + ": " + grades.get(name));
        } else {
            System.out.println("Student not found.");
        }
    }
}
