package dev.modex.skisprungsimulator;

import dev.modex.skisprungsimulator.utils.CompetitionManager;

/**
 * This program is used to simulate realistic results of a
 * ski-jumping competition. It firstly initializes a new
 * {@link CompetitionManager} which will handle everything.
 * To configure the competition command line arguments can
 * be taken, see {@link CompetitionManager#handleArgs(String[])}.
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public class Main {

    public static void main(String[] args) {
        new CompetitionManager().handleArgs(args).start();
    }
}
