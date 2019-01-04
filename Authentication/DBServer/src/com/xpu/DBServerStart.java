package com.xpu;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 此类用于启动数据库服务器，端口注册为6600
 * @author 黎红丽
 * @version 1.0
 */
public class DBServerStart {
	/**
	 * 数据库服务器RMI的IP地址
	 */
	public static final String DBSERVER_ADDRESS = "127.0.0.1";
	
	/**
	 * 数据库服务器RMI端口号
	 */
	public static final String DBSERVER_HOST = "6600";
	public static void main(String[] args) {
		try {  
            UserService userService = new UserServiceImpl();  
            //注冊通讯端口  
            LocateRegistry.createRegistry(Integer.parseInt(DBSERVER_HOST));  
            //注冊通讯路径  
            Naming.rebind("rmi://"+DBSERVER_ADDRESS+":"+DBSERVER_HOST+"/userService", userService);  
            System.out.println("DBService Start(数据库服务器启动)...");  
        }  catch (RemoteException e) {
            System.out.println("创建远程对象发生异常！");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("发生URL畸形异常！");
            e.printStackTrace();
        } 
	}
}
