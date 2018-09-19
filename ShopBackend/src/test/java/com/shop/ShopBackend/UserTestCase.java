package com.shop.ShopBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.shop.Config.DBConfig;
import com.shop.DAO.UserDAO;
import com.shop.Model.User;

import junit.framework.TestCase;

public class UserTestCase extends TestCase {
	AbstractApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
	UserDAO userDAO=(UserDAO) context.getBean("userDAO");
	
	/*public void testAddUser() {
		User user=new User();
		user.setUid("U102");
		user.setUname("Harish");
		user.setUemail("Haish12@gmail.com");
		user.setUlocation("Egmore");
		user.setUmobno("9043567456");
		user.setUpwrd("password@098");
		assertEquals(true,userDAO.addUser(user));
	}
	
	public void testFindUserById() {
		User user1=userDAO.findUserById("U101");
		assertNotNull(user1);
		String eid="U101";
		String aid=user1.getUid();
		assertTrue(eid.equals(aid));
	}*/
	
	public void testUpdateUser() {
		User user2= userDAO.findUserById("U101");
		user2.setUemail("Faraz@gmail.com");
		assertTrue(user2.getUid().equals("U101"));
		userDAO.updateUser(user2);
	}
	
	public void testdeleteUser() {
		User user3= userDAO.findUserById("U102");
		assertEquals(true,userDAO.deleteUser(user3.getUid()));
	}
}
