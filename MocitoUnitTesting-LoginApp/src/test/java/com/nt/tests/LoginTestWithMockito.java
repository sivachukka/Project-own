package com.nt.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nt.dao.ILoginDao;
import com.nt.service.ILoginMgmtService;
import com.nt.service.LoginMgmtServiceImpl;

public class LoginTestWithMockito {

	private static ILoginMgmtService loginservice;
	private static ILoginDao loginDao;
	
	@Test
	public void setUp() {
		loginDao=Mockito.mock(ILoginDao.class);
		System.out.println("Mock Object class name::"+loginDao.getClass());
		loginservice=new LoginMgmtServiceImpl(loginDao);
	}
	@AfterAll
	public static void clearDown() {
		loginDao=null;
		loginservice=null;
	}
	@Test
	public void testLoginWithValidCredentials() {
		Mockito.when(loginDao.authenticate("raja", "rani")).thenReturn(1);
		assertTrue(loginservice.login("raja", "rani"));
		
		}
	@Test
	public void testLoginWithInValidCredentials() {
		Mockito.when(loginDao.authenticate("raja", "rani1")).thenReturn(0);
		assertFalse(loginservice.login("raja", "rani1"));
		}
	public void testRegisterUserWithSpy() {
		ILoginDao loginDaoSpy=Mockito.spy(ILoginDao.class);
		ILoginMgmtService loginservice=new LoginMgmtServiceImpl(loginDaoSpy);
		
		loginservice.registerUser("raja","admin");
		loginservice.registerUser("suresh","customer");
		loginservice.registerUser("jani","");
		
		Mockito.verify(loginDaoSpy,Mockito.times(1)).addUser("raja","admin");
		Mockito.verify(loginDaoSpy,Mockito.times(1)).addUser("suresh","customer");
		Mockito.verify(loginDaoSpy,Mockito.times(0)).addUser("jani","");
		
		
	}
}
