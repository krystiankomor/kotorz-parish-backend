package pl.kotorz.backend.baptized;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.kotorz.backend.baptized.dto.BaptizedCreationDTO;
import pl.kotorz.backend.baptized.dto.BaptizedUpdateDTO;
import pl.kotorz.backend.util.DTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/baptized")
public class BaptizedRestController {
    @Autowired
    BaptizedRepository baptizedRepository;

    @GetMapping
    public Iterable<Baptized> getAllBaptized() {
        return baptizedRepository.findAll();
    }

    @PostMapping
    public Baptized createBaptized(@DTO(BaptizedCreationDTO.class) Baptized baptized) {
        return baptizedRepository.save(baptized);
    }

    @PutMapping
    public Baptized updateBaptized(@DTO(BaptizedUpdateDTO.class) Baptized baptized) {
        return baptizedRepository.save(baptized);
    }

    @GetMapping("/{year}")
    public Iterable<Baptized> getAllByBaptizedYear(@PathVariable int year){
        return baptizedRepository.findByBaptizedYear(year);
    }

}
