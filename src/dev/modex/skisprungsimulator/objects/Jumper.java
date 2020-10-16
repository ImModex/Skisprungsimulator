package dev.modex.skisprungsimulator.objects;

import dev.modex.skisprungsimulator.enums.FirstName;
import dev.modex.skisprungsimulator.enums.LastName;
import dev.modex.skisprungsimulator.utils.CustomRandom;
import dev.modex.skisprungsimulator.utils.Nameable;

/**
 * The {@link Jumper} class stores all the information of
 * a specific competitor of a ski-jumping competition.
 *
 * @author Modex / Thomas Spatz & Simon Garzon
 */
public class Jumper extends Nameable {

    /**
     * Age of the jumper
     */
    private int age;

    /**
     * Speed of the jumper
     */
    private double speed;

    /**
     * Jumping power of the jumper
     */
    private double power;

    /**
     * Timing of the jumper
     */
    private double timing;

    /**
     * Landing value of the jumper
     */
    private double landing;

    /**
     * Default constructor will initialize a {@link Jumper} with random
     * values. The name will be a random first name from {@link FirstName}
     * and a random last name from {@link LastName}. The age will be
     * a number in the range from 20 to 50. Speed, jumping power and timing
     * will each be a double ranging from 1 to 10. The landing value will
     * be a double in the range of 6 to 10.
     */
    public Jumper() {
        CustomRandom customRandom = new CustomRandom();
        setName(FirstName.random().toString() + " " + LastName.random().toString());
        setAge(customRandom.nextInt(20, 50));
        setSpeed(customRandom.nextDouble(1, 10));
        setPower(customRandom.nextDouble(1, 10));
        setTiming(customRandom.nextDouble(1, 10));
        setLanding(customRandom.nextDouble(6, 10));
    }

    /**
     * Used if a jumper was to be initialized manually
     *
     * @param name    Name of the jumper
     * @param age     Age of the jumper
     * @param speed   Speed of the jumper
     * @param power   Jumping power of the jumper
     * @param timing  Timing of the jumper
     * @param landing Landing value of the jumper
     * @throws IllegalArgumentException If the name is blank or empty, age is below 1 or either
     *                                  speed, jumping power, timing or landing value are not between 0 and 10
     */
    public Jumper(String name, int age, double speed, double power, double timing, double landing) {
        if (speed > 10d || speed < 0d || power > 10d || power < 0d || timing > 10d || timing < 0d || landing > 10d || landing < 0d || name.isEmpty() || name.isBlank() || age < 1)
            throw new IllegalArgumentException();

        setName(name);
        setAge(age);
        setSpeed(speed);
        setPower(power);
        setTiming(timing);
        setLanding(landing);
    }

    /**
     * @return Age of the jumper
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age Age of the jumper
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return Speed of the jumper
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed Speed of the jumper
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @return Jumping power of the jumper
     */
    public double getPower() {
        return power;
    }

    /**
     * @param power Jumping power of the jumper
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * @return Timing of the jumper
     */
    public double getTiming() {
        return timing;
    }

    /**
     * @param timing Timing of the jumper
     */
    public void setTiming(double timing) {
        this.timing = timing;
    }

    /**
     * @return Landing value of the jumper
     */
    public double getLanding() {
        return landing;
    }

    /**
     * @param landing Landing value of the jumper
     */
    public void setLanding(double landing) {
        this.landing = landing;
    }
}
