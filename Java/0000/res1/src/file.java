import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class file {
    public static void main(String[] args) {
        try {
            String name = "D:/d.txt";
            FileWriter fileWriter = new FileWriter(name,false);
            fileWriter.write("hello  hello men ");
            fileWriter.append("\r\n");
            fileWriter.write("hello  hello men ");
            fileWriter.flush();
            FileReader fileReader=new FileReader(name);
//            int symbl;
//            while ((symbl=fileReader.read())!=-1)
//            {
//                System.out.print((char)symbl);
//            }
            Scanner scan=new Scanner(fileReader);
            System.out.println(scan.nextLine());
            System.out.println(new Date().getHours());
        }
        catch (Exception e)
        {

        }
    }
}
