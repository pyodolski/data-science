package My_project.Writer;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.*;
//
//public class MyReader implements AutoCloseable{
//
//    private final BufferedReader bufferedReader;
//    public MyReader(String fileName) throws Exception{
//        bufferedReader = new BufferedReader(new FileReader(fileName));
//    }
//    public String read(String str) throws Exception {
//        return bufferedReader.readLine();
//    }
//    public List<String> getDatas() throws Exception{
////        String data;
////        var datas = new ArrayList<String>();
////     //   while ((data = bufferedReader.readLine() != null)){
////            datas.add(data.trim());
////        }
////        return datas;
////    }
////    @Override
////    public void close() throws Exception {
////        bufferedReader.close();
////    }
////}
