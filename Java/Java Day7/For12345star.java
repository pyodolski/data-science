package ch07;

public class For12345star {
    public static void main(String[] args) {
        int row = 5;
        int col = 5;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<4-i;j++)
            {
                System.out.print(" "); // 공백
            }
            for(int k=0;k<i+1;k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
