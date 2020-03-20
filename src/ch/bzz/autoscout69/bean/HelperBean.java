package ch.bzz.autoscout69.bean;

import ch.bzz.autoscout69.util.Session;
import ch.bzz.autoscout69.util.message.MessageArray;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HelperBean {

    @Inject
    private MessageArray messageArray;

    @Inject
    private Session session;

    public String getMessages() {
        String messages = messageArray.toString();
        messageArray.clear();
        return messages;
    }

    public boolean isLogedIn() {
        return session.getUserId() != 0;
    }

    public String logout() {
        session.invalidateSession();
        return "index";
    }

}

