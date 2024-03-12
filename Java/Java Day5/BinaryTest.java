package ch05;

import java.util.Scanner;

public class BinaryTest {
    public static void main(String[] args) {
        System.out.println("정수 10개를 오름차순으로 입력하세요.");
        Scanner sc = new Scanner(System.in);


        int i = 0;
        int[] arr = new int[10]; // 배열선언
        // 배열에 값 넣기
        while (i < 10) {
            arr[i] = sc.nextInt();
            i++;
        }
        System.out.println("찾을 숫자를 입력하세요.");
        int target = sc.nextInt();

        int loopCnt = 0;

        // length : 배열의 개수 리턴
        int start =0 ;
        int end = arr.length-1;

        boolean bFlag=false;

        while(loopCnt<arr.length){
            int mid = (start+end)/2;

            if (target == arr[start] || target == arr[mid] || target == arr[end]) {
                bFlag=true;
                System.out.println(loopCnt+"번째 루프|"+" start: "+start+", mid: "+mid+", end: "+end);
                break;
            }
            else if (target<arr[mid]) {
                System.out.println(loopCnt+"번째 루프|"+" start: "+start+", mid: "+mid+", end: "+end);
                end=mid;
            }
            else if (target>arr[mid]){
                System.out.println(loopCnt+"번째 루프|"+" start: "+start+", mid: "+mid+", end: "+end);
                start=mid;
            }
            loopCnt++;
        }
        // 배열에 없는 숫자를 입력 받았을 때
        if(bFlag) System.out.println(++loopCnt+"번만에 찾았다.");
        else System.out.println("해당 숫자는 찾을 수 없습니다.");

    }
}