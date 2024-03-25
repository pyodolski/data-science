package ch01;

public class BinaryTest {

    public static void main(String[] args){
        int num = 10; //10진수
        int bnum = 0B1010; //0B : 2진수를 나타냄
        int onum = 012; //0: 8진수
        int xnum = 0xA; //0x: 16진수

        System.out.println(bnum);
        System.out.println(onum);
        System.out.println(xnum);

        char c = 'A';
        System.out.println((int)c);

        char uc = '\uAC11';
        System.out.println(uc);

        char uc2 = '갑';
        System.out.println(Integer.toHexString((uc2))); // 유니코드 -> 16진수

    }
}
