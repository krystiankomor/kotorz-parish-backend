package pl.kotorz.backend.post.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import pl.kotorz.backend.post.Post;

/**
 * DTO class for create operation on {@link Post}
 */
@Getter
@Setter
public class PostCreationDTO {
    @NotNull
    private String title;

    @NotNull
    private LocalDate date;

    @NotNull
    private String body;

    @NotNull
    private String extraBody;
}
