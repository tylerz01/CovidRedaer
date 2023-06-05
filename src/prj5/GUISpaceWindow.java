package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Tyler Zhang (tylerz01), Fiifi Sackey(fns2963), Kai Nguyen (kainguyen)

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * this is the GUISpaceWindow Class which displays the Covid date
 *
 * @author Tyler Zhang
 * @version 2021.12.03
 */
public class GUISpaceWindow {
    private Window window;
    private FatalityCalculator fatalitycalculator;
    private State[] statesArray;
    private Button lastButton;

    /**
     * this is the window constrcutor
     * it will display all the button at the beginng
     *
     * @param calculatorVersionStates
     *            this is going to read the data and also provide us a
     *            linkedList state so we can have a reference.
     */
    public GUISpaceWindow(CovidReader calculatorVersionStates) {
        // this build the window/
        window = new Window("Project 5");
        Button quit = new Button("Quit");
        Button sortByAlpha = new Button("Sort by Alpha");
        Button sortByCFR = new Button("Sort by CFR");
        Button representS1 = new Button("Represent DC");
        Button representS2 = new Button("Represent GA");
        Button representS3 = new Button("Represent MD");
        Button representS4 = new Button("Represent NC");
        Button representS5 = new Button("Represent TN");
        Button representS6 = new Button("Represent VA");

        window.addButton(representS1, WindowSide.SOUTH);
        window.addButton(representS2, WindowSide.SOUTH);
        window.addButton(representS3, WindowSide.SOUTH);
        window.addButton(representS4, WindowSide.SOUTH);
        window.addButton(representS5, WindowSide.SOUTH);
        window.addButton(representS6, WindowSide.SOUTH);
        window.addButton(sortByAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortByCFR, WindowSide.NORTH);
        // ---------------------------------------------

        statesArray = calculatorVersionStates.toArray(calculatorVersionStates
            .getAllStates());
        fatalitycalculator = new FatalityCalculator(statesArray);
        quit.onClick(this, "clickedQuit");
        sortByAlpha.onClick(this, "clickedAlpha");
        sortByCFR.onClick(this, "clickedCFR");
        representS1.onClick(this, "clickedState");
        representS2.onClick(this, "clickedState");
        representS3.onClick(this, "clickedState");
        representS4.onClick(this, "clickedState");
        representS5.onClick(this, "clickedState");
        representS6.onClick(this, "clickedState");
    }


    /**
     * this is the clickedState method for when the State button is clicked
     *
     * @param stateButton
     *            this is the button being clicked on.
     */
    public void clickedState(Button stateButton) {
        lastButton = stateButton;
        this.updateGraph();
        String buttonState = stateButton.getTitle();
        String state = buttonState.substring(buttonState.length() - 2);
        printStates(state);

    }


    /**
     * this is the main calculations and graphing location
     * of the window.
     *
     * @param str
     *            this is the incoming string we are going to detect
     *
     */
    private void printStates(String str) {
        TextShape title = new TextShape(window.getGraphPanelWidth() / 2 - 100,
            10, findState(str).getName() + " Case Fatality Ratios by Race",
            Color.black);
        window.addShape(title);
        for (int i = 4; i >= 0; i--) {
            double data = findState(str).getRace(i).calculatCFR();
            int value = (int)(data * 10);
            // Name of the race
            TextShape textShape = new TextShape(window.getGraphPanelWidth() / 5
                * i + 50, window.getHeight() / 5 * 3 + 5, findState(str)
                    .getRace(i).getName(), Color.black);
            window.addShape(textShape);
            // this is the number
            TextShape numbers = new TextShape(window.getGraphPanelWidth() / 5
                * i + 50, window.getHeight() / 5 * 3 + 30, findState(str)
                    .getRace(i).calculatCFR().toString() + "%", Color.black);
            window.addShape(numbers);
            // this is the bar shape
            Shape bar = new Shape(window.getGraphPanelWidth() / 5 * i + 50,
                window.getHeight() / 5 * 3 - value, 20, value, Color.BLACK);
            window.addShape(bar);
            if (findState(str).getRace(i).calculatCFR().equals((double)-1)) {
                numbers.moveTo(bar.getX(), bar.getY() - 25);
                numbers.setText("NA");
            }
        }
    }


    /**
     * this is a helper method to return the state we need for
     * the state string.
     *
     * @param str
     *            this is the state we are going to use to find
     * @return
     *         return the state we are looking for.
     */
    private State findState(String str) {
        for (int i = 0; i < 6; i++) {
            if (statesArray[i].getName().equals(str)) {
                return statesArray[i];
            }
        }
        return null;
    }


    /**
     * this is the method for clicked alpha.
     *
     * @param sortByAlphaButton
     *            the button being clicked.
     */
    public void clickedAlpha(Button sortByAlphaButton) {
        if (lastButton == null) {
            // nothing to do
        }
        else {
            fatalitycalculator.sortAlpha();
            clickedState(lastButton);
        }
    }


    /**
     * this is the clcikedCFR buttton
     *
     * @param sortByCFR
     *            the button being clicked
     */
    public void clickedCFR(Button sortByCFR) {
        if (lastButton == null) {
            // nothing to do
        }
        else {
            fatalitycalculator.sortByCRF();
            clickedState(lastButton);
        }
    }


    /**
     * remove all shapes, then sort, then add all shapes.
     *
     * @return this will update the graph by delete everything so we can make
     *         changes.
     */
    private void updateGraph() {
        window.removeAllShapes();
    }


    /**
     * this is the clicked Quit button
     *
     * @param quitButton
     *            this is the button being clicked on.
     */
    public void clickedQuit(Button quitButton) {
        System.exit(0);
    }
}
