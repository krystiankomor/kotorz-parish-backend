package pl.kotorz.backend.baptized;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entity class for baptized people.
 * @author krystiankomor
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Baptized {
    public static final int MAX_NAME_LENGTH = 70;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baptized_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = MAX_NAME_LENGTH)
    private String name;

    @Column(nullable = false)
    private LocalDate bornDate;

    @Column(nullable = false)
    private LocalDate baptizedDate;
}
