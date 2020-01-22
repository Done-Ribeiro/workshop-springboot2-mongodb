package com.done.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.done.workshopmongo.domain.User;
import com.done.workshopmongo.dto.UserDTO;
import com.done.workshopmongo.repository.UserRepository;
import com.done.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userReposiroty;

	public List<User> findAll() {
		return userReposiroty.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = userReposiroty.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return userReposiroty.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		userReposiroty.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return userReposiroty.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
