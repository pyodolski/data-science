package Java_Day30;

import java.io.*;
import java.util.*;

public class Kavin {
    private int RAM;
    private int CPU;

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getCPU() {
        return CPU;
    }
    public void setCPU(int CPU) {
        this.CPU = CPU;
    }

    public void read() {
        try(BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream("sys.ini")))) {
            var str = br.readLine();
            System.out.println(str);
         //   GetInfo(br);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void write(String text) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("sys.ini")))) {
            bw.write(text);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
//    public void GetInfo(BufferedReader br) throws Exception {
//        String data;
//        var datas = new ArrayList<String>();
// //       while((data = br.readLine() != null)) ;
//        datas.add(data.trim());
//        }
//
//
//    }
//
//    @Override
//    public String toString() {
//        return "Wrapping{" +
//                "RAM=" + RAM +
//                ", CPU=" + CPU +
//                '}';
//    }
}
class AppUI {
    public static void main(String[] args) {
        Kavin kavin = new Kavin();
        kavin.write("CPU=4core, RAM=10m");
        kavin.read();
    }

}
