package com.xpu;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.xpu.bean.User;

/**
 * 
 * 此类是UserService接口的实现类，定义了具体的getUserByName(String name, String pwd)
 * 同样此类作为RMI远程调用方法的实现类，需要实现序列化
 * @author 黎红丽
 * @version 1.0
 */
public class UserServiceImpl extends UnicastRemoteObject  implements UserService {

	private static final long serialVersionUID = 1L;

	protected UserServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public User getUserByName(String name, String pwd) throws RemoteException {
		
		System.out.println("DBServer收到登录请求 name："+name+",pwd："+pwd);
		User user = DBServer.FindUser(name);
		//返回null表示未找到
		if(user == null) {
			return null;
		}
		
		//如果找到，而且密码匹配的话就返回这个对象
		if(user.getPwd().equals(pwd)) {
			return user;
		}else {
			return null;
		}
	}

}
