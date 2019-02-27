package test;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;


public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
         System.out.println("Success");
    }

@Ignore
    @Test(timeout = 10)
    public void infinity() {

        System.out.println("Success");
        while (true);
    }
}