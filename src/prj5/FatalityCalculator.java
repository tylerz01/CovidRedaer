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
public class FatalityCalculator {
    private State[] states;

    /**
     * 
     * @param states
     *            The calculator takes in the state class
     */
    public FatalityCalculator(State[] states) {
        this.states = states;
    }


    /**
     * 
     * @param state
     *            Sort by alpha takes in the state class
     * @return Race[] array sorted in alphabetical order
     */
    private Race[] helpeSortAlpha(State state) {
        Race[] temp = new Race[5];
        temp[0] = state.getRace("asian");
        temp[1] = state.getRace("black");
        temp[2] = state.getRace("latinx");
        temp[3] = state.getRace("other");
        temp[4] = state.getRace("white");
        return temp;
    }


    /**
     * This goes through the array of
     * races and sets each race in
     * alphabetical order
     */
    public void sortAlpha() {
        for (int i = 0; i < 6; i++) {
            states[i].setRace(this.helpeSortAlpha(states[i]));
        }
    }


    /**
     * Helper method that sorts the races
     * by CFR
     * 
     * @param state
     *            This helper method takes in a state as the parameter
     * @return Race[] array of races sorted by CFR
     */
    private Race[] helperSortByCRF(State state) {
        Race[] temp = new Race[5];
        Race tempRace = new Race("", 0, 0);
        temp[0] = state.getRace("asian");
        temp[1] = state.getRace("black");
        temp[2] = state.getRace("latinx");
        temp[3] = state.getRace("other");
        temp[4] = state.getRace("white");
        for (int i = 0; i < 5; i++) {
            if (temp[i].calculatCFR() > temp[4].calculatCFR()) {
                tempRace = temp[4];
                temp[4] = temp[i];
                temp[i] = tempRace;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (temp[i].calculatCFR() >= temp[3].calculatCFR()) {
                tempRace = temp[3];
                temp[3] = temp[i];
                temp[i] = tempRace;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (temp[i].calculatCFR() >= temp[2].calculatCFR()) {
                tempRace = temp[2];
                temp[2] = temp[i];
                temp[i] = tempRace;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (temp[i].calculatCFR() > temp[1].calculatCFR()) {
                tempRace = temp[1];
                temp[1] = temp[i];
                temp[i] = tempRace;
            }
        }
        Race[] newRaces = new Race[5];
        int index = 0;
        for (int i = temp.length - 1; i > -1; i--) {
            newRaces[index] = temp[i];
            index++;
        }
        return newRaces;
    }


    /**
     * This goes through the array of
     * races and sets each race greatest to least
     * CFR value
     */
    public void sortByCRF() {
        for (int i = 0; i < 6; i++) {
            states[i].setRace(this.helperSortByCRF(states[i]));
        }
    }
}
