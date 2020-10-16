package dev.modex.skisprungsimulator.enums;

import dev.modex.skisprungsimulator.objects.Jumper;
import dev.modex.skisprungsimulator.utils.CustomRandom;

import java.util.List;

/**
 * This enum is used to randomly generate last names for {@link Jumper}.
 * The values are based on a list of the most common last names in Austria.
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public enum LastName {
    Gruber,
    Huber,
    Wagner,
    Mueller,
    Pichler,
    Moser,
    Steiner,
    Mayer,
    Berger,
    Bauer,
    Hofer,
    Eder,
    Fuchs,
    Leitner,
    Schmid,
    Winkler,
    Schwarz,
    Maier,
    Weber,
    Schneider,
    Fischer,
    Mayr,
    Reiter,
    Wimmer,
    Baumgartner,
    Egger,
    Brunner,
    Schmidt,
    Weiss,
    Auer,
    Wallner,
    Aigner,
    Wolf,
    Ebner,
    Lang,
    Binder,
    Lechner,
    Haas,
    Schuster,
    Strasser,
    Haider,
    Wieser,
    Stadler,
    Lehner,
    Koller,
    Holzer,
    Mair,
    Graf,
    Riegler,
    Boehm;

    /**
     * @return A random last name
     */
    public static LastName random() {
        return List.of(values()).get(new CustomRandom().nextInt(values().length - 1));
    }
}
