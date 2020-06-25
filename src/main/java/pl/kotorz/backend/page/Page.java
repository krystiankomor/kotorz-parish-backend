package pl.kotorz.backend.page;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import pl.kotorz.backend.util.slug.Slug;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Page {
    private static final int MAX_TITLE_LENGTH = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "page_id", nullable = false)
    Long id;

    @Column(nullable = false, length = MAX_TITLE_LENGTH)
    String title;

    @Column(nullable = false, length = MAX_TITLE_LENGTH)
    String slug;

    @Column(columnDefinition = "TEXT", nullable = false)
    String body;

    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

    /**
     * Generate a SEO-friendly slug based on title.
     *
     * @throws RuntimeException if slug is shorter than 3 chars
     */
    @PrePersist
    @PreUpdate
    private void makeSlug() {
        String slugFromTitle = Slug.getInstance().generateSlug(title);

        if (slugFromTitle.length() > 2) slug = slugFromTitle;
        else throw new RuntimeException("Title is invalid. Must contain at least 3 standard characters.");
    }

}
