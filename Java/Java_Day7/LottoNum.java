package ch07;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LottoNum {
    public static void main(String[] args) {
        // Random random = new Random();
        // random.nextInt(45)+1;
        //int tmpNum = (int)(Math.random()*45)+1; // 1~ 45의 랜덤 수를 뽑아내기 위한 코드


        int[] lottoNum = new int[6]; // 방이 6개인 정수 리스트 생성
        boolean[] pickCheck = new boolean[46];
        int size = 0;

        for (int i=0;i<lottoNum.length;i++) {
            while (true) {
                var ranNum = (int) (Math.random() * 45) + 1;

                if (!pickCheck[ranNum]) {
                    pickCheck[ranNum] = true;
                    lottoNum[i] = ranNum;
                    break;
                }
            }
        }

//        for(int i= 0; i<6; i++)
//        {
//            var randNum = (int)(Math.random()*45)+1;
//            // 수학적인 무언가를 할 때에는 Math를 사용하는 것이 효율적이다
//            var checkFlag = false;
//            for(int j = 0; j<size;j++)
//            {
//
//                if(lottoNum[j] == randNum)
//                {
//                    i--; // 숫자가 저장되지 않았기 때문에 i 감소시켜야 함
//                    checkFlag = true;
//                    break;
//                }
//            }
//            if(!checkFlag)
//            {
//                lottoNum[i] = randNum;
//                size++; // 배열 안에 들어간 수 만큼만 루프를 돌게 하기 위한 코드
//            }
//        }

        // enhanced for
        for(var num : lottoNum) // 저장할 수 있는 무언가는 뒤에 올 수 있음
        {
            System.out.println(num + " ");
        }
       // 랜덤 수 6개를 저장했지만 중복 수를 제외시켜야 함



    }
}
