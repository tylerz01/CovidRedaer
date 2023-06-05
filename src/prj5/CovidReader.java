package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Tyler Zhang (tylerz01), Fiifi Sackey(fns2963), Kai Nguyen (kainguyen)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Parses input from input file to create a LinkedList of states
 *
 * @author Fiifi Sackey, Tyler Zhang, Kai Nguyen
 *
 * @version 11/16/21
 *
 */
public class CovidReader {
    private SingleLinkedList<State> states;

    /**
     * Constructor for the class
     *
     * @param fileName
     *            name of the file
     * @throws FileNotFoundException
     *             exception to be thrown if file is not found
     */
    public CovidReader(String fileName) throws FileNotFoundException {
        states = readCovidFile(fileName);
        FatalityCalculator calculator = new FatalityCalculator(toArray(states));
        for (int i = 0; i < states.size(); i++) {
            calculator.sortAlpha();
            System.out.print(states.get(i).getName() + states.get(i).toString()
                + "=====");
            calculator.sortByCRF();
            System.out.print(states.get(i).toString() + "=====\n");
        }
    }


    /**
     * Creates an array of States
     *
     * @param entry
     *            the input that will be turned into an array
     * @return array of States
     */
    public State[] toArray(SingleLinkedList<State> entry) {
        State[] statesArr = new State[6];
        for (int i = 0; i < states.size(); i++) {
            statesArr[i] = entry.get(i);
        }
        return statesArr;

    }


    /**
     * gets all of the states as a linked list
     *
     * @return linked list of states
     */
    public SingleLinkedList<State> getAllStates() {
        return states;
    }


    /**
     * Gets a State
     *
     * @param str
     *            input of a state's name
     * @return a State
     */
    public State getState(String str) {
        if (str == states.get(0).getName()) {
            return states.get(0);
        }
        else if (str == states.get(1).getName()) {
            return states.get(1);
        }
        else if (str == states.get(2).getName()) {
            return states.get(2);
        }
        else if (str == states.get(3).getName()) {
            return states.get(3);
        }
        else if (str == states.get(4).getName()) {
            return states.get(4);
        }
        else if (str == states.get(5).getName()) {
            return states.get(5);
        }
        return null;
    }


    private SingleLinkedList<State> readCovidFile(String fileName)
        throws FileNotFoundException {
        states = new SingleLinkedList<State>();
        Scanner file = new Scanner(new File(fileName));
        int index = 0;
        while (file.hasNextLine()) {
            // String line = file.nextLine().replaceAll("( )+", " ");
            String line = file.nextLine();
            if (line.startsWith("State")) {
                // line = file.nextLine().replaceAll("( )+", " ");
                line = file.nextLine();
            }
            // String[] state = line.split(" ");
            String[] state = line.split(",");
            if (state.length != 11) {
                // throw new ParseException("Incorrect amount of covid values",
                // 0);
                continue;
            }
            String stateName = state[0];

            Race[] races = new Race[5];
            String[] raceNames = new String[5];
            raceNames[0] = "white";
            raceNames[1] = "black";
            raceNames[2] = "latinx";
            raceNames[3] = "asian";
            raceNames[4] = "other";

            for (int i = 0; i < 5; i++) {
                String cases = state[i + 1];
                String deaths = state[i + 6];
                if (cases.equals("NA")) {
                    cases = "-1";
                }
                if (deaths.equals("NA")) {
                    deaths = "-1";
                }
                Race race = new Race(raceNames[i], Integer.valueOf(cases),
                    Integer.valueOf(deaths));
                races[i] = race;
            }

            State newState = new State(stateName, races);
            states.add(newState);

        }
        file.close();
        return states;

    }

}
