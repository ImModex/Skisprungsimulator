package dev.modex.skisprungsimulator.objects;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The {@link Competition} class stores all the information of
 * a running ski-jumping competition.
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public class Competition {

    /**
     * List of competitors attending the competition
     */
    private List<Jumper> competitors;

    /**
     * HashMap to store all results of a {@link Jumper}.
     * Results are stored in the wrapper class {@link Results}
     */
    private final HashMap<Jumper, Results> results;

    /**
     * Ramp that the competitors will jump off of
     */
    private Ramp ramp;

    /**
     * How many rounds the competitors should jump
     */
    private int rounds;

    /**
     * Default constructor initializing default values
     */
    public Competition() {
        competitors = new ArrayList<>();
        results = new HashMap<>();
        ramp = new Ramp();
        rounds = 1;
    }

    /**
     * Overloaded constructor calls default constructor
     * and adds all {@link Jumper} to the list of competitors.
     *
     * @param competitors List of competitors to initialize
     */
    public Competition(List<Jumper> competitors) {
        this();
        this.competitors.addAll(competitors);
    }

    /**
     * Overloaded constructor calls overloaded constructor
     * to add all {@link Jumper} to the list of competitors
     * and initializes a specific {@link Ramp}.
     *
     * @param competitors List of competitors to initialize
     * @param ramp        Ramp to initialize
     */
    public Competition(List<Jumper> competitors, Ramp ramp) {
        this(competitors);
        this.ramp = ramp;
    }

    /**
     * @param jumper Jumper to add to the competition
     */
    public void addJumper(Jumper jumper) {
        competitors.add(jumper);
    }

    /**
     * @param jumper Jumper, whose result should be saved
     * @param result Result stored for the given jumper
     */
    public void addResult(Jumper jumper, Double result) {
        if (results.containsKey(jumper))
            results.get(jumper).addResult(result);
        else
            results.put(jumper, new Results(result));
    }

    /**
     * @return Copy of results HashMap sorted by
     * best value of each jumper
     */
    public LinkedHashMap<Jumper, Results> sortResults() {
        return results.entrySet().stream().sorted(Map.Entry.<Jumper, Results>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    /**
     * @return List of competitors in competition
     */
    public List<Jumper> getCompetitors() {
        return competitors;
    }

    /**
     * @return HashMap with stored results
     */
    public HashMap<Jumper, Results> getResults() {
        return results;
    }

    /**
     * @param ramp Ramp that the competitors will jump off of
     */
    public void setRamp(Ramp ramp) {
        this.ramp = ramp;
    }

    /**
     * @return Ramp that the competitors will jump off of
     */
    public Ramp getRamp() {
        return ramp;
    }

    /**
     * @return How many rounds the competitors should jump
     */
    public int getRounds() {
        return rounds;
    }

    /**
     * @param rounds How many rounds the competitors should jump
     */
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
