package com.done.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.done.workshopmongo.domain.User;
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
}
