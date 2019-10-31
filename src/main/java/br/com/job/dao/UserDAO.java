package br.com.job.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.job.model.User;

public class UserDAO {
	
	public static List<User> users = new ArrayList<User>();
	
	public void saveUser(User usuario) {
		users.add(usuario);
	}
	
}
