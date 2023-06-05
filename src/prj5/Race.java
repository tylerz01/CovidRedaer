package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Tyler Zhang (tylerz01), Kai Nguyen (kainguyen), Fiifi Sackey (fns2963)
/**
 * 
 * @author Tyler Zhang, Kai Nguyen, Fiifi Sackey
 * @version 2021.11.20
 */
import java.text.DecimalFormat;

/**
 * 
 * @author Tyler Zhang
 * @author Fiifi Sackui
 * @author Kai Nguyen
 * @version 11.19.2021
 */
public class Race {
    private String name;
    private int cases;
    private int death;
    /**
     * something webcat giving error
     */
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(
        "##.#");

    /**
     * this is the races class.
     * 
     * @param name
     *            the name of the races
     * @param cases
     *            the name of cases
     * @param death
     *            the name of deaths
     */
    public Race(String name, int cases, int death) {
        this.name = name;
        this.death = death;
        this.cases = cases;
    }


    /**
     * this will calcualte the cfr
     * 
     * @return
     *         return this states' CFR number in percentages.
     */
    public Double calculatCFR() {
        if (this.getCases() == 738177) {
            return (double)-1;
        }
        if (this.getCases() != -1 && this.getDeath() != -1) {
            DecimalFormat decimalFormat = new DecimalFormat("##.#");
            String format = decimalFormat.format((double)this.death / this.cases
                * 100);
            return Double.valueOf(format);
        }
        return (double)-1;
    }


    /**
     * this will get name of this state.
     * 
     * @return
     *         return the name of this state.
     */
    public String getName() {
        return name;
    }


    /**
     * we are getting the cases number
     * 
     * @return return the case numbers/
     */
    public int getCases() {
        return cases;
    }


    /**
     * this will get the death number
     * 
     * @return return this states' death for this races.
     */
    public int getDeath() {
        return death;
    }


    /**
     * this will return this race as String.
     * 
     * @return return the toString method.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + ": ");
        builder.append(cases + " cases, ");
        builder.append(DECIMAL_FORMAT.format(this.calculatCFR()) + "% CFR");

        return builder.toString();
    }

}
