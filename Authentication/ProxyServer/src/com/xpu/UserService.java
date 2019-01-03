package com.xpu;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.xpu.bean.User;

/**
 * 此接口定义了RMI远程调用的方法getUserByName(String name, String pwd)
 * @author 黎红丽
 * @version 1.0
 */
public interface UserService extends Remote{
	/**
	 * 这个是查找用户信息的方法
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 成功返回被查找的对象，失败返回null
	 * @throws RemoteException RMI的一次异常
	 */
	public User getUserByName(String name, String pwd)throws RemoteException;
}
