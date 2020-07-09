package pl.kotorz.backend.post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface for {@link Post} CRUD operations.
 */
public interface PostRepository extends CrudRepository<Post, Long> {
	/**
	 * Interface for find posts in given year.
	 *
	 * @param year Year of posts
	 * @return Iterable of posts in given year
	 */
	@Query("select p from Post p where year(p.date) = ?1")
	Iterable<Post> findAllByYear(int year);

	/**
	 * Interface for find all years of posts.
	 *
	 * @return Iterable of post years
	 */
	@Query("select distinct year(p.date) from Post p")
	Iterable<Integer> findAllDateYears();

	/**
	 * Interface for find all post and order by
	 * date descending and id descending.
	 *
	 * @return Iterable of all sorted posts
	 */
	Iterable<Post> findAllByOrderByDateDescIdDesc();
}
