package com.xpu.util;

import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
/**
 * 
 * JDBC工具类，用来获取JDBC数据资源对象和链接对象
 * @author 黎红丽
 * @version 1.0
 */
public class JDBCUtils{

	private static BasicDataSource datasource = new BasicDataSource();
	
	/**
	 * 数据库链接信息
	 */
	static{
		
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/userdata");
		datasource.setUsername("root");
		datasource.setPassword("1234");
		datasource.setMaxActive(10);
		datasource.setMaxIdle(5);
		datasource.setMinIdle(2);
		datasource.setInitialSize(10);
	}
	
	/**
	 * 返回数据资源
	 * @return DataSource数据资源对象
	 */
	public static DataSource getDataSource(){
		return datasource;
	}

	/**
	 * 返回连接对象
	 * @return Connection数据连接对象
	 */
	public static Connection getConnection(){
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			throw new  RuntimeException("数据库连接失败");
		}

	}
}