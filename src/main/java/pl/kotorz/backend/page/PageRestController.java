package pl.kotorz.backend.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RestController class for {@link Page} API.
 * @version v1
 * @author krystiankomor
 */
@RestController
@RequestMapping("/api/v1/pages")
public class PageRestController {
    @Autowired
    PageRepository pageRepository;

    @GetMapping
    public Iterable<Page> getAllPosts() {
        return pageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Page findById(@PathVariable Long id) {
        return pageRepository.findById(id).orElse(null);
    }

    @GetMapping("/slug/{slug}")
    public Page findBySlug(@PathVariable String slug) {
        return pageRepository.findBySlug(slug).orElse(null);
    }
}
