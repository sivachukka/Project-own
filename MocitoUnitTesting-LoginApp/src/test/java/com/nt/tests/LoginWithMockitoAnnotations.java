package com.nt.tests;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nt.dao.ILoginDao;
import com.nt.service.LoginMgmtServiceImpl;

public class LoginWithMockitoAnnotations {
	@InjectMocks
	private static LoginMgmtServiceImpl loginservice;
	
	public void LoginTestWithMockitoAnnotations() {
		MockitoAnnotations.openMocks(this);
	}
	public void testLoginWithValidCredentials() {
		Mockito.when(ILoginDao.authenticate("raja","rani"));
	}

}
