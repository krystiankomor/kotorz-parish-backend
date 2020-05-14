package pl.kotorz.backend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pl.kotorz.backend.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
	Optional<Post> findById(Long id);
}
