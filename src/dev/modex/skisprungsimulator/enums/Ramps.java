package dev.modex.skisprungsimulator.enums;

import dev.modex.skisprungsimulator.objects.Ramp;
import dev.modex.skisprungsimulator.utils.CustomRandom;

import java.util.List;

/**
 * This enum contains a list of 10 real ski-jumping ramps in Austria.
 * It is used to initialize a {@link Ramp}.
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public enum Ramps {
    Kulm("Kulm Skiflugschanze", "Bad Mitterndorf", 200, 235),
    PaulAussleitner("Paul-Außerleitner-Schanze", "Bischofshofen", 125, 142),
    Bergisel("Bergisel-Schanze", "Innsbruck", 120, 130),
    HansWalland("Hans-Walland-Großschanze", "Murau", 120, 125),
    Brunnentalschanzen("Brunnentalschanzen", "Stams", 105, 115),
    ToniSeelos("Toni-Seelos-Olympiaschanze", "Seefeld", 99, 109),
    Erzbergschanze("Erzbergschanzen", "Eisenerz", 98, 109),
    MontafonerSchanze("Montafoner-Schanzenzentrum", "Tschagguns", 97, 108),
    W90Schanze("W90-Schanze", "Ramsau", 90, 98),
    VillacherAlpenSchanze("Villacher Alpen Arena", "Villach", 90, 98);

    /**
     * Name of the ramp
     */
    private final String name;

    /**
     * Location of the ramp
     */
    private final String location;

    /**
     * KPoint of the ramp
     */
    private final double kpoint;

    /**
     * Hillsize of the ramp
     */
    private final double hillsize;

    /**
     * Constructor
     *
     * @param name     Initializes the name of the ramp
     * @param location Initializes the location of the ramp
     * @param kpoint   Initializes the kpoint of the ramp
     * @param hillsize Initializes the hillsize of the ramp
     */
    Ramps(String name, String location, double kpoint, double hillsize) {
        this.name = name;
        this.location = location;
        this.kpoint = kpoint;
        this.hillsize = hillsize;
    }

    /**
     * @return Name of the ramp
     */
    public String getName() {
        return name;
    }

    /**
     * @return Location of the ramp
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return KPoint of the ramp
     */
    public double getKpoint() {
        return kpoint;
    }

    /**
     * @return Hillsize of the ramp
     */
    public double getHillsize() {
        return hillsize;
    }

    /**
     * Used to initialize a {@link Ramp} from an {@link Ramps} entry.
     *
     * @return Ramp with preset values
     */
    public Ramp toRamp() {
        return new Ramp(getName(), getLocation(), getKpoint(), getHillsize());
    }

    /**
     * Do not forget to convert into a {@link Ramp}!
     *
     * @return A random ramp entry
     */
    public static Ramps random() {
        return List.of(values()).get(new CustomRandom().nextInt(values().length - 1));
    }
}
