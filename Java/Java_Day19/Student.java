package ch22;

import java.awt.color.ICC_ColorSpace;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.*;

class  ClassMgr {
    private static ClassMgr INSTANCE; // singleton
    private Set<Classroom> classes;
    public ClassMgr() {
        classes = new HashSet<>();
    }
    public static ClassMgr getInstance() {
        if (INSTANCE == null) INSTANCE = new ClassMgr();
        return INSTANCE;
    }
    public void createClassroom(String name) {
        classes.add(new Classroom("A Class"));
    }

    public Classroom findClass(String name){
        for(var class_ : classes) {
            if (Objects.equals(class_.getName(),name)) return class_;
        }
        return null;
    }
}

class Classroom {
    private String name;

    @Override
    public String toString() {
        return "Classroom{" +
                "name='" + name + '\'' +
                ", students=" + students +
                ", grades=" + grades +
                '}';
    }

    private static Long studentNum =1L;
    private Set<Student> students;
    private List<Grade> grades;
    public Classroom(String name) {
        this.name = name;
        students = new HashSet<>();
        grades = new ArrayList<>();
    }
    public void createStudent(String name) {
        students.add(new Student(name,Classroom.studentNum++));

    }
    public Student findStudent(Long studentNum) {
        for (var student : students) {
            if (Objects.equals(student.getSudentNum(),studentNum)) return student;
        }
        return null;
    }

    public void setGradeStudent(Long studentNum, Suject suject, int score) {
        grades.add(new Grade(studentNum, suject, score));
    }


    public String getName() {
        return name;
    }
}

enum Suject {
    KOREAN,
    MATH,
}

class Grade {
    private Long studentNum;
    private Suject suject;
    private int score;

    public Grade(Long studentNum, Suject suject, int score) {
        this.studentNum = studentNum;
        this.suject = suject;
        this.score = score;
    }

    public Long getStudentNum() {
        return studentNum;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentNum=" + studentNum +
                ", suject=" + suject +
                ", score=" + score +
                '}';
    }

    public int getScore() {
        return score;
    }

    public Suject getSuject() {
        return suject;
    }
}

public class Student {
    private String name;
    private  Long sudentNum;

    public Student(String name) {
        this(name,null);
    }

    public Long getSudentNum() {
        return sudentNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(sudentNum, student.sudentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sudentNum);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sudentNum=" + sudentNum +
                '}';
    }

    public Student(String name, Long sudentNum) {
        this.name = name;
        this.sudentNum = sudentNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Main {
    public static void main(String[] args) {
        ClassMgr.getInstance().createClassroom("A Class"); // 학급 생성
        var findClass = ClassMgr.getInstance().findClass("A Class");
        findClass.createStudent("kavin"); // 학급을 찾아서 학생 등록
        findClass.createStudent("david");

        findClass.setGradeStudent(2L, Suject.KOREAN, 90);
        System.out.println(findClass);



    }
}