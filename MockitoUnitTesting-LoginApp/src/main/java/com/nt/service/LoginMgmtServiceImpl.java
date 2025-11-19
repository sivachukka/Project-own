package com.nt.service;

import com.nt.dao.ILoginDAO;

public class LoginMgmtServiceImpl implements ILoginMgmtService {
	
	private ILoginDAO dao;
	public LoginMgmtServiceImpl(ILoginDAO dao) {
		this.dao=dao;
	}

	@Override
	public boolean login(String user, String password) {
	if(user.equalsIgnoreCase("")||password.equalsIgnoreCase(""))
		throw new IllegalArgumentException("Invalid Inputs");
	int count=dao.authenticate(user, password);
	if(count==0)
		return false;
	else
		return true;
	}

	@Override
	public String registerUser(String user, String role) {
		if(user.equals("")&&!role.equals("")) {
			dao.addUser(user, role);
			return "User added";
		}
		else
			return "user not added";
		
	}

}
