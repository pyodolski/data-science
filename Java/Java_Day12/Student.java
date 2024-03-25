package Java_Day12;
// Q1 표주원 버전
public class Student {
    String name;
    String address;
    int code;
    // Setter start
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCode(int code) {
        this.code = code;
    }
    // Setter end
    public void printInfo(){
        System.out.println("이름 : " + name + ", " + "주소 : " + address + ", " + "학번 : " + code);
    }
    // 학생 정보 출력 함수


}

class DaeguU {
    Student[] students = new Student[2];
    int studentidx;

    public void addStudent(Student student) {
        if (students.length > studentidx)
        {
            students[studentidx++] = student;
        }
    }
    // 저장 된 학생 수에 맞는 배열 처리

    public void printInfo()
    {
        for (var student : students)
        {
            student.printInfo();
        }
    }
}

class AppUI {
    public static void main(String[] args) {
        var student1 = new Student();
        student1.setName("PYO");
        student1.setAddress("Daegu");
        student1.setCode(1);

        var student2 = new Student();
        student2.setName("Kim");
        student2.setAddress("Seoul");
        student2.setCode(2);
        // 학생이 학생정보 입력
        var daeguU = new DaeguU();
        daeguU.addStudent(student1);
        daeguU.addStudent(student2);
        // 대구대학교에 학생 등록
        daeguU.printInfo();
    }
}
