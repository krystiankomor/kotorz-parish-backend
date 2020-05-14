package pl.kotorz.backend.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.github.slugify.Slugify;

@Entity
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

	@Column(columnDefinition = "TEXT", nullable = false)
	private String body;

	@Column(columnDefinition = "TEXT", nullable = true)
	private String extraBody;

	public Post() { }

	public Post(String title, String body, String extraBody) {
		this.title = title;
		this.slug = new Slugify().slugify(title);
		this.body = body;
		this.extraBody = extraBody;
	}

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

}
