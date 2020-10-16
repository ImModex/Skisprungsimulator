package dev.modex.skisprungsimulator.objects;

import dev.modex.skisprungsimulator.enums.Ramps;
import dev.modex.skisprungsimulator.utils.Nameable;

/**
 * The {@link Ramp} class stores all the information of
 * a specific ramp the competitors should jump off of.
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public class Ramp extends Nameable {

    /**
     * Location of the ramp
     */
    private String location;

    /**
     * KPoint of the ramp
     */
    private double kpoint;

    /**
     * Hillsize of the ramp
     */
    private double hillsize;

    /**
     * Default constructor will initialize a {@link Ramp}
     * that has been randomly chosen by {@link Ramps#random()}
     */
    public Ramp() {
        this(Ramps.random().toRamp());
    }

    /**
     * Copy constructor
     *
     * @param ramp Ramp that should be copied
     */
    public Ramp(Ramp ramp) {
        setName(ramp.getName());
        setLocation(ramp.getLocation());
        setKpoint(ramp.getKpoint());
        setHillsize(ramp.getHillsize());
    }

    /**
     * Used if a ramp was to be initialized manually
     *
     * @param name     Name of the ramp
     * @param location Location of the ramp
     * @param kpoint   KPoint of the ramp
     * @param hillsize Hillsize of the ramp
     * @throws IllegalArgumentException If the name is either blank or empty,
     *                                  the location is either blank or empty, the KPoint is below 1 or the
     *                                  hillsize is below 1
     */
    public Ramp(String name, String location, double kpoint, double hillsize) {
        if (name.isBlank() || name.isEmpty() || location.isEmpty() || location.isBlank() || kpoint < 1d || hillsize < 1d)
            throw new IllegalArgumentException();

        setName(name);
        setLocation(location);
        setKpoint(kpoint);
        setHillsize(hillsize);
    }

    /**
     * @see Ramps#getLocation()
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location Location of the ramp
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @see Ramps#getKpoint() ()
     */
    public double getKpoint() {
        return kpoint;
    }

    /**
     * @param kpoint KPoint of the ramp
     */
    public void setKpoint(double kpoint) {
        this.kpoint = kpoint;
    }

    /**
     * @see Ramps#getHillsize() ()
     */
    public double getHillsize() {
        return hillsize;
    }

    /**
     * @param hillsize Hillsize of the ramp
     */
    public void setHillsize(double hillsize) {
        this.hillsize = hillsize;
    }

    /**
     * Overrides the default {@link Object#toString()} method to print the
     * ramp information formatted nicely
     *
     * @return String containing nicely formatted ramp information
     */
    @Override
    public String toString() {
        return String.format("\tName: %s%n\tLocation: %s%n\tKPoint: %s%n\tHillsize: %s", getName(), getLocation(), getKpoint(), getHillsize());
    }
}
