package ch.bzz.autoscout69.service;


import ch.bzz.autoscout69.dao.IUserDao;
import ch.bzz.autoscout69.model.User;
import ch.bzz.autoscout69.util.Session;
import ch.bzz.autoscout69.util.Util;
import ch.bzz.autoscout69.util.message.Message;
import ch.bzz.autoscout69.util.message.MessageArray;
import ch.bzz.autoscout69.util.message.MessageStyle;

import javax.inject.Inject;

public class UserService implements IUserService {

	@Inject
	private MessageArray msgArray;

	@Inject
	private IUserDao userDao;

	@Inject
	private Session session;

	@Override
	public boolean login(String email, String password) {
		if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			User userSaved = userDao.getByEmail(email);
			if (userSaved != null && Util.verifyPassword(password, userSaved.getPassword())) {
				session.setUserId(userSaved.getId());
				return true;
			}
		}
		msgArray.addMessage(new Message(MessageStyle.error, "Email/Passwort ist falsch!"));
		return false;
	}

	@Override
	public boolean register(String name, String email, String password, String valPassword) {
		if (name != null && !name.isEmpty() && email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			if(!password.equals(valPassword)) {
				msgArray.addMessage(new Message(MessageStyle.error, "Passwörter stimmen nicht Überein!"));
			}else if (userDao.getByEmail(email) == null) {
				User user = new User();
				user.setEmail(email);
				user.setName(name);
				user.setPassword(Util.encodePassword(password));
				userDao.create(user);
				return true;
			} else {
				msgArray.addMessage(new Message(MessageStyle.error, "Email wurde schon verwendet!"));
			}
		} else {
			msgArray.addMessage(new Message(MessageStyle.error, "Ungültige Eingabe!"));
		}
		return false;
	}


}
