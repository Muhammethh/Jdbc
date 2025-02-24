import java.sql.*;

public class PreparedStatement01 {

    /*
        PreparedStatement; önceden derlenmiş tekrar tekrar kullanılabilen
        parametreli sorgular oluşturmamızı ve çalıştırmamızı sağlar.

        PreparedStatement Statement ı extend eder(statementın gelişmiş halidir.)
 */

    public static void main(String[] args) throws SQLException {

        //n02-ADIM:bağlantıyı oluşturma: db url,kullanıcı adı,password
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_dt",
                "techpro", "password");


        //n03-ADIM:Statement oluşturma:SQL ifadelerini veritabanına
        //iletir ve çalıştırır
        Statement st = connection.createStatement();

        //ÖRNEK1: bolumler tablosunda Matematik bölümünün taban_puanı'nı 475 olarak güncelleyiniz.

       /* String sql1 = "UPDATE bolumler SET taban_puani = 475 WHERE bolum ILIKE 'Matematik'";
        int updated = st.executeUpdate(sql1);
        System.out.println("updated = " + updated);*/


        //Prepared Statement kullanarak bolumler tablosunda
        // Matematik bölümünün taban_puanı'nı 499 olarak güncelleyiniz.

        //parametreli sorgu hazırlıyoruz
        String sql2 = "UPDATE bolumler SET taban_puani=? WHERE bolum ILIKE ?";
        PreparedStatement prst = connection.prepareStatement(sql2);

        prst.setInt(1, 500);
        prst.setString(2, "Matematik");
        //"UPDATE bolumler SET taban_puani= 499  WHERE bolum ILIKE Matematik'" ----->Parametrelere değer girdik
        prst.executeUpdate();


        //Prepared Statement kullanarak bolumler tablosunda
        // Edebiyat bölümünün taban_puanı'nı 450 olarak güncelleyiniz.

        prst.setInt(1, 450);
        prst.setString(2, "Edebiyat");
        //"UPDATE bolumler SET taban_puani= 450  WHERE bolum ILIKE Edebiyat'"
        int updated = prst.executeUpdate();
        System.out.println("updated = " + updated);

        //Örnek 3:Prepared Statement kullanarak bolumler tablosuna
        // Yazılım Mühendisliği(id=5006,taban_puanı=475, kampus='Merkez') bölümünü ekleyiniz.

        String sql3 = "INSERT INTO bolumler VALUES(?,?,?,?)";
        PreparedStatement prst2 = connection.prepareStatement(sql3);
        prst2.setInt(1,5006);
        prst2.setString(2,"Yazılım Müh");
        prst2.setInt(3,475);
        prst2.setString(4,"Merkez");
        prst2.executeUpdate();

        st.close();
        prst.close();
        prst2.close();
        connection.close();

    }

}
