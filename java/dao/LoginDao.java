/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LoginBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author Vaio
 */
public class LoginDao {
    
    public String authenticateUser(LoginBean loginBean) {
        String userName = loginBean.getUsername();
        String password = loginBean.getPassword();
        String type = loginBean.getType();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = " ";
        String passwordDB = " ";

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            if (type.equalsIgnoreCase("admin")) {
                resultSet = statement.executeQuery("SELECT USERNAME,PASSWORD FROM ADMIN1");

                while (resultSet.next()) {
                    userNameDB = resultSet.getString("username");
                    passwordDB = resultSet.getString("password");
                    if (userName.equals(userNameDB) && password.equals(passwordDB)) {
                        return "SUCCESS";
                    }
                }
            } else if (type.equalsIgnoreCase("donor")) {
                resultSet = statement.executeQuery("SELECT USERNAME,PASSWORD FROM DONOR");

                while (resultSet.next()) {
                    userNameDB = resultSet.getString("username");
                    passwordDB = resultSet.getString("password");
                    if (userName.equals(userNameDB) && password.equals(passwordDB)) {
                        return "SUCCESS";
                    }
                }
            } else if (type.equalsIgnoreCase("adopt")) {
                resultSet = statement.executeQuery("SELECT USERNAME,PASSWORD FROM ADOPT2");

                while (resultSet.next()) {
                    userNameDB = resultSet.getString("username");
                    passwordDB = resultSet.getString("password");
                    if (userName.equals(userNameDB) && password.equals(passwordDB)) {
                        return "SUCCESS";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }    
}
