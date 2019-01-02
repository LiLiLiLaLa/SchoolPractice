package com.xpu;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 这个类是客户端，提供用户登录和退出的功能
 * @author 黎红丽
 * @version 1.0
 */
public class ClientStart {
	/**
	 * 代理服务器IP地址
	 */
	public static final String PROXYSERVER_ADDRESS = "127.0.0.1";
	
	/**
	 * 代理服务器端口号
	 */
	public static final String PROXYSERVER_HOST = "12345";
	
	/**
	 * 本地接收数据包的端口号
	 */
	public static final String LOCAL_HOST = "12346";
	public static void main(String[] args) {
		startUp();
	}
	
	
	/**
	 * 登录的方法
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 返回是否登录成功(用户名必须在数据库中而且和密码匹配)
	 */
	public static boolean login(String name, String pwd) {
		if(name == null || pwd == null || "".equals(name) || "".equals(pwd))
			return false;
		//发送数据包
		//创建发送端socked对象
		try {
			DatagramSocket ds = new DatagramSocket();
			// 创建数据并打包
			byte[] bys = (name+"_NAME_PWD_"+pwd).getBytes();
			DatagramPacket dp = new DatagramPac ket(bys, bys.length,InetAddress.getByName(PROXYSERVER_ADDRESS),Integer.parseInt(PROXYSERVER_HOST));
			
			ds.send(dp);
			ds.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//接收数据包
		// 创建接收端的Socket对象
		DatagramSocket ds = null;
		try {
			//设置接受数据包的端口
			ds = new DatagramSocket(Integer.parseInt(LOCAL_HOST));
			
			// 创建一个包裹
			byte[] bys = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bys, bys.length);
			
			// 接收数据包
			ds.receive(dp);
			
			// 解析数据包
			String ip = dp.getAddress().getHostAddress();
			String s = new String(dp.getData(), 0, dp.getLength());
			System.out.println("代理服务器IP:"+ip+"  本地通信端口: "+LOCAL_HOST);
			
			if("true".equals(s)){
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ds.close();
		}
		return false;
	}
	
	/**
	 * 命令行菜单
	 */
	public static void startUp() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println();
			System.out.println("-------用户登录系统-----------");
			System.out.println("-------1、开始登录-----------");
			System.out.println("-------2、退出系统-----------");
			System.out.println("请输入选择>>");
			String input = sc.next();
			
			if("1".equals(input)) {
				System.out.println("请输入用户名");
				String name = sc.next();
				System.out.println("请输入密码");
				String pwd = sc.next();
				if(login(name, pwd)){
					System.out.println("登录成功");
				}else {
					System.out.println("用户名或密码错误");
				}
			}else if("2".equals(input)) {
				sc.close();
				System.exit(0);
			}else {
				System.out.println("输入错误");
			}
		}
	}
}