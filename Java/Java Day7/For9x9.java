package ch07;

public class For9x9 {
    public static void main(String[] args) {

        for (int i=1;i<=9;i++)
        {
            for(int j=1;j<=9;j++)
            {
                int total = i * j;
                System.out.println(i + " * " + j + " = " + total );
            }

        }

    }
}
