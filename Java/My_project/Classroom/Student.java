package myproject;
import java.util.*;

public class Student {
    private int studentID;
    private String name;
    private Map<String, Double> grades;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name= name;
        this.grades = new HashMap<>();
    }
    // setter Start
    public void setName(String name) {
        this.name = name;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    // setter End
    // getter Start
    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getGrades() {
        return grades;
    }

    // getter End
    public void getScore(String subject, Double score) {
        grades.put(subject, score);
    } // 성적 등록
}
class Class {
    private List<Student> students;
    public Class() {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void printStudentInfo() {
        for (var student : students) {
            System.out.println("학번 : " + student.getStudentID() + ", 이름 : " + student.getName());
            System.out.println("성적 : ");
            for (Map.Entry<String, Double> entry : student.getGrades().entrySet()) {
                System.out.println(entry.getKey() + " : "  + entry.getValue());
            }
        }
    }
}

class Main {
    public static void main(String[] args) {

        Class classroom = new Class(); // 학급 객체 생성
        Student pyo =  new Student(22029026, "pyo"); // 학생 객체 생성
        classroom.addStudent(pyo);
        pyo.getScore("자바", 90.0);
        pyo.getScore("파이썬", 70.0); // 객체 점수 생성

        classroom.printStudentInfo();
    }
}
