
package dao;

import bean.DonationBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class DonationDao {
    
    private static final String DB_URL = "jdbc:derby://localhost:1527/orphanage";
    private static final String DB_USER = "app";
    private static final String DB_PASSWORD = "app";
    
    public static void Donation (DonationBean donationBean) {
    
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO DONATION (item, quantity) VALUES (?,?)")) {

            stmt.setString(1, donationBean.getItem());
            stmt.setInt(2, donationBean.getQuantity());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<DonationBean> getDonation(){
        
        List <DonationBean> donate = new ArrayList<>();
  
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM donor");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DonationBean dBean = new DonationBean();
                
                dBean.setId(rs.getInt("id"));
                dBean.setItem(rs.getString("item"));
                dBean.setQuantity(rs.getInt("quantity"));

                donate.add(dBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donate;
    }
}
