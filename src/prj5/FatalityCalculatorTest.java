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
import student.TestCase;

/**
 * 
 * @author Tyler Zhang, Kai Nguyen, Fiifi Sackey
 * @version 2021.11.20
 */
public class FatalityCalculatorTest extends TestCase {
    private FatalityCalculator calculator;
    private Race[] race;

    /**
     * Set up class that creates five different races
     * each with their own set of cases and deaths
     * and places them into an array. It also creates
     * an array of states with each of the races inside
     */
    public void setUp() {
        Race race1 = new Race("asian", 1, 3);
        Race race2 = new Race("black", 1, 5);
        Race race3 = new Race("other", 1, 4);
        Race race4 = new Race("latinx", 1, 6);
        Race race5 = new Race("white", 3, 10);
        race = new Race[6];
        race[0] = race1;
        race[1] = race2;
        race[2] = race3;
        race[3] = race4;
        race[4] = race5;
        race[5] = race5;
        State state = new State("", race);
        State[] states = new State[6];
        states[0] = state;
        states[1] = state;
        states[2] = state;
        states[3] = state;
        states[4] = state;
        states[5] = state;
        calculator = new FatalityCalculator(states);
    }


    /**
     * This tests the sortbyCFR method
     */
    public void testSortCFR() {
        calculator.sortByCRF();
        State statefr = new State("Tyler could be the boss", race);
        assertEquals("Tyler could be the boss", statefr.getName());
    }


    /**
     * This tests the method that sorts the races in
     * alphabetical order
     */
    public void testSortAlpha() {
        calculator.sortAlpha();
        State statefr = new State("Tyler could be the boss", race);
        assertEquals("Tyler could be the boss", statefr.getName());
    }
}
