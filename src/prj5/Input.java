package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Tyler Zhang (tylerz01), Fiifi Sackey(fns2963), Kai Nguyen (kainguyen)

import java.io.FileNotFoundException;

/**
 * this is the input class used for running the Covid data
 *
 * @author Tyler Zhang
 * @version 2021.12.03
 */
public class Input {
    /**
     * this is the input method which run the entire system
     * Please make sure the args have the correct input file name
     * otherwise the system won't run.
     *
     * @param args
     *            args should be Cases_and_Deaths_by_race_CRDT_Sep2020.csv
     *            or what ever the name for the file needs to be.
     * @throws FileNotFoundException
     *             this throws the fileNotFoundException if file cannot be found
     */
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length < 0) {
        CovidReader reader = new CovidReader(
            "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        GUISpaceWindow window = new GUISpaceWindow(reader);
        }
        else {
            CovidReader reader = new CovidReader(
                args[0]);
            GUISpaceWindow window = new GUISpaceWindow(reader);   
        }
    }
}
