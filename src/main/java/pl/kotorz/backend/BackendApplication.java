package pl.kotorz.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pl.kotorz.backend.model.Post;
import pl.kotorz.backend.repository.PostRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Bean
	  public CommandLineRunner demo(PostRepository postRepository) {
	    return (args) -> {
	    	postRepository.save(new Post("Sample title", "Sample text", null));
	    	postRepository.save(new Post("Sample title of 2nd post", "Title too long", null));
	    };
	  }

}
