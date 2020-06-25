package pl.kotorz.backend.decedent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kotorz.backend.decedent.dto.DecedentCreationDTO;
import pl.kotorz.backend.decedent.dto.DecedentUpdateDTO;
import pl.kotorz.backend.util.dto.DTO;

/**
 * RestController class for {@link Decedent} API.
 * @version v1
 * @author krystiankomor
 */
@RestController
@RequestMapping("/api/v1/decedents")
public class DecedentRestController {
    @Autowired
    DecedentRepository decedentRepository;

    /**
     * Method for return all decedents people.
     *
     * @return Iterable of all decedents people
     */
    @GetMapping
    public Iterable<Decedent> getAllDecedents() {
        return decedentRepository.findAll();
    }

    /**
     * Method for return decedent person of given id.
     *
     * @param id ID of decedent
     * @return Decedent person of given id
     */
    @GetMapping("/{id}")
    public Decedent findById(@PathVariable Long id) {
        return decedentRepository.findById(id).orElse(null);
    }

    /**
     * Method for create a new decedent person.
     *
     * @param decedent {@link DecedentCreationDTO} of a new decedent
     * @return New created decedent person
     */
    @PostMapping
    public Decedent createDecedent(@DTO(DecedentCreationDTO.class) Decedent decedent) {
        return decedentRepository.save(decedent);
    }

    /**
     * Method for update an existing decedent person.
     *
     * @param decedent {@link DecedentUpdateDTO} of an updating person
     * @return Updated decedent person
     * @throws RuntimeException When no id of the decedent was given
     */
    @PutMapping
    public Decedent updateDecedent(@DTO(DecedentUpdateDTO.class) Decedent decedent) {
        return decedentRepository.save(decedent);
    }

    /**
     * Method for return all years of deaths.
     *
     * @return Iterable of all deaths years
     */
    @GetMapping("/years")
    public Iterable<Integer> getAllYears() {
        return decedentRepository.findAllDeathYears();
    }

    /**
     * Method for return all decedents in given year.
     *
     * @param year Year of death
     * @return Iterable of all decedents in given year
     */
    @GetMapping("/years/{year}")
    public Iterable<Decedent> getAllByDeathYear(@PathVariable int year){
        return decedentRepository.findByDeathYear(year);
    }

}
