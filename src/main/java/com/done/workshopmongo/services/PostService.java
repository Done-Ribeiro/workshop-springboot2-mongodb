package com.done.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.done.workshopmongo.domain.Post;
import com.done.workshopmongo.repository.PostRepository;
import com.done.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postReposiroty;

	public Post findById(String id) {
		Optional<Post> obj = postReposiroty.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) {
		return postReposiroty.searchTitle(text);
	}
}
