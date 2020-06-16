package pl.kotorz.backend.decedent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Test Decedent")
public class DecedentTests {
    @Test
    @DisplayName("Age generation")
    public void decedentAgeGeneration() {
        Decedent decedent = new Decedent();

        decedent.setName("John Smith");
        decedent.setBornDate(LocalDate.of(1920, 1, 1));
        decedent.setDeathDate(LocalDate.of(2020, 1, 1));

        assertEquals(100, decedent.getAge());

        decedent.setDeathDate(LocalDate.of(2019, 12, 31));

        assertEquals(99, decedent.getAge());

        decedent.setBornDate(LocalDate.of(2020, 6, 5));
        decedent.setDeathDate(LocalDate.of(2021, 6, 4));

        assertEquals(0, decedent.getAge());
    }

}
