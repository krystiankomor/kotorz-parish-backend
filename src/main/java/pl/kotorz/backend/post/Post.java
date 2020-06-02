package pl.kotorz.backend.post;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import com.github.slugify.Slugify;

import pl.kotorz.backend.user.User;


@Entity
@Validated
@Getter
@Setter
@EqualsAndHashCode
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

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createDate;

	@Column(nullable = false)
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

	public void setTitle(String title) {
		this.title = title;

		setSlug(makeSlug(title));
	}

	private String makeSlug(String title) {
		return new Slugify().slugify(title);
	}

}
