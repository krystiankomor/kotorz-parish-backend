package pl.kotorz.backend.baptized;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BaptizedRepository extends CrudRepository<Baptized, Long> {
    @Query("select b from Baptized b where year(b.baptizedDate) = ?1")
    Iterable<Baptized> findByBaptizedYear(int year);
}
