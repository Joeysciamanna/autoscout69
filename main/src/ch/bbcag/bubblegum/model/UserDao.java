package ch.bbcag.bubblegum.dao;

import java.util.List;

import ch.bbcag.bubblegum.dao.querryoperation.ListReadOperation;
import ch.bbcag.bubblegum.dao.querryoperation.SingleReadOperation;
import ch.bbcag.bubblegum.dao.util.AbstractDao;
import ch.bbcag.bubblegum.model.User;

public class UserDao extends AbstractDao<User> implements IUserDao {

	@Override
	public User getUserByEmail(String email) {
		return executeCustomQuarry("SELECT u FROM User u where u.email = :email", (q) -> q.setParameter("email", email) , new SingleReadOperation<User>());
	}

	@Override
	public List<User> searchUserByName(String username) {
		return executeCustomQuarry("SELECT u FROM User u where u.username like :username", (q) -> q.setParameter("username", "%"+ username +"%"), new ListReadOperation<User>());
	}

	@Override
	public Class<User> getClazz() {
		return User.class;
	}

}
