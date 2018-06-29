/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 *
 * @author hailo
 */
public class DBconfig {
    public static final int dbPort = 3306;
    public static final String dbName = "imagedisplay";
    public static final String dbHost = "localhost";
    public static final String dbUserName = "root";
    public static final String dbPass = "208197";
    public static final String dbPoolTimeout ="1000";
    
    public void initComponents(){
    
    }
}
