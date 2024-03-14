package ch16.edu;

public class Student {
    String name;
    Subject[] subjects = new Subject[2];
    int subjectidx = 0;

    public void setName(String name) {
        this.name = name;
    }
    public void registerSubject(Subject subject) {
        System.out.println(subject.name + " 과목 수강 등록이 완료 되었습니다.");
        if (subjects.length > subjectidx)
        {
            subjects[subjectidx++] = subject;
        }
    }
    public void printSubject() {
        for (var subject: subjects) {
            if (subject != null)
                System.out.println("수강과목 : " + subject.name + " 수강과목코드 : " + subject.code );
        }
    }
    public void SubjectsScore(Subject subject, int score) {
        subject.score = score;
    }
    public void printSubjectScore() {
        int total = 0;
        for (var subject: subjects) {
            if (subject != null) {
                System.out.println("수강과목 : " + subject.name + " 수강과목코드 : " + subject.code + " 수강과목 점수 : " + subject.score );
                total += subject.score;
            }
            System.out.println(this.name + "학생의 총점은 " + total + "점 입니다.");

        }

    }
}
class Subject
{
    String name;
    String code;
    int score;

    public Subject(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
class AppUI {
    public static void main(String[] args) {

        var student = new Student();
        student.setName("kavin"); // kavin 학생 등록

        var math = new Subject("math", "K0001");
        var korean = new Subject("korean", "K0002");

        student.registerSubject(math);
        student.registerSubject(korean);
        student.printSubject();

        student.SubjectsScore(math, 90);
        student.SubjectsScore(korean, 100);
        student.printSubjectScore();

    }


}
