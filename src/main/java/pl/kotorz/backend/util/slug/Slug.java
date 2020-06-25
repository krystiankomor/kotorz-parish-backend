package pl.kotorz.backend.util.slug;

import com.github.slugify.Slugify;

/**
 * A proxy class to generate a slug.
 * It implements a singleton design pattern.
 */
public class Slug implements SlugLib {
    private static Slug instance;

    private final Slugify slugify;

    private Slug() {
        slugify = new Slugify();
    }

    public static Slug getInstance() {
        if(instance == null) {
            instance = new Slug();
        }

        return instance;
    }

    public String generateSlug(String text) {
        return slugify.slugify(text);
    }
}
