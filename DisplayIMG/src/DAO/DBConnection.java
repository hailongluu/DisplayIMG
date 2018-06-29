/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import java.util.logging.Logger;

/**
 *
 * @author hailo
 */
public class DBConnection {
     private MysqlDataSource dataSource = null;
    private static Logger LOG = LoggerFactory.getLogger("DatabaseConnection");

    public DBConnection() {
        dataSource = createDataSource();
    }
    public Connection getConnection(){
        Connection con = null;
        try{
            con = (Connection) dataSource.getConnection();
            LOG.info("Getted Connection");
        }
        catch(Exception e){
            LOG.error("{}",e);
        }
        return con;
    }
    private MysqlDataSource createDataSource(){
        MysqlDataSource source = null;
        try{
            source = new MysqlDataSource();
            String url = "jdbc:mysql://" + DBconfig.dbHost + ":" + DBconfig.dbPort + "/" + DBconfig.dbName+"?autoReconnect=true&useSSL=false";
            source.setURL(url);
            source.setPort(DBconfig.dbPort);
            source.setUser(DBconfig.dbUserName);
            source.setPassword(DBconfig.dbPass);
            source.setDatabaseName(DBconfig.dbName);
            LOG.info("Created MySQLDataSource");
        }
        catch(Exception e){
            LOG.error("{}",e);
        }
        return source;
    }
    
}
