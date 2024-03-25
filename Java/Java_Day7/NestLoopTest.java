package ch07;

public class NestLoopTest {
    public static void main(String[] args) {

        // case 1 -> 중첩루프를 사용할 때, case 1이 속도가 빠름
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i=0;i<100;i++)
        {
            for(int k=0;k<1000;k++)
            {
                for(int j=0;j<10000;j++){ // 루프 수가 큰 것을 안쪽에 배치하는 것이 속도가 빠름
                    sum += i*k*j*555;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long diff = (endTime - startTime);
        System.out.println(diff);

        // case 2
         startTime = System.currentTimeMillis();
         sum = 0;
        for (int i=0;i<10000;i++)
        {
            for(int k=0;k<1000;k++)
            {
                for(int j=0;j<100;j++){
                    sum += i*k*j*555;
                }
            }
        }

         endTime = System.currentTimeMillis();
         diff = (endTime - startTime);
        System.out.println(diff);
    }
}
