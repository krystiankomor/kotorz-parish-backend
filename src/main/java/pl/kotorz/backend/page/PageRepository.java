package pl.kotorz.backend.page;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PageRepository extends CrudRepository<Page, Long> {
    Optional<Page> findBySlug(String slug);
}
