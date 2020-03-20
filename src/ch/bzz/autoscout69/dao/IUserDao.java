package ch.bzz.autoscout69.dao;


import ch.bzz.autoscout69.model.User;

public interface IUserDao {
	
	public void create(User user);
	
	public User getByEmail(String email);
	
}