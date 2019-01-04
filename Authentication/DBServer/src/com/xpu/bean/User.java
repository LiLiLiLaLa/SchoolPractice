package com.xpu.bean;

import java.io.Serializable;

/**
 * 用户信息的JavaBean，注意对序列化的支持
 * @author 黎红丽
 * @version 1.0
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 2500949180923337010L;
	private String name;
	private String pwd;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + "]";
	}
	public User() {
		super();
	}
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}
}
