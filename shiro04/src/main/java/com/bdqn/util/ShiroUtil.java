package com.bdqn.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroUtil {

	/**
	 * 获取当前主体，进行登录
	 * 
	 * @param path
	 * @param username
	 * @param password
	 * @return
	 */
	public static Subject login(String path, String username, String password) {
		// 1.读取配置文件，初始化工厂对象
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(path);
		// 2.获取SecurityManager实例
		SecurityManager manager = factory.getInstance();
		// 3.将SecurityManager绑定到工具类
		SecurityUtils.setSecurityManager(manager);
		// 4.通过SecurityUtils得到当前登录的用户
		Subject currentUser = SecurityUtils.getSubject();
		// 5.窗口登录令牌
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			// 6.登录并传入令牌
			currentUser.login(token);
			System.out.println("身份信息验证成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("身份信息验证失败！");
		}
		return currentUser;
	}

}
