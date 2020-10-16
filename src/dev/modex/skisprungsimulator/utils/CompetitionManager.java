package dev.modex.skisprungsimulator.utils;

import dev.modex.skisprungsimulator.objects.Competition;
import dev.modex.skisprungsimulator.objects.Jumper;
import dev.modex.skisprungsimulator.objects.Ramp;
import dev.modex.skisprungsimulator.objects.Results;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The {@link CompetitionManager} class initializes and manages a {@link Competition}
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public class CompetitionManager {

    /**
     * {@link Competition} storing all competition data
     */
    private final Competition competition;

    /**
     * Default constructor initializing a new {@link Competition}
     *
     * @see Competition#Competition()
     */
    public CompetitionManager() {
        competition = new Competition();
    }

    /**
     * Default constructor initializing a new {@link Competition} with
     * a list of competitors
     *
     * @param competitors List of competitors to be initialized
     * @see Competition#Competition(List)
     */
    public CompetitionManager(List<Jumper> competitors) {
        competition = new Competition(competitors);
    }

    /**
     * Default constructor initializing a new {@link Competition} with
     * a list of competitors and a ramp
     *
     * @param competitors List of competitors to be initialized
     * @param ramp        Ramp that the competitors should jump off of
     * @see Competition#Competition(List, Ramp)
     */
    public CompetitionManager(List<Jumper> competitors, Ramp ramp) {
        competition = new Competition(competitors, ramp);
    }

    /**
     * When starting the program without any command line arguments,
     * the program will ask for two integers, firstly, the number
     * of competitors and secondly the number of rounds. These
     * will be passed to each {@link CompetitionManager#addRandomCompetitors(int)}
     * to add a given number of random competitors to the competition
     * and {@link CompetitionManager#setRounds(int)} to set how many
     * rounds each competitor should jump. The program can also be started
     * with two arguments, each containing the above described numbers
     * to skip the manual initialization sequence.
     *
     * @param args Command line arguments passed from Main
     * @return Current instance of {@link CompetitionManager}
     */
    public CompetitionManager handleArgs(String[] args) {
        if (args.length == 0) {
            System.out.print("Please enter how many competitors the competition should have: ");
            int competitors = getInput();

            System.out.print("Please enter how many rounds the competition should have: ");
            int rounds = getInput();

            System.out.println("\n\n");
            this.randomRamp().addRandomCompetitors(competitors).setRounds(rounds);
        } else {
            if (args.length != 2) {
                System.out.println("Invalid arguments.");
                System.out.println("java -jar Skisprungsimulator.jar <Competitors> <Rounds>\n");
            }

            try {
                int competitors = Integer.parseInt(args[0]);
                int rounds = Integer.parseInt(args[1]);
                this.randomRamp().addRandomCompetitors(competitors).setRounds(rounds);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numbers as arguments.");
            }
        }

        return this;
    }

    /**
     * Used to ask for user input with error handling. Input may
     * only be an integer ranging from 1 - X.
     *
     * @return Validated input of user
     */
    private int getInput() {
        int in = 0;
        do {
            try {
                in = new Scanner(System.in).nextInt();
                if (in <= 0)
                    System.out.print("Invalid input! Please enter a valid number. (1 - X): ");
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Please enter a valid number. (1 - X): ");
            }
        } while (in <= 0);

        return in;
    }

    /**
     * Adds a specific amount of random competitors to the competition.
     *
     * @param size Amount of random competitors to be added
     * @return Current instance of {@link CompetitionManager}
     * @see Jumper#Jumper()
     */
    public CompetitionManager addRandomCompetitors(int size) {

        for (int i = 0; i < size; i++) {
            competition.addJumper(new Jumper());
        }
        return this;
    }

    /**
     * @param ramp Ramp that the competitors should jump off of
     * @return Current instance of {@link CompetitionManager}
     */
    public CompetitionManager setRamp(Ramp ramp) {
        competition.setRamp(ramp);
        return this;
    }

    /**
     * Initializes a random ramp for the competitors to jump off of.
     *
     * @return Current instance of {@link CompetitionManager}
     * @see Ramp#Ramp()
     */
    public CompetitionManager randomRamp() {
        competition.setRamp(new Ramp());
        return this;
    }

    /**
     * @param rounds Amount of rounds each competitor should jump
     * @return Current instance of {@link CompetitionManager}
     */
    public CompetitionManager setRounds(int rounds) {
        competition.setRounds(rounds);
        return this;
    }

    /**
     * Used to add a random variance to a given value with a minimum
     * value of 0 and the maximum value of 10.
     *
     * @param val Value where the variance should be added to
     * @param min Minimum of the variance
     * @param max Maximum of the variance
     * @return Value with the variance added to it
     */
    private double addVariance(double val, double min, double max) {
        return Math.max(0, Math.min(10, val + new CustomRandom().nextDouble(min, max)));
    }

    /**
     * Used to calculate the distance of a jump for a given jumper
     *
     * @param jumper Jumper who's jump distance should be calculated
     * @return Current instance of {@link CompetitionManager}
     */
    private double calculateDistance(Jumper jumper) {
        CustomRandom customRandom = new CustomRandom();

        double windmeter = (customRandom.nextDouble(-3, 3)) * ((competition.getRamp().getHillsize() - 36) / 20);
        double jumpscore = ((addVariance(jumper.getSpeed(), -2, 2) / 20) + (addVariance(jumper.getPower(), -2, 2) / 20)) * (addVariance(jumper.getTiming(), -2, 2) / 10);
        double jumpmeter = ((2 * jumpscore) - 1) * competition.getRamp().getHillsize() * 0.1;

        double distance = competition.getRamp().getKpoint() + windmeter + jumpmeter;
        double difficulty = (Math.tanh((((distance / competition.getRamp().getHillsize()) / 1.3) * 5) - 3) + 1) * 5;

        double landingValue = addVariance(jumper.getLanding(), 0, 2);

        if (landingValue > difficulty)
            return distance;
        else
            return 0d;
    }

    /**
     * Prints the info of the current competition including current date and time,
     * the ramp data, how many competitors are attending and how many rounds
     * they will be jumping.
     */
    private void printInfo() {
        System.out.println("Ski Jumping competition " + new SimpleDateFormat("dd.MM.yyy 'at' HH:mm:ss z").format(new Date(System.currentTimeMillis())) + "\n");
        System.out.println("Today's Ramp: \n" + competition.getRamp().toString() + "\n");

        if (competition.getCompetitors().size() > 1)
            if (competition.getRounds() > 1)
                System.out.println("Today's competition has " + competition.getCompetitors().size() + " competitors and will go on for " + competition.getRounds() + " rounds!\n");
            else
                System.out.println("Today's competition has " + competition.getCompetitors().size() + " competitors and will go on for 1 round!\n");
        else
            if (competition.getRounds() > 1)
                System.out.println("Today's competition has 1 competitor and will go on for " + competition.getRounds() + " rounds!\n");
            else
                System.out.println("Today's competition has 1 competitor and will go on for 1 round!\n");
    }

    /**
     * Prints the result(s) of a jumper, formatting depends
     * on whether several rounds have been jumped or just one
     * and whether the competitor was disqualified or not.
     *
     * @param jumper  Jumper who's results should be printed
     * @param results Results of the given jumper
     */
    private void print(Jumper jumper, Results results) {
        if (competition.getRounds() > 1)
            if (!results.disqualified())
                printMultipleRounds(jumper, results);
            else
                printDisqualified(jumper);
        else
            if (!results.disqualified())
                printSingleRound(jumper, results);
            else
                printDisqualified(jumper);
    }

    /**
     * Prints the disqualified text depending on whether
     * several rounds have been jumped or just one.
     *
     * @param jumper Jumper who's disqualified text should be printed
     */
    private void printDisqualified(Jumper jumper) {
        if (competition.getRounds() > 1)
            System.out.printf("%s couldn't manage to hit any landing and got disqualified%n", jumper.getName());
        else
            System.out.printf("%s couldn't manage to hit the landing and got disqualified%n", jumper.getName());
    }

    /**
     * Used to keep track of how many jumpers' informations have
     * been printed already, to find out which rank they got.
     */
    private static int i = 0;

    /**
     * Used to print a given jumper's results when multiple rounds have been jumped
     *
     * @param jumper  Jumper who's results should be printed
     * @param results Results of a given jumper
     */
    private void printMultipleRounds(Jumper jumper, Results results) {
        i++;
        if (getRankString() != null)
            System.out.printf("%s's best jump was %.2fm and they got %s place! (", jumper.getName(), results.getBest(), getRankString());
        else
            System.out.printf("%s's best jump was %.2fm (", jumper.getName(), results.getBest());

        for (int j = 0; j < results.getResults().size(); j++) {
            if (results.getResult(j) == 0)
                System.out.print("--");
            else
                System.out.printf("%.2fm", results.getResult(j));

            if (j < results.getResults().size() - 1)
                System.out.print(", ");
        }

        System.out.println(")");
        if (i == 3)
            System.out.println("\n");
    }

    /**
     * Used to print a given jumper's results when only onie round has been jumped
     *
     * @param jumper  Jumper who's results should be printed
     * @param results Results of a given jumper
     */
    private void printSingleRound(Jumper jumper, Results results) {
        i++;
        if (getRankString() != null)
            System.out.printf("%s jumped %.2fm and got %s place!", jumper.getName(), results.getBest(), getRankString());
        else
            System.out.printf("%s jumped %.2fm", jumper.getName(), results.getBest());
        System.out.println();
        if (i == 3)
            System.out.println("\n");
    }

    /**
     * @return Formatted number of rank
     */
    private String getRankString() {
        return (i == 1) ? "1st" : (i == 2) ? "2nd" : (i == 3) ? "3rd" : null;
    }

    /**
     * Starts the competition. First, the info will be printed,
     * then every jumper will get a result for a number of rounds. Once all results
     * have been calculated, the sorted results will be printed.
     *
     * @see CompetitionManager#printInfo()
     * @see CompetitionManager#calculateDistance(Jumper)
     * @see Competition#addResult(Jumper, Double)
     * @see Competition#sortResults()
     * @see CompetitionManager#print(Jumper, Results)
     */
    public void start() {
        printInfo();

        for (int i = 0; i < competition.getRounds(); i++) {
            for (Jumper competitor : competition.getCompetitors()) {
                competition.addResult(competitor, calculateDistance(competitor));
            }
        }
        competition.sortResults().forEach(this::print);
    }
}
