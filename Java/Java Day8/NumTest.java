package ch08;

import java.util.Scanner;

public class NumTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] com = new int[3];
        int[] user = new int[3];
        boolean[] checkBit = new boolean[10]; // (1에서 9까지) 배열은 0부터 시작하니까 10으로
// boolean 기본은 false

        for (var i =0; i<3; i++){
            while(true){
                int comNum = (int)(Math.random()*9)+1;
                if(!checkBit[comNum]) {
                    com[i] = comNum;
                    checkBit[comNum]=true;
                    break;
                }
            }
        }
        for(var n: com) System.out.print("random="+n+" ");

        System.out.println();
        System.out.println("1에서 9까지의 숫자 3개 입력");
        for(var i = 0; i<3;i++){
            user[i]=sc.nextInt();
        }

        var passCnt=0;
        var failCnt=0;
        for(var i =0;i<3;i++){
            if(com[i]==user[i]) passCnt++;
            else if (com[0] == user[1] || com[0]==user[2]) failCnt++;
            else if (com[1] == user[0] || com[1]==user[2]) failCnt++;
            else if (com[2] == user[0] || com[2]==user[1]) failCnt++;
        }

        System.out.printf("%d pass, %d fail",passCnt,failCnt);
    }
}
