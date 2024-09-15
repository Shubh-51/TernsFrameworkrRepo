package com.crm.tp.terns.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
/**
 * This class is created to get the Connection from mysql database.
 * Execute Select Query.
 * Execute Non-Select Query.
 * Close the Database connection.
 */

public class DataBaseUtility {
	
	Connection conn=null;
	
	
	public void getDatabaseConnection(String url,String username,String password){
		/**
		 * @param string
		 * @param String
		 * @param String
		 * @return null
		 * this method ton get mysql database register,connection
		 */
		try {
			Driver driverreff=new Driver();
			DriverManager.registerDriver(driverreff);
			 conn=DriverManager.getConnection(url, username,password);
		}catch(Exception e) {
			
		}
	}
	
	
	public void getDatabaseConnection() {
		/**
		 * @param null
		 * @return null
		 * this method ton get mysql database register,connection
		 */
		try {
			Driver driverreff=new Driver();
			DriverManager.registerDriver(driverreff);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger","root", "root");
		} catch (SQLException e) {
			
		}
		
	}
	public ResultSet exceuteSelectQuery(String executeQuery) {
		/**
		 * @param String
		 * @return ResultSet
		 * this method accept String type of select query and return value from database
		 */
		Statement stat=null;
		ResultSet resultset=null;
		try {
			stat=conn.createStatement();
			 resultset=stat.executeQuery(executeQuery);
		} catch (SQLException e) {
			
		}
		
	return resultset;
	}
	public void closeDatabaseConnection() {
		/**
		 * this method used to Close the database connection.
		 */
		try {
			conn.close();
		} catch (SQLException e) {
			
		}
	}

}
