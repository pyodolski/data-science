package Java_Day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Person implements AutoCloseable {

    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void close() throws Exception {
        System.out.println("person obj close...");

    }

}
class Main {
    public static void main(String[] args) throws IOException {
        // try with resource
        // Autocloseable의 추상화 메소드 Close() 호출
        try(var person = new Person()) {
            person.setAge(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        var InputStream = System.in;
        int i;
        while ((i = InputStream.read()) != '\n') {
            System.out.print((char) i);
        }

        try(InputStreamReader isr = new InputStreamReader(System.in)) {
            while ((i = isr.read()) != '\n') {
                System.out.print((char) i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(br.readLine());
        }catch (Exception e){
            e.printStackTrace();
            // 자동적으로 close가 호출되어서 메모리 누수를 막을 수 있음
            // try 구문 사용
        }

    }
}