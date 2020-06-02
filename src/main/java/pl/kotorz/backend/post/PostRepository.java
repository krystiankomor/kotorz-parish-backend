package pl.kotorz.backend.post;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
	Optional<Post> findByTitle(String title);
}
