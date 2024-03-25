package ch07;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        for(int i = 0;i<6;i++) System.out.print(lotto[i]);
        System.out.println();

        Random random = new Random();
        int i=0;
        while (i<lotto.length){
            // int tmpNum=(int)(Math.random()*45)+1; // Math는 더블형, Math를 사용하면 똑같은 숫자가 나올 확률이 조금 더 적다.
            var checkFlag = false;
            int randNum = random.nextInt(45)+1;

            for (int j=0; j<i+1;j++){
                if(lotto[j] == randNum)
                {
                    i--;
                    checkFlag = true;
                    break;

                }
                else if(lotto[i] == randNum)
                {
                    checkFlag = true;
                }

            }
            i++;
        }
        for(int k = 0;k<6;k++) System.out.print(lotto[k]);
        System.out.println();
    }
}
