package ch.bbcag.bubblegum.dao;

import java.util.List;

import ch.bbcag.bubblegum.model.User;

public interface IUserDao {
	
	public void create(User user);
	
	public List<Car> searchCarByName(String carname)
}