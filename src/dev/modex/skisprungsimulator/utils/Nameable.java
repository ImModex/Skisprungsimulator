package dev.modex.skisprungsimulator.utils;

/**
 * The {@link Nameable} class is a utility class to easily manage nameable things.
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public abstract class Nameable {

    /**
     * Name of something
     */
    private String name;

    /**
     * @return Name of something
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Name of something
     */
    public void setName(String name) {
        this.name = name;
    }
}
