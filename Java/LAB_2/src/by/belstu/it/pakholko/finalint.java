package by.belstu.it.pakholko;

/*
import java.io.UnsupportedEncodingException;
import java.math.*;
import java.util.Random;
import  static java.lang.Math.*;
*/

public class finalint
{
    final int integerconst = 10;
    public final  int pfint = 100;
    public  static final int psfint = 1000;//константы класса
    //TODO разница

    public static void main(String[] args) {

        System.out.println(Math.PI);
        System.out.println(Math.E);

        double p = Math.round(Math.PI);
        double e = Math.round(Math.E);
        double min = Math.min(p,e);
        System.out.println(min);
        double rdm = Math.random();
        System.out.println(rdm);

        Integer i = new Integer(100);
        Integer ii = new Integer(10);
        boolean bool = true;
        Boolean bol = new Boolean(bool);
        Character charac = new Character('a');
        short sh = 22;
        Short shor = new Short(sh);
        long lg = 1111;
        Long log = new Long(lg);
        double db = 2.3;
        Double doub = new Double(db);
        Double dou = doub + lg;
        Integer in = i << ii;
        System.out.println(in);

        System.out.println(Long.MIN_VALUE + "  " + Long.MAX_VALUE);
        System.out.println(Double.MIN_VALUE + "  " + Double.MAX_VALUE);
        Integer i1 = 5;//avtoupakovka
        int i2 = 1;
        i2 = new Integer(5);//raspakovka
        Byte b = 13;
        byte b1 = 0;
        b1 = new Byte(b);
        //--------------------------------------------------------------

        int a = Integer.parseInt("5");
        String hex = Integer.toHexString(11);
        System.out.println(hex);
        System.out.println(Integer.compare(10, 11));
        System.out.println(Integer.toString(15, 16));
        System.out.println("Количество бит: " + Integer.bitCount(127));
        int c = 11;
        System.out.println("В двоичном формате = " + Integer.toBinaryString(c));
        System.out.println(Double.isNaN(Math.sqrt(-36)));

        //преобразование числа с пом контруктора
        try{
            Integer intt = new Integer("333");
            System.out.println(intt);
        }
        catch (NumberFormatException ex){
            System.err.println("Строка задана не верно");
        }

        //С использованием метода valueOf класса Integer
        try  {
            String s34 = "2345";
            Integer int1 = Integer.valueOf(s34);
            System.out.println("При помощи valueOf " + int1);
        }
        catch (NumberFormatException ex){
            System.err.println("Строка задана не верно");
        }

        //С использованием метода parse
        int i12 = 1;
        String str = "123";
        try{
            i12 = Integer.parseInt(str);
            System.out.println("При помощи parse " + str);
        }
        catch (NumberFormatException ex){
            System.err.println("Строка задана не верно");
        }

        String str1 = "Hello";
        byte[] Array = str1.getBytes();
        System.out.println("Строку в массив байт : " + Array);
        String str2 = new String(Array);
        System.out.println("байты в строку : " + str2);

        String str3 = "Alyona";
        //parseBoolean
        boolean b11 = Boolean.parseBoolean(str3);
        //valueOf
        boolean b2 = Boolean.valueOf(str3);
        System.out.println( b11 && b2 );

        //сравнение строк
        String s1 = "123456";
        String s2 = "12345";
        String s3 = "23456";

        System.out.println("Сравнение с помощью == " + s1 == s2);//сравнивает ссылки на объекты
        System.out.println("equals " + s1.equals(s3));//сравнивает значения, true  если аргумент не равен null и является (String), который представляет ту же последовательность символов как и этот объект.
        System.out.println("CompareTo " + s2.compareTo(s3));//возвр. 0 если аргумент является строкой лексически равной данной строке; значение меньше 0, если аргумент является строкой лексически большей

        String s4 = "lal-ala";
        String ss= s4.replace('a', 'e');
        String[] sss = s4.split("-");
        System.out.println(s4.contains("al"));
        System.out.println(s4.length());
        System.out.println(s4.hashCode());
        System.out.println(s4.indexOf("a"));

        //многомерных массивов не сущ, но можн объявл. массив массивов
        //TODO Можно ли определить массив нулевой длины?Что случится, если индекс массива превысит его длину?

       char [][] c1 = null;
       char[] c2[] = null;
       char c3 [][];
       c1 = new char [3][];

       c1[0] = new char [1];
       c1[1] = new char [2];
       c1[2] = new char [3];

        c1[0][0] = 'a';
        c1[1][0] = 'b';
        c1[1][1] = 'c';
        c1[2][0] = 'd';
        c1[2][1] = 'e';
        c1[2][2] = 'f';

        System.out.println("Длина 1: " +c1[0].length);
        System.out.println("Длина 2: " +c1[1].length);
        System.out.println("Длина 3: " +c1[2].length);
        System.out.println("Длина " + c1.length);

        for(char mass[] : c1){
            System.out.println(mass);
        }

        boolean comRez = c1 == c2;
        c1= c2;
        System.out.println("ComRez " + comRez);

    }
}
