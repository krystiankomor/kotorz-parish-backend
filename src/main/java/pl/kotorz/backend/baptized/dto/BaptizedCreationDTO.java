package pl.kotorz.backend.baptized.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import pl.kotorz.backend.baptized.Baptized;

/**
 * DTO class for create operation on {@link Baptized}
 */
@Getter
@Setter
public class BaptizedCreationDTO {
    @NotNull
    private String name;

    @NotNull
    private LocalDate bornDate;

    @NotNull
    private LocalDate baptizedDate;
}
