package ch06;

import java.util.Random;
import java.util.Scanner;

public class RSP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int winCnt = 0;
        int loseCnt = 0;

        while (true) {
            int comNum = random.nextInt(3)+1;
            System.out.println(comNum);

            System.out.println("가위(1),바위(2),보(3) 숫자를 입력하세요:");
            int userNum = scanner.nextInt();

            final int GAWI = 1;
            final int BAWI = 2;
            final int BO = 3;

            if (comNum == userNum) System.out.println("무승부");
            else {
                switch (comNum) {
                    case GAWI -> {
                        if (userNum == BAWI) {
                            System.out.println("승리");
                            winCnt++;
                        } else {
                            System.out.println("패배");
                            loseCnt++;
                        }
                    }
                    case BAWI -> {
                        if (userNum == BO) {
                            System.out.println("승리");
                            winCnt++;
                        } else {
                            System.out.println("패배");
                            loseCnt++;
                        }
                    }
                    case BO -> {
                        if (userNum == GAWI) {
                            System.out.println("승리");
                            winCnt++;
                        } else {
                            System.out.println("패배");
                            loseCnt++;
                        }

                    }

                        }
                    }

            System.out.println();
            System.out.println("Win count: " +winCnt +" " + "Lose Count: " + loseCnt);

            System.out.println("한 게임 더(1), 종료(2)");
            int gameCountinue = scanner.nextInt();

            if (gameCountinue == 2) break;

                }

            }
        }
