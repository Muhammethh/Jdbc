package day02_databasetesting;

import org.junit.Assert;
import org.junit.Test;
import utilities.JdbcLocalDBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class C01_UtilitiesTest {


    // query city names with population over 3 million from 'cities' table
    // verify given city names "Istanbul", "Ankara", "Izmir"
    //close connection

    @Test
    public void test01() throws SQLException {
        // 'cities' tablosundan nufusu 3 milyondan fazla olan sehir isimleri sorgula

        String sql = "SELECT city_name FROM cities WHERE population>3000000";
        ResultSet resultSet = JdbcLocalDBUtils.executeQuery(sql);

        // verilen sehir isimlerini doğrula "Istanbul", "Ankara", "Izmir"

        List<String> actualData = new ArrayList<>();
        while (resultSet.next()){

            String cityName = resultSet.getString("city_name");
            actualData.add(cityName);

        }
        List<String> expectedData = List.of("Istanbul", "Ankara", "Izmir");
        Assert.assertEquals(actualData,expectedData);

        //baglantiyi kapat
        JdbcLocalDBUtils.closeConnection();


    }
}