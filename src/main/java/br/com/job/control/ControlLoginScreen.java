package br.com.job.control;

import java.util.List;

import br.com.job.dao.UserDAO;
import br.com.job.model.User;

public class ControlLoginScreen {

	public boolean userAuthentication(String user, String password) {

		UserDAO dao = new UserDAO();
		List<User> users = dao.users;

		for (User usuario : users) {
			if (usuario.getUser().equals(user) && usuario.getPassword().equals(password)) {
				return true;
			}
		}
		return false;

	}
}
