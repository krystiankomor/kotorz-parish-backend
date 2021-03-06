package pl.kotorz.backend;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import pl.kotorz.backend.baptized.Baptized;
import pl.kotorz.backend.baptized.BaptizedRepository;
import pl.kotorz.backend.decedent.Decedent;
import pl.kotorz.backend.decedent.DecedentRepository;
import pl.kotorz.backend.page.Page;
import pl.kotorz.backend.page.PageRepository;
import pl.kotorz.backend.post.Post;
import pl.kotorz.backend.post.PostRepository;
import pl.kotorz.backend.user.User;
import pl.kotorz.backend.user.UserRepository;

@Component
public class InitializeSampleData implements ApplicationRunner {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BaptizedRepository baptizedRepository;

    @Autowired
    DecedentRepository decedentRepository;

    @Autowired
    PageRepository pageRepository;

    @Override
    public void run(ApplicationArguments args) {
        User firstUser = new User();
        firstUser.setEmail("ala@kot.pl");
        firstUser.setName("Testowy Agent");
        firstUser.setPassword("tajne");
        userRepository.save(firstUser);

        Post firstPost = new Post();
        firstPost.setTitle("Sample title");
        firstPost.setBody("Sample body");
        firstPost.setAuthor(firstUser);
        firstPost.setDate(LocalDate.now());
        postRepository.save(firstPost);

        Post secondPost = new Post();
        secondPost.setTitle("Sample title of 2nd post");
        secondPost.setBody("Sample body of 2nd post");
        secondPost.setExtraBody("Sample extra body of 2nd post");
        secondPost.setAuthor(firstUser);
        secondPost.setDate(LocalDate.of(2019, 6, 23));
        postRepository.save(secondPost);

        Post thirdPost = new Post();
        thirdPost.setTitle("!!!");
        thirdPost.setBody("This post should generate a random slug");
        thirdPost.setAuthor(firstUser);
        thirdPost.setDate(LocalDate.of(2017, 12, 10));
        postRepository.save(thirdPost);

        Baptized baptizedJanKowalski = new Baptized();
        baptizedJanKowalski.setName("Jan Kowalski");
        baptizedJanKowalski.setBornDate(LocalDate.of(2020, 1, 1));
        baptizedJanKowalski.setBaptizedDate(LocalDate.of(2020, 2, 1));
        baptizedRepository.save(baptizedJanKowalski);

        Decedent decedentJohnSmith = new Decedent();
        decedentJohnSmith.setName("John Smith");
        decedentJohnSmith.setBornDate(LocalDate.of(1953, 3, 12));
        decedentJohnSmith.setDeathDate(LocalDate.of(2020, 5, 30));
        decedentRepository.save(decedentJohnSmith);

        Decedent decedentMattMurphy = new Decedent();
        decedentMattMurphy.setName("Matt Murphy");
        decedentMattMurphy.setBornDate(LocalDate.of(1953, 5, 12));
        decedentMattMurphy.setDeathDate(LocalDate.of(2020, 3, 30));
        decedentRepository.save(decedentMattMurphy);

        Page historyPage = new Page();
        historyPage.setTitle("History");
        historyPage.setBody("<p>It all begins in 1295.</p>");
        pageRepository.save(historyPage);
    }
}
