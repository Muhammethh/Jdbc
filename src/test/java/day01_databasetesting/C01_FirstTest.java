package day01_databasetesting;

import java.util.Scanner;

public class C01_FirstTest {

       /*
    Software Testing : Expected data ile Actual data nin karsilastirmasindan ibarettir.
    Expected Data    : Gereksinimlere göre beklenen data
    Actual Data      : Uygulamadan gelen asıl data
     */

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //classları görmek için yazdık

        String expectedData = "Selenium";
        String actualData = "Selenium";

        if (expectedData.equals(actualData)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test failed");
        }


    }

}
