package ch01;

public class JinBupTest {
    public static void main(String[] args){
        int number = 29;
        int radix = 16;
        int reminder = 0;
        int i = 0;

        while(number > 0){
            System.out.println("===="+ ++i + "====");
            reminder = number % radix; //0, 1, 0, 1

            if (radix ==16){
                if(reminder >= 10){
                    char haxChar = (char)('A'+ (reminder-10));
                    System.out.println("reminder : "+haxChar);
                }
                else System.out.println("reminder : "+reminder);
            }
            else {
                System.out.println("reminder : "+reminder);
            }
            number = number / radix; //5, 2, 1, 0
            System.out.println("number : "+ number);
        }
    }
}
