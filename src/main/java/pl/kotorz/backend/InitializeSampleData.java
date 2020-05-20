package pl.kotorz.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import pl.kotorz.backend.model.Post;
import pl.kotorz.backend.repository.PostRepository;

@Component
public class InitializeSampleData implements ApplicationRunner {
	@Autowired
	PostRepository postRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		postRepository.save(new Post("Sample title", "Sample text", null));
		postRepository.save(new Post("Sample title of 2nd post", "Title too long", null));
	}
}
