package ch18;

import java.util.Scanner;

class Time { // 캡슐화의 정석
    private int hour;
    public boolean setHour(int hour) {
        if (hour < 0 || hour > 24)
            return false;
        this.hour = hour;
        return true;
    }
    public int gethour() {
        return hour;
    }

    @Override // 기계적으로 Overriding
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                '}';
    }
}
public class CapsulTest
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var time = new Time();
        boolean result = false;
        while (!result) {
            System.out.println("input times : ");
            int hour = scanner.nextInt();
            result = time.setHour(hour);
            if (!result) {
                System.out.println("wrong value");
            }
        }
        System.out.println(time);
    }



}
