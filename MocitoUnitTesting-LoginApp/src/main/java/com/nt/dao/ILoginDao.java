package com.nt.dao;

public interface ILoginDao {

	public int authenticate(String username,String password);
	public String addUser(String username,String role);
}
