package pl.kotorz.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kotorz.backend.post.Post;

@SpringBootTest
@DisplayName("The post entity test")
public class PostTests {

	@Test
	@DisplayName("Testing the slug generation")
	void postSlugTest() {
		Post post = new Post();
		post.setTitle("Zażółć gęślą jaźń.");

		assertEquals("zazolc-gesla-jazn", post.getSlug());
	}

}
