package pl.kotorz.backend.post.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import pl.kotorz.backend.post.Post;

/**
 * DTO class for update operation on {@link Post}
 */
@Getter
@Setter
public class PostUpdateDTO {
    @Id
    @NotNull
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private LocalDate date;

    @NotNull
    private String body;

    @NotNull
    private String extraBody;

}
