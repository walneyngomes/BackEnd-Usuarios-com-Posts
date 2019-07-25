package Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entidades.User;
import Repository.UserRepository;

@Service
public class UserService {
	private static UserService instance = null;
	@Autowired
	UserRepository camadaRepository;

	private UserService() {

	}

	public void save(User user) {
		camadaRepository.save(user);
	}

	public void delete(Long id) {
		camadaRepository.delete(id);
	}

	public static UserService criarInstancia() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	public ArrayList<User> findAll() {
		return camadaRepository.findAll();
	}

	public User findById(Long id) {
		return camadaRepository.findById(id);
	}

}
