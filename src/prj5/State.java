package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Tyler Zhang (tylerz01), Kai Nguyen (kainguyen), Fiifi Sackey (fns2963)

/**
 * 
 * @author Tyler Zhang
 * @version 11.20.2021
 */
public class State {
    private String name;
    private Race[] races;

    /**
     * 
     * This is the constructor for the
     * state that takes in a string name
     * and a Race array for a race
     * 
     * @param name
     *            The name of the state
     * @param race
     *            The name of the race
     */
    public State(String name, Race[] race) {
        this.name = name;
        races = race;
    }


    /**
     * This sets the location and race
     * 
     * @param location
     *            location set as an integer
     * @param race
     *            Race class
     */
    public void setRace(int location, Race race) {
        races[location] = race;
    }


    /**
     * Getter method that retrieves the race
     * 
     * @param location
     *            This is the location of the race
     * @return This returns race for each location
     */
    public Race getRace(int location) {
        return races[location];
    }


    /**
     * Setter method for race array
     * 
     * 
     * @param racess
     *            This sets races equal
     *            to the parameter
     */
    public void setRace(Race[] racess) {
        this.races = racess;
    }


    /**
     * getter method that retrieves the race name
     * 
     * @param raceName
     *            This is the name of the races
     * @return the race if it matches the one in the array
     */
    public Race getRace(String raceName) {
        for (int i = 0; i < 5; i++) {
            if (races[i].getName().equals(raceName)) {
                return races[i];
            }
        }
        throw new IllegalArgumentException(
            "Race name not found(State class #1");
    }


    /**
     * Setter method that sets the name
     * 
     * 
     * @param newName
     *            This is the new name
     */
    public void setName(String newName) {
        this.name = newName;
    }


    /**
     * This is the getter method that retrieves
     * the name
     * 
     * @return the name as a string
     */
    public String getName() {
        return name;
    }


    /**
     * This is a getter method that retrieves
     * the the race cases
     * 
     * @param rC
     *            Takes in the races as a parameter
     * @return the race cases as an integer
     */
    public Integer getRaceCases(String rC) {
        if (rC.equals("NA")) {
            return -1;
        }
        for (int i = 0; i < 5; i++) {
            if (rC.equals(races[i].getName())) {
                return races[i].getCases();
            }
        }
        return -1;
    }


    /**
     * This is a getter method that retrieves
     * the the death cases
     * 
     * @param rC
     *            Takes in the death cases as a parameter
     * @return the death cases as an integer
     */
    public int getDeathCases(String dC) {
        if (dC.equals("NA")) {
            return -1;
        }
        for (int i = 0; i < 5; i++) {
            if (dC.equals(races[i].getName())) {
                return races[i].getDeath();
            }
        }
        return -1;
    }


    /**
     * this returns everything in string ford
     * 
     * @return the array of races to a string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            builder.append("\n");
            builder.append(races[i].toString());
        }
        builder.append("\n");

        return builder.toString();
    }
}
