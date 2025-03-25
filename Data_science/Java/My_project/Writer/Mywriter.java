package My_project.Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Mywriter implements AutoCloseable{

    private final BufferedWriter bufferedWriter;
    public Mywriter(String fileName) throws Exception{
        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
    }
    public void write(String str) throws Exception {
        bufferedWriter.write(str);
        bufferedWriter.newLine();
    }
    @Override
    public void close() throws Exception {
        bufferedWriter.close();
    }
}
