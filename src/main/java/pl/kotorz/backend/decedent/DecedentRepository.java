package pl.kotorz.backend.decedent;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface for {@link Decedent} CRUD operations.
 */
public interface DecedentRepository extends CrudRepository<Decedent, Long> {
    /**
     * Interface for find a decedent persons in given year.
     *
     * @param year Year of death
     * @return Iterable of decedent in given year
     */
    @Query("select d from Decedent d where year(d.deathDate) = ?1")
    Iterable<Decedent> findByDeathYear(int year);

    /**
     * Interface for find all years of deaths.
     *
     * @return Iterable of death years
     */
    @Query("select distinct year(d.deathDate) from Decedent d")
    Iterable<Integer> findAllDeathYears();
}
