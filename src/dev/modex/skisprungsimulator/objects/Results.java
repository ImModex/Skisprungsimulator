package dev.modex.skisprungsimulator.objects;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The {@link Results} class stores all the results a
 * jumper receives during a competition.
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public class Results implements Comparable<Results> {

    /**
     * List containing the results
     */
    private final ArrayList<Double> results;

    /**
     * Default constructor initilizes list
     */
    public Results() {
        results = new ArrayList<>();
    }

    /**
     * Overloaded constructor calls default constructor to initialize list
     * and adds a given result afterwards.
     *
     * @param result Result to be added to the list of results
     */
    public Results(double result) {
        this();
        results.add(result);
    }

    /**
     * @param result Result to be added to the list of results
     */
    public void addResult(double result) {
        results.add(result);
    }

    /**
     * @param index Index of the result that should be returned
     * @return The result of the list at a given index
     */
    public double getResult(int index) {
        return results.get(index);
    }

    /**
     * @return List of results
     */
    public ArrayList<Double> getResults() {
        return results;
    }

    /**
     * @return Copy of list of results sorted descendingly
     */
    public ArrayList<Double> getSortedResults() {
        ArrayList<Double> ret = new ArrayList<>(results);
        ret.sort(Collections.reverseOrder());
        return ret;
    }

    /**
     * @return Highest result of the results list
     */
    public double getBest() {
        return getSortedResults().get(0);
    }

    /**
     * @return Whether all results are invalid or not
     */
    public boolean disqualified() {
        for (double d : results)
            if (d != 0)
                return false;

        return true;
    }

    /**
     * Overrides {@link Comparable#compareTo(Object)} to be able to sort
     * a list containing {@link Results}.
     *
     * @param o Result the current instance of {@link Results} should be compared to
     * @return Whether the list entry should be moved forward (-1 forward, 0 same spot, 1 back)
     */
    @Override
    public int compareTo(Results o) {
        if (this.getSortedResults().get(0) > o.getSortedResults().get(0))
            return 1;
        else if (this.getSortedResults().get(0).equals(o.getSortedResults().get(0)))
            return 0;

        return -1;
    }
}
