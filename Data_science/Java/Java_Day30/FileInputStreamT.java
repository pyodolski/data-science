package Java_Day30;

import java.io.*;

public class FileInputStreamT {
    public static void main(String[] args) {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("b.txt")))) {
//            String str;
//            while ((str = br.readLine()) != null) {
//                System.out.println(str);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c.txt")))) {
            bw.write("감사합니다");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
