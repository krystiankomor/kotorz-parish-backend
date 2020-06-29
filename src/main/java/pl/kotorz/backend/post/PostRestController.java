package pl.kotorz.backend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kotorz.backend.post.dto.PostCreationDTO;
import pl.kotorz.backend.post.dto.PostUpdateDTO;
import pl.kotorz.backend.util.dto.DTO;

/**
 * RestController class for {@link Post} API.
 * @version v1
 * @author krystiankomor
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/posts")
public class PostRestController {
    @Autowired
    PostRepository postRepository;

    /**
     * Method for return all posts.
     *
     * @return Iterable of all posts
     */
    @GetMapping
    public Iterable<Post> getAllPosts() {
        return postRepository.findAllByOrderByDateDesc();
    }

    /**
     * Method for return post of given id.
     *
     * @param id ID of post
     * @return Post of given id
     */
    @GetMapping("/{id}")
    public Post findById(@PathVariable Long id) {
        return postRepository.findById(id).orElse(null);
    }

    /**
     * Method for create a new post.
     *
     * @param post {@link PostCreationDTO} of a new post
     * @return New created post
     */
    @PostMapping
    public Post createPost(@DTO(PostCreationDTO.class) Post post) {
        return postRepository.save(post);
    }

    /**
     * Method for update an existing post.
     *
     * @param post {@link PostUpdateDTO} of an updating post
     * @return Updated post
     * @throws RuntimeException When no id of the post was given
     */
    @PutMapping
    public Post updatePost(@DTO(PostUpdateDTO.class) Post post) {
        return postRepository.save(post);
    }

    /**
     * Method for return all years of posts.
     *
     * @return Iterable of all post years
     */
    @GetMapping("/years")
    public Iterable<Integer> getAllYears() {
        return postRepository.findAllDateYears();
    }

    /**
     * Method for return all posts from given year.
     *
     * @param year Year od posts date
     * @return Iterable posts from given year
     */
    @GetMapping("/years/{year}")
    public Iterable<Post> getAllByYear(@PathVariable int year){
        return postRepository.findAllByYear(year);
    }

}
