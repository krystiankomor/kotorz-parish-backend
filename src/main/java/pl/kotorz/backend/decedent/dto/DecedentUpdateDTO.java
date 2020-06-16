package pl.kotorz.backend.decedent.dto;

import lombok.Getter;
import lombok.Setter;
import pl.kotorz.backend.decedent.Decedent;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * DTO class for update operation on {@link Decedent}
 */
@Getter
@Setter
public class DecedentUpdateDTO {
    @Id
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate bornDate;

    @NotNull
    private LocalDate deathDate;

}
