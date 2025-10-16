package com.nt.service;

import com.nt.dao.ILoginDao;

public class LoginMgmtServiceImpl implements ILoginMgmtService {
	private ILoginDao dao;
	public LoginMgmtServiceImpl(ILoginDao dao) {
		this.dao=dao;
	}

	@Override
	public boolean login(String user, String pwd) {
	if(user.equalsIgnoreCase("")||pwd.equalsIgnoreCase(""))
		throw new IllegalArgumentException("invalid inputs");
	int count=dao.authenticate(user, pwd);
	if(count==0)
		return false;
	else
		return true;
	}

	@Override
	public String registerUser(String user, String role) {
		if(user.equals("")&&!role.equals("")) {
			dao.addUser(user, role);
			return"user added";
		}
		else
		return "user not added";
	}

}
