package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Tyler Zhang (tylerz01), Kai Nguyen (kainguyen), Fiifi Sackey (fns2963)

import student.TestCase;

/**
 * 
 * @author Kai Nguyen
 * @version 2021.11.19
 *
 */
public class RaceTest extends TestCase {
    private Race race;
    private Race race2;

    /**
     * SetUp
     */
    public void setUp() {
        race = new Race("White", 420, 69);
        race2 = new Race("White", -1, -1);
    }


    /**
     * Testing the calculator for CFR
     */
    public void testCalculatCFR() {
        assertEquals((double)16.4, race.calculatCFR(), 0.3);
        assertEquals((double)-1, race2.calculatCFR(), 0.1);
        race = new Race("the golden race", 738177, 0);
        assertEquals((double)-1, race.calculatCFR(), 0.3);
        race = new Race("the golden race", -1, -1);
        assertEquals((double)-1, race.calculatCFR(), 0.3);
        race = new Race("the golden race", 1, -1);
        assertEquals((double)-1, race.calculatCFR(), 0.3);
    }


    /**
     * Testing the getter method for name
     */
    public void testGetName() {
        assertEquals("White", race.getName());
    }


    /**
     * Testing the getter method for cases
     */
    public void testGetCases() {
        assertEquals(420, race.getCases(), 0.0);
    }


    /**
     * Testing the getter method for deaths
     */
    public void testGetDeaths() {
        assertEquals(69, race.getDeath(), 0.0);
    }


    /**
     * Testing the toString method
     */
    public void testToString() {
        assertEquals("White: 420 cases, 16.4% CFR", race.toString());
    }

}
