package pl.kotorz.backend.post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.github.slugify.Slugify;

import pl.kotorz.backend.user.User;

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
    private LocalDateTime updateDate;

    @Column(nullable = false)
    private LocalDate date;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @Column(columnDefinition = "TEXT")
    private String extraBody;

    @ManyToOne
    private User author;

    /**
     * Generate a SEO-friendly slug based on title.
     * If generated slug is empty, it generates UUIDv4
     * which is a 36 character random value.
     */
    @PostLoad
    @PrePersist
    private void makeSlug() {
        String slugFromTitle = new Slugify().slugify(title);

        if (slugFromTitle.length() > 0) slug = slugFromTitle;
        else slug = UUID.randomUUID().toString();
    }

}
