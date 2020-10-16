package dev.modex.skisprungsimulator.enums;

import dev.modex.skisprungsimulator.objects.Jumper;
import dev.modex.skisprungsimulator.utils.CustomRandom;

import java.util.List;

/**
 * This enum is used to randomly generate first names for {@link Jumper}.
 * The values are based on a list of the most common first names in Austria.
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public enum FirstName {
    David,
    Maximilian,
    Alexander,
    Paul,
    Lukas,
    Leon,
    Elias,
    Tobias,
    Noah,
    Benjamin,
    Sebastian,
    Simon,
    Felix,
    Julian,
    Theodor,
    Jakob,
    Fabian,
    Samuel,
    Daniel,
    Emil,
    Valentin,
    Jonas,
    Filip,
    Moritz,
    Raphael,
    Adam,
    Luka,
    Adrian,
    Stefan,
    Konstantin,
    Luis,
    Oskar,
    Gabriel,
    Luca,
    Liam,
    Philipp,
    Viktor,
    Leo,
    Vincent,
    Florian,
    Jonathan,
    Matthias,
    Dominik,
    Ferdinand,
    Oliver,
    Ben,
    Lorenz,
    Constantin,
    Anton,
    Louis,
    Nico,
    Nicolas,
    Erik,
    Matteo,
    Arthur,
    Martin,
    Michael,
    Rafael,
    Theo,
    Benedikt,
    Leonard,
    Mateo,
    Jan,
    Aaron,
    Christian,
    Lucas,
    Finn,
    Leopold,
    Marcel,
    Noel,
    Marko,
    Niklas,
    Tim,
    Johannes,
    Josef,
    Thomas,
    Nikolas;

    /**
     * @return A random first name
     */
    public static FirstName random() {
        return List.of(values()).get(new CustomRandom().nextInt(values().length - 1));
    }
}
