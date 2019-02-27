package pakholko.belstu;


import org.testng.Assert;
import org.testng.annotations.*;

//оценку корректности исходного кода программы
public class Main {
    private Peredacha peredacha;
    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("@BeforeSuite");
    }
    @BeforeTest
    public void testBeforeTest() {
        System.out.println("@BeforeTest");
        peredacha = new Peredacha("Raps", 600, 1200, "KEK", "Hard");
    }
    @BeforeGroups
    public void testBeforeGroups() {
        System.out.println("@BeforeGroups");
    }
    @BeforeClass
    public void testBeforeClass() {
        System.out.println("@BeforeClass");
    }
    @BeforeMethod
    public void testBeforeMethod() {
        System.out.println("@BeforeMethod");
    }

    @AfterSuite
    public void testASuite() {
        System.out.println("@AfterSuite");
    }
    @AfterTest
    public void testATest() {
        System.out.println("@AfterTest");
    }
    @AfterGroups
    public void testAGroups() {
        System.out.println("@AfterGroups");
    }
    @AfterClass
    public void testAClass() {
        System.out.println("@AfterClass");
    }
    @AfterMethod
    public void testAMethod() {
        System.out.println("@AfterMethod");
    }

    // тест конструктора
    @Test(alwaysRun = true)
    public void testObject(){
        try{
            if(peredacha == null)
                throw new NullPointerException();
            Assert.assertEquals(peredacha.getName(), "KEK");
            Assert.assertEquals(peredacha.getOil() , "Rap");
            System.out.println("@Test");
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    //assert
    // тест- метод вполнюящий проверку
    //класс assert проверяет правильность работы метода
    @Test(enabled = true)
    public void ExTst(){
        Assert.fail();
    }
    //timeout
    @Test(timeOut = 100)
    public void waitLongTime() throws Exception {
        Thread.sleep(1001);
        System.out.println("Ignored");
    }
    //groups
    @Test(groups = {"Group"})
    public void test1Group(){
        System.out.println("method 1 test in group");
    }
    @Test(groups = {"Group"})
    public void test2Group(){
        System.out.println("method 2 test in group");
    }
    @Test(dependsOnGroups = "Group")
    public void testGroup(){
        System.out.println("Group test");
    }

}
