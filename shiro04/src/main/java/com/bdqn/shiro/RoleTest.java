package com.bdqn.shiro;

import java.util.Arrays;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.bdqn.util.ShiroUtil;

public class RoleTest {

	public static void main(String[] args) {
		//1.获取当前用户信息
		Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "admin", "123456");
		//2.判断当前用户拥有的角色
		System.out.println(currentUser.hasRole("role1") ? "有role1这个角色" : "没有role1这个角色");
		boolean [] results = currentUser.hasRoles(Arrays.asList("role1","role2","role3"));
		System.out.println(results[0]?"有role1这个角色":"没有role1这个角色");
		System.out.println(results[1]?"有role2这个角色":"没有role2这个角色");
		System.out.println(results[2]?"有role3这个角色":"没有role3这个角色");

		boolean flag = currentUser.hasAllRoles(Arrays.asList("role1","role2","role3"));
		System.out.println("上面的角色是否全有："+flag);
		
		//当前验证的状态
		//System.out.println(currentUser.isAuthenticated());
		
		//如果身份验证通过
		//if(currentUser.isAuthenticated()) {
			//验证权限
		//}
		
		//退出
		currentUser.logout();
		
		//当前验证的状态
		//System.out.println(currentUser.isAuthenticated());
	}
	
	@Test
	public void testCheckRole() {
		//Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "admin", "123456");
		Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "test", "123");
		currentUser.checkRole("role2");
		currentUser.checkRoles(Arrays.asList("role1","role2"));
		currentUser.checkRoles("role1","role2","role3");
		currentUser.logout();
	}

}
