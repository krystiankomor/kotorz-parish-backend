package pl.kotorz.backend.baptized.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class BaptizedUpdateDTO {
    @Id
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate bornDate;

    @NotNull
    private LocalDate baptizedDate;
}
