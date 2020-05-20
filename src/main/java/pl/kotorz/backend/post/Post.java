package pl.kotorz.backend.post;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import com.github.slugify.Slugify;

import pl.kotorz.backend.user.User;

@Entity
@Validated
public class Post {
	private static final int MAX_TITLE_LENGTH = 150;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "post_id", nullable = false)
	private Long id;

	@Column(nullable = true)
	@Length(max = MAX_TITLE_LENGTH, message = "Title too long")
	private String title;

	@Column(nullable = true, length = MAX_TITLE_LENGTH)
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

	@Column(columnDefinition = "TEXT", nullable = true)
	private String extraBody;

	@ManyToOne
	private User author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;

		setSlug(makeSlug());
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getExtraBody() {
		return extraBody;
	}

	public void setExtraBody(String extraBody) {
		this.extraBody = extraBody;
	}

	private String makeSlug() {
		return new Slugify().slugify(this.title);
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
