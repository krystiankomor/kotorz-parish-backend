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
		Post firstPost = new Post();
		firstPost.setTitle("Sample title");
		firstPost.setBody("Sample body");
		postRepository.save(firstPost);
		
		Post secondPost = new Post();
		secondPost.setTitle("Sample title of 2nd post");
		secondPost.setBody("Sample body of 2nd post");
		secondPost.setExtraBody("Sample extra body of 2nd post");
		postRepository.save(secondPost);
	}
}
