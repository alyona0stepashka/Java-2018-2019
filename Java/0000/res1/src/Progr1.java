import java.util.Scanner;

public class Progr1 {
    public static void main(String[] args) {
//        double [][] m=new double[3][];
//        m[0]=new double[3];

        try
        {
            throw new Exception("d");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        double[][] m = {{2, 3}, {4, 5, 6}};
        for (double[] i : m) {
            for (double j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        B1 obj=new B1();
        obj.metod();
        B1  ggg=new B1(){
          private int aa=45;
          public void aak()
          {}

        };

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);
        infClass a = new A();
        Progr1 name=new Progr1();
        name.in(1,2,3,4,5);
    }
    public void vvod(Integer a)
    {

    }


    public void in(Integer ... args)
    {
        for(Integer i :args)
        {
            System.out.println(i);
        }
    }
}
class B1 extends B
{
    public int a=5;
    public void metod()
    {

        System.out.println(this.a);
        System.out.println(super.a);
    }
}

class B
{
    public int a=6;
    public int b;
    public void metod()
    {
        System.out.println("s");
    }
}
