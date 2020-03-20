package ch.bzz.autoscout69.service;

public interface IUserService {

	public boolean register(String name, String email, String password, String valPassword);

	public boolean login(String email, String password);
	
}
