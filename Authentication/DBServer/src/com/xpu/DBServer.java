package com.xpu;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.xpu.bean.User;
import com.xpu.util.JDBCUtils;

/**
 * 登录查询数据库Dao层操作，注意DBServer的序列化
 * @author 黎红丽
 * @version 1.0
 */
public class DBServer extends UnicastRemoteObject{
	private static final long serialVersionUID = 3L;
	protected DBServer() throws RemoteException {
		super();
	}
	
	//获取执行对象
	private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	/**
	 * @param name 用户名
	 * @return 根据用户名查找用户名信息，找不到则返回null 
	 */
	public static User FindUser(String name) {
		//获取连接对象
		Connection conn = JDBCUtils.getConnection();
		
		try{
            //拼写条件查询的SQL语句
            String sql = "SELECT * FROM user WHERE name='"+name+"'";
            User user = qr.query(conn, sql, new BeanHandler<>(User.class));

            //关闭连接对象
            conn.close();
            if(user != null){
                return  user;
            }

        }catch(SQLException ex){
            System.out.println(ex);
        }
		return null;
	}
}
