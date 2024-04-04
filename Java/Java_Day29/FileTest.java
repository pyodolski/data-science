package Java_Day29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class FileTest {
    public void readFile(String fileName) throws FileNotFoundException { // 호출자의 예외처리 의무화
        var br = new BufferedReader(new FileReader(fileName));
    }

    public static void main(String[] args) {
        var test = new FileTest();
        try {
            test.readFile("k");
        }catch (Exception e){
            e.fillInStackTrace();
        }

    }
}
