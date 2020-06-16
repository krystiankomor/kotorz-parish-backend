package pl.kotorz.backend.baptized;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface for {@link Baptized} CRUD operations.
 */
public interface BaptizedRepository extends CrudRepository<Baptized, Long> {
    /**
     * Interface for find a baptized persons in given year.
     *
     * @param year Year of baptizing.
     * @return Iterable of baptized in given year.
     */
    @Query("select b from Baptized b where year(b.baptizedDate) = ?1")
    Iterable<Baptized> findByBaptizedYear(int year);

    /**
     * Interface for find all years of baptizing.
     *
     * @return Iterable of baptizing years.
     */
    @Query("select distinct year(b.baptizedDate) from Baptized b")
    Iterable<Integer> findAllBaptizingYears();
}
