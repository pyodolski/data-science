// *****
//  ***
//   *


package ch07;

public class ForTstar {
    public static void main(String[] args) {
        int row = 3;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<i+1;j++)
            {
                System.out.print(" ");
            }
            for(int k=0;k<3-i;k++)
            {
                System.out.print("*");
            }
            for(int k=0;k<2-i;k++)
            {
                System.out.print("*");
            }
            for(int a=0;a<i+1;a++)
            {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

// 강사님 버전

/* for(int i=0;i<5;i+=2)
 {
      System.out.print(" ");
 }

 for (int k=5; k>i;k--)
 {
      System.out.print("*");
 }
 System.out.println();
 */

