package pl.kotorz.backend.decedent;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Entity class for store a baptized people.
 * @author krystiankomor
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Decedent {
    public static final int MAX_NAME_LENGTH = 70;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "decedent_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = MAX_NAME_LENGTH)
    private String name;

    @Column(nullable = false)
    private LocalDate bornDate;

    @Column(nullable = false)
    private LocalDate deathDate;

    @Transient
    @JsonInclude
    private Long age;

    /**
     * Generate age of decedent.
     */
    @PostLoad
    @PrePersist
    private void generateAge() {
        if(bornDate != null && deathDate != null) {
            age = bornDate.until(deathDate, ChronoUnit.YEARS);
        }
    }
}
