package pl.kotorz.backend.baptized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kotorz.backend.baptized.dto.BaptizedCreationDTO;
import pl.kotorz.backend.baptized.dto.BaptizedUpdateDTO;
import pl.kotorz.backend.util.dto.DTO;

/**
 * RestController class for {@link Baptized} API.
 * @version v1
 * @author krystiankomor
 */
@RestController
@RequestMapping("/api/v1/baptized")
public class BaptizedRestController {
    @Autowired
    BaptizedRepository baptizedRepository;

    /**
     * Method for return all baptized people.
     *
     * @return Iterable of all baptized people
     */
    @GetMapping
    public Iterable<Baptized> getAllBaptized() {
        return baptizedRepository.findAll();
    }

    /**
     * Method for return baptized person of given id.
     *
     * @param id ID of baptized
     * @return Baptized person of given id
     */
    @GetMapping("/{id}")
    public Baptized findById(@PathVariable Long id) {
        return baptizedRepository.findById(id).orElse(null);
    }

    /**
     * Method for create a new baptized person.
     *
     * @param baptized {@link BaptizedCreationDTO} of a new baptized
     * @return New created baptized person
     */
    @PostMapping
    public Baptized createBaptized(@DTO(BaptizedCreationDTO.class) Baptized baptized) {
        return baptizedRepository.save(baptized);
    }

    /**
     * Method for update an existing baptized person.
     *
     * @param baptized {@link BaptizedUpdateDTO} of an updating person
     * @return Updated baptized person
     * @throws RuntimeException When no id of the baptized was given
     */
    @PutMapping
    public Baptized updateBaptized(@DTO(BaptizedUpdateDTO.class) Baptized baptized) {
        if(baptized.getId() != null) return baptizedRepository.save(baptized);

        throw new RuntimeException("No ID was given.");
    }

    /**
     * Method for return all years of baptizing.
     *
     * @return Iterable of all baptizing years
     */
    @GetMapping("/years")
    public Iterable<Integer> getAllYears() {
        return baptizedRepository.findAllBaptizingYears();
    }

    /**
     * Method for return all baptized in given year.
     *
     * @param year Year of baptizing
     * @return Iterable of all baptized in given year
     */
    @GetMapping("/years/{year}")
    public Iterable<Baptized> getAllByBaptizedYear(@PathVariable int year){
        return baptizedRepository.findByBaptizedYear(year);
    }

}
