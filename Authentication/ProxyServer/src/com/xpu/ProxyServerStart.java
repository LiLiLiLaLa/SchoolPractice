package com.xpu;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.Naming; 
import java.rmi.RemoteException;

import com.xpu.bean.User;
/**
 * 这个类是我的代理服务器
 * 主要功能是从客户端接收数据，通过RMI调用数据库服务器的方法，将调用结果通过Socket返回给客户端
 * @author 黎红丽
 * @version 1.0
 */
public class ProxyServerStart {
	
	/**
	 * 数据库服务器RMI的IP地址
	 */
	public static final String DBSERVER_ADDRESS = "127.0.0.1";
	
	/**
	 * 数据库服务器RMI端口号
	 */
	public static final String DBSERVER_HOST = "6600";
	
	/**
	 * 客户端IP地址
	 */
	public static final String CLIENT_ADDRESS = "127.0.0.1";
	/**
	 * 客户端通信端口号
	 */
	public static final String CLIENT_HOST = "12346";
	
	/**
	 * 开启代理服务器主的方法
	 */
	public static void main(String[] args){
		try{
			startServer();
		}catch(SocketException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * 开启代理服务器，从客户端接收数据，向客户端发送返回数据
	 * @throws SocketException Socket连接异常
	 */
	private static void startServer() throws SocketException {
		System.out.println("ProxyServer Start(代理服务器启动)...");
		String ret = "false";
		while(true) {
			ret = "false";
			try {
				// 创建接收端的Socket对象
				DatagramSocket recv  = new DatagramSocket(12345);
				byte[] recv_bys = new byte[1024];
				DatagramPacket dp = new DatagramPacket(recv_bys, recv_bys.length);
				
				// 接收数据
				recv.receive(dp);
				
				// 解析数据
				//TODO 看看是否需要IP解析
				//String ip = dp.getAddress().getHostAddress();
				String s = new String(dp.getData(), 0, dp.getLength());
				
				//解析用户名和密码
				String[] info = s.split("_NAME_PWD_");
				
				//调用本地调用RMI的方法
				if(findData(info[0],info[1]) != null) {
					ret = "true";
				}
				
				//关闭socket资源
				recv.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			//创建发送端socked对象
			DatagramSocket send = new DatagramSocket();
			// 创建数据并打包
			byte[] ret_bys = ret.getBytes(); 
			try {
				//准备数据包
				DatagramPacket send_dp = new DatagramPacket(ret_bys, ret_bys.length,
						InetAddress.getByName(CLIENT_ADDRESS),Integer.parseInt(CLIENT_HOST));
				//发送数据包
				send.send(send_dp);
				//关闭socket资源
				send.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param name 登录的用户名
	 * @param pwd 登录的密码
	 * @return 如果成功返回登录对象，失败返回null
	 * @throws RemoteException RMI失败可能引发的异常
	 */
	public static User findData(String name, String pwd) throws RemoteException {
		try {
			// 调用远程对象，注意RMI路径与接口必须与server配置一致
			UserService userService = (UserService) Naming.lookup("rmi://"+DBSERVER_ADDRESS+":"+DBSERVER_HOST+"/userService");
			User user = userService.getUserByName(name, pwd);
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
