package pl.kotorz.backend.baptized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.modelmapper.ModelMapper;

import org.springframework.boot.test.context.SpringBootTest;

import pl.kotorz.backend.baptized.dto.BaptizedCreationDTO;
import pl.kotorz.backend.baptized.dto.BaptizedUpdateDTO;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Test Baptized DTOs")
public class BaptizedDtoTests {
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    @DisplayName("Creation")
    public void baptizedCreationDto() {
        BaptizedCreationDTO creation = new BaptizedCreationDTO();
        creation.setName("John Smith");
        creation.setBornDate(LocalDate.of(2012, 12, 21));
        creation.setBaptizedDate(LocalDate.of(2013, 1, 10));

        Baptized baptized = modelMapper.map(creation, Baptized.class);

        assertEquals(creation.getName(), baptized.getName());
        assertEquals(creation.getBornDate(), baptized.getBornDate());
        assertEquals(creation.getBaptizedDate(), baptized.getBaptizedDate());
    }

    @Test
    @DisplayName("Update")
    public void baptizedUpdateDto() {
        BaptizedUpdateDTO update = new BaptizedUpdateDTO();
        update.setName("Matt Farrell");
        update.setBornDate(LocalDate.of(2016, 6, 17));
        update.setBaptizedDate(LocalDate.of(2016, 8, 30));

        Baptized baptized = modelMapper.map(update, Baptized.class);

        assertEquals(update.getName(), baptized.getName());
        assertEquals(update.getBornDate(), baptized.getBornDate());
        assertEquals(update.getBaptizedDate(), baptized.getBaptizedDate());
    }
}
