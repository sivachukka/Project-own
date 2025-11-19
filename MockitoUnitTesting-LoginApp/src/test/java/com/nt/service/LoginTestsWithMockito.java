package com.nt.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nt.dao.ILoginDAO;

public class LoginTestsWithMockito {

	private static ILoginMgmtService loginService;
	private static ILoginDAO loginDAO;
	@BeforeAll
	public static void setUp() {
		loginDAO=Mockito.mock(ILoginDAO.class);
		System.out.println("Mock object class name::"+loginDAO.getClass());
		loginService=new LoginMgmtServiceImpl(loginDAO);
	}
	@AfterAll
	public static void clearDown() {
		loginDAO=null;
		loginService=null;
	}@Test
	public void testLoginWithValidCredenials() {
		Mockito.when(loginDAO.authenticate("raja", "rani")).thenReturn(1);
		assertTrue(loginService.login("raja", "rani"));
	}@Test
	public void testLoginWithNoCredenials() {
		
		assertThrows(IllegalArgumentException.class,()->loginService.login("",""));
	}
	public void testRegisterUserWithSpy() {
		ILoginDAO loginDAOSpy=new LoginMgmtServiceImpl(loginDAOSpy);
	}
}
