package ch07;

public class For54321star {
    public static void main(String[] args) {
        int row = 5;
        int col = 5;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<5-i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
