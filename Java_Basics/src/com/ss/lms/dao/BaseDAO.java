/**
 * 
 */
package com.ss.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ppradhan
 *
 */
public abstract class BaseDAO<T> {
	
	public String driverName = "com.mysql.cj.jdbc.Driver";
	public String url = "jdbc:mysql://localhost:3306/library?useSSL=false";
	public String userName = "root";
	public String password = "root";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driverName);
		return DriverManager.getConnection(url, userName, password);
	}
	
	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		if(vals !=null) {
			int count = 1;
			for(Object o: vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.executeUpdate();
	}
	
	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		if(vals !=null) {
			int count = 1;
			for(Object o: vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		return extractData(pstmt.executeQuery());
	}
	
	public abstract List<T> extractData(ResultSet rs) throws SQLException;
}
