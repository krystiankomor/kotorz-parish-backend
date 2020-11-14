package pl.kotorz.backend.post;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pl.kotorz.backend.user.User;
import pl.kotorz.backend.util.slug.Slug;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entity class to store a post.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private static final int MAX_TITLE_LENGTH = 150;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "post_id", nullable = false)
    private Long id;

    @Column(length = MAX_TITLE_LENGTH)
    private String title;

    @Column(length = MAX_TITLE_LENGTH)
    private String slug;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

    @Column(nullable = false)
    private LocalDate date;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @Column(columnDefinition = "TEXT")
    private String extraBody;

    @ManyToOne
    private User author;

    public void setTitle(String title) {
        this.title = title;

        makeSlug();
    }
    
    /**
     * Generate a SEO-friendly slug based on title.
     * If generated slug is empty, it generates UUIDv4
     * which is a 36 character random value.
     */
    @PrePersist
    @PreUpdate
    private void makeSlug() {
        String slugFromTitle = Slug.getInstance().generateSlug(title);

        if (slugFromTitle.length() > 0) slug = slugFromTitle;
        else if (slug == null || slug.length() != 36) slug = UUID.randomUUID().toString();
    }

}
