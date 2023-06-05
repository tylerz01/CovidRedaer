package prj5;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Tyler Zhang (tylerz01), Fiifi Sackey(fns2963), Kai Nguyen (kainguyen)

import student.TestCase;

/**
 * 
 * @author Kai Nguyen
 * @version 2021.11.19
 *
 */
public class StateTest extends TestCase {
    private State state;
    private Race[] race;
    private Race race1;

    /**
     * Setup
     */
    public void setUp() {
        race1 = new Race("White", 420, 69);
        Race race2 = new Race("Black", 420, 69);
        Race race3 = new Race("Latina", 420, 69);
        race = new Race[5];
        race[0] = race1;
        race[1] = race2;
        race[2] = race3;
        state = new State("California", race);
    }


    /**
     * Testing the setter method for setRace()
     */
    public void testSetRace() {
        state.setRace(0, race1);
        assertEquals("White: 420 cases, 16.4% CFR", state.getRace(0)
            .toString());

    }


    /**
     * Testing the getter method for getRace()
     */
    public void testGetRace() {
        assertEquals("White: 420 cases, 16.4% CFR", state.getRace(0)
            .toString());
    }


    /**
     * Testing the setter method for setRace array
     */
    public void testSetRaceArray() {
        state.setRace(race);
        assertEquals(state.getRace(0), race1);
    }


    /**
     * Testing the getter method for getRace() array
     */
    public void testGetRaceArray() {
        assertEquals(race1, state.getRace("White"));
        Race raceNull1 = new Race("hshsh", -1, -1);
        race = new Race[5];
        race[0] = raceNull1;
        race[1] = raceNull1;
        race[2] = raceNull1;
        race[3] = raceNull1;
        race[4] = raceNull1;
        state = new State("", race);
        Exception exception = null;
        try {
            state.getRace("2134123512341243");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

    }


    /**
     * Testing the setter method for setName()
     */
    public void testSetName() {
        state.setName("Cali");
        assertEquals("Cali", state.getName());
    }


    /**
     * Testing the getter method for getName()
     */
    public void testGetName() {
        assertEquals("California", state.getName());
    }


    /**
     * Testing the getRaceCases method
     */
    public void testGetRaceCases() {
        Race raceNull1 = new Race("hshsh", -1, -1);
        Race raceNull = new Race("hshsh", -1, 0);
        race[3] = raceNull;
        state.getRaceCases("hshsh");
        state.getRaceCases("White");
        assertEquals(raceNull.toString(), "hshsh: -1 cases, -1% CFR");
        state.getRaceCases("NA");
        race = new Race[5];
        race[0] = raceNull1;
        race[1] = raceNull1;
        race[2] = raceNull1;
        race[3] = raceNull1;
        race[4] = raceNull1;
        state = new State("", race);
        state.getRaceCases("NAs");
    }


    /**
     * Testing the getDeathCases method
     */
    public void testGetDeathCases() {
        Race raceNull1 = new Race("hshsh", -1, -1);
        race[3] = raceNull1;
        assertEquals(-1, state.getDeathCases("hshsh"));
        assertEquals(69, state.getDeathCases("White"));
        assertEquals(-1, state.getDeathCases("NA"));
        race = new Race[5];
        race[0] = raceNull1;
        race[1] = raceNull1;
        race[2] = raceNull1;
        race[3] = raceNull1;
        race[4] = raceNull1;
        state = new State("", race);
        assertEquals(-1, state.getDeathCases("NAs"));
    }


    /**
     * test the toString method
     */
    public void testToString() {
        Race race4 = new Race("AA", 420, 69);
        Race race5 = new Race("BB", 420, 69);
        race[3] = race4;
        race[4] = race5;
        assertEquals(136, state.toString().length());
    }

}
