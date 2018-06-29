/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hailo
 */
public class ImageDAO {

    public boolean addIMG(String link) {
        try {
            Connection con = new DBConnection().getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO `image` (`link`) VALUES (?);";
            PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
            pre.setString(1, link);
            if (pre.executeUpdate() == 1) {
                con.commit();
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public String getIMG(int id) {
        String link = "";
        try {
            Connection con = new DBConnection().getConnection();
            con.setAutoCommit(false);
            String sql = "SELECT * FROM image WHERE id=?;";
            PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                link = rs.getString("link");
            }
            return link;
        } catch (Exception e) {
        }
        return link;
    }

    public int getNumber() {
        int number = 0;
        try {
            Connection con = new DBConnection().getConnection();
            con.setAutoCommit(false);
            String sql = "SELECT count(*) FROM image ;";
            PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                 number = rs.getInt(1);
            }
            return number;
        } catch (Exception e) {
        }
        return number;
    }
}
