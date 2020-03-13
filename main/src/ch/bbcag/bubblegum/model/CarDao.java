package ch.bbcag.bubblegum.dao;

import java.util.List;

import ch.bbcag.bubblegum.dao.querryoperation.ListReadOperation;
import ch.bbcag.bubblegum.dao.querryoperation.SingleReadOperation;
import ch.bbcag.bubblegum.dao.util.AbstractDao;
import ch.bbcag.bubblegum.model.User;

public class UserDao extends AbstractDao<User> implements IUserDao {

	@Override
	public List<Car> searchCarByName(String carname) {
		return executeCustomQuarry("SELECT c FROM Car c where c.name like :name", (q) -> q.setParameter("name", "%"+ carname +"%"), new ListReadOperation<User>());
	}

	@Override
	public Class<User> getClazz() {
		return User.class;
	}

}
