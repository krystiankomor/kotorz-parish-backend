package pl.kotorz.backend.decedent.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import pl.kotorz.backend.decedent.Decedent;

/**
 * DTO class for create operation on {@link Decedent}
 */
@Getter
@Setter
public class DecedentCreationDTO {
    @NotNull
    private String name;

    @NotNull
    private LocalDate bornDate;

    @NotNull
    private LocalDate deathDate;
}
