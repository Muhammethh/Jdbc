package day01_databasetesting;

import org.junit.Assert;
import org.junit.Test;

public class C02_JunitFirstTest {

    // Assert.assertEquals(expectedData,actualData); parantez icinde belirtilen iki datanin esit olup olmadigini kontrol eder
    //esitse test gecer deegilse kalir
    @Test
    public void test1() {
        String expectedData = "selenium";
        String actualData = "elenium";
        Assert.assertEquals(expectedData, actualData);
    }

    // Assert.assertTrue(13<5); parantez icinde belirtilen kosulun true olup olmadigini kontrol eder
    //true ise test gecer false ise kalir
    @Test
    public void test2() {
        System.out.println("bu text consolda görülür");
        Assert.assertTrue("selenium".contains("e"));
        System.out.println("bu text consolda görülür");

        Assert.assertTrue(false);//fail durumunda kod akisinin durduruldugunu gözlemlemek icin bilincli fail alidk
        System.out.println("bu text consolda GORULMEZ");


        Assert.assertTrue(13 < 5);
    }


    // Assert.assertFalse(13<5); parantez icinde belirtilen kosulun FALSE olup olmadigini kontrol eder
    //false ise test gecer true ise kalir
    @Test
    public void test3() {
        Assert.assertFalse("selenium".contains("A"));//PASS
        Assert.assertFalse("selenium".contains("e"));//FAIL
    }

    // Assert.assertNotEquals(unexpectedData,actualData); parantez icinde belirtilen iki datanin esit olmadigini kontrol eder
    //esitse test kalir deegilse gecer
    @Test
    public void test4() {
        Assert.assertNotEquals("selenium", "java");
    }


}