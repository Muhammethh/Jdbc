package day01_databasetesting;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class C03_CityTest {

        /*
        connect to the database
        get city names from the 'cities' table
        verify that there are at least 10 city names in the city_name column
        close the connection
        */


    @Test
    public void test01() throws SQLException {

        //veritabanına bağlan
        //'cities' tablosundan sehir isimlerini al
        //city_name sütununda en az 10 tane sehir ismi olduğunu doğrulayın
        //bağlantıyı kapat

        String url = "jdbc:postgresql://localhost:5432/myDatabase";
        String user = "tester";
        String password = "tester";
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT city_name FROM cities");

        int counter = 0;
        while (resultSet.next()) {
            counter++;
        }
        Assert.assertTrue(counter > 9);

        statement.close();
        connection.close();

    }


    //--------2:YOL
    @Test
    public void test02() throws SQLException {
        //veritabanına bağlan
        //'cities' tablosundan sehir isimlerini al
        //city_name sütununda en az 10 tane sehir ismi olduğunu doğrulayın
        //bağlantıyı kapat

        String url = "jdbc:postgresql://localhost:5432/myDatabase";
        String user = "tester";
        String password = "tester";
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT COUNT(city_name) FROM cities");
        resultSet.next();

        int actualData = resultSet.getInt("count");
        Assert.assertTrue(actualData > 9);


        connection.close();
        statement.close();

    }
}