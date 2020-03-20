package ch.bzz.autoscout69.dao;


import ch.bzz.autoscout69.dao.util.AbstractDao;
import ch.bzz.autoscout69.dao.util.querryoperation.SingleReadOperation;
import ch.bzz.autoscout69.model.User;

public class UserDao extends AbstractDao<User> implements IUserDao {

	@Override
	public User getByEmail(String email) {
		return executeCustomQuarry("SELECT u FROM User u where u.email = :email", (q) -> q.setParameter("email", email) , new SingleReadOperation<User>());
	}


	@Override
	public Class<User> getClazz() {
		return User.class;
	}

}
