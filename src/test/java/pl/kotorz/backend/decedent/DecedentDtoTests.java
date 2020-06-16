package pl.kotorz.backend.decedent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kotorz.backend.baptized.Baptized;
import pl.kotorz.backend.baptized.dto.BaptizedCreationDTO;
import pl.kotorz.backend.baptized.dto.BaptizedUpdateDTO;
import pl.kotorz.backend.decedent.dto.DecedentCreationDTO;
import pl.kotorz.backend.decedent.dto.DecedentUpdateDTO;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Test Decedent DTOs")
public class DecedentDtoTests {
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    @DisplayName("Creation")
    public void decedentCreationDto() {
        DecedentCreationDTO creation = new DecedentCreationDTO();
        creation.setName("John Smith");
        creation.setBornDate(LocalDate.of(2012, 12, 21));
        creation.setDeathDate(LocalDate.of(2013, 1, 10));

        Decedent decedent = modelMapper.map(creation, Decedent.class);

        assertEquals(creation.getName(), decedent.getName());
        assertEquals(creation.getBornDate(), decedent.getBornDate());
        assertEquals(creation.getDeathDate(), decedent.getDeathDate());
    }

    @Test
    @DisplayName("Update")
    public void decedentUpdateDto() {
        DecedentUpdateDTO update = new DecedentUpdateDTO();
        update.setName("Matt Farrell");
        update.setBornDate(LocalDate.of(2016, 6, 17));
        update.setDeathDate(LocalDate.of(2016, 8, 30));

        Decedent decedent = modelMapper.map(update, Decedent.class);

        assertEquals(update.getName(), decedent.getName());
        assertEquals(update.getBornDate(), decedent.getBornDate());
        assertEquals(update.getDeathDate(), decedent.getDeathDate());
    }
}
