package pl.kotorz.backend.post;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/posts")
public class PostRestController {
	@Autowired
	PostRepository postRepository;

	@GetMapping(value = "/")
	public Iterable<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Post> findById(@PathVariable Long id) {
		return postRepository.findById(id);
	}

}
