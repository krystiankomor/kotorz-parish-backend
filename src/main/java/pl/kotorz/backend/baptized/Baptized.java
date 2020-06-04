package pl.kotorz.backend.baptized;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Baptized {
    /**
     * The longest polish surname is 28 characters long and
     * the longest polish name i 13 characters long so
     * summary is 41.
     * World's longest surname is 35 characters long.
     */
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
