package com.bdqn.shiro;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.bdqn.util.ShiroUtil;

public class PermissionTest {

	@Test
	public void test() {
		Subject currentUser = ShiroUtil.login("classpath:shiro_permission.ini", "admin", "123456");
		//System.out.println( currentUser.isPermitted("user:add") ? "有user:add这个权限" : "没有user:add这个权限");
		//System.out.println( currentUser.isPermitted("user:select") ? "有user:select这个权限" : "没有user:select这个权限");
		boolean [] results = currentUser.isPermitted("user:select","user:update","user:delete");
		System.out.println(results[0]?"有user:select这个权限":"没有user:select这个权限");
		System.out.println(results[1]?"有user:update这个权限":"没有user:update这个权限");
		System.out.println(results[2]?"有user:delete这个权限":"没有user:delete这个权限");
		//
		//if(currentUser.isPermitted(name)) {
			//进行增删改查
		//}
		// 退出
		currentUser.logout();

	}
}
