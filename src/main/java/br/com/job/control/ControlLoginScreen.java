package br.com.job.control;

import java.util.List;

import br.com.job.dao.UserDAO;
import br.com.job.model.User;

public class ControlLoginScreen {

	private User loggedUser;

	public boolean userAuthentication(String user, String password) {

		UserDAO dao = new UserDAO();
		List<User> users = dao.getUsers();

		for (User u : users) {
			if (u.getUsername().equals(user) && u.getPassword().equals(password)) {
				this.loggedUser = u;
				return true;
			}
		}
		return false;

	}

	public User getLoggedUser(){
		return loggedUser;
	}

}
