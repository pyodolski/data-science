package ch07;

public class While9x9 {
    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        while(i<=9)
        {
            while(j<=9)
            {
                int total = i * j;
                System.out.println(i + " * " + j + " = " + total );
                j++;
            }
            i++;
        }
    }
}
