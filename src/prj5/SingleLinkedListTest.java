package prj5;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Tyler Zhang (tylerz01)
import java.util.Arrays;
import student.TestCase;

/**
 * 
 * Tests the equals and toArray methods of a singly linked list.
 * 
 * @author Kai Nguyen kainguyen
 * 
 * @version 03/19/2017
 *
 */
public class SingleLinkedListTest extends TestCase {

    private SingleLinkedList<String> emptyListA;
    private SingleLinkedList<String> emptyListB;
    private SingleLinkedList<String> smallListA;
    private SingleLinkedList<String> smallListB;
    private SingleLinkedList<String> bigListA;
    private SingleLinkedList<String> bigListB;
    private String nullObject;

    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyListA = new SingleLinkedList<String>();
        emptyListB = new SingleLinkedList<String>();

        smallListA = new SingleLinkedList<String>();
        smallListB = new SingleLinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new SingleLinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new SingleLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }

        // to be explicit
        nullObject = null;
    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }


    /**
     * Tests the rest of the methods that haven't been tested yet
     */
    public void testAll() {
        try {
            smallListA.add(3, null);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            smallListA.add(-1, "apple");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            smallListA.add(10, "apple");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            smallListA.add(null);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            smallListA.remove(-2);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        SingleLinkedList<String> testList3 = new SingleLinkedList<String>();
        try {
            testList3.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        SingleLinkedList<String> testInfo = new SingleLinkedList<String>();
        try {
            testInfo.get(0);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            testList3.remove(2);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        SingleLinkedList<String> testList4 = new SingleLinkedList<String>();
        testList4.add("pop");
        try {
            testList4.remove(1);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        SingleLinkedList<String> testList = new SingleLinkedList<String>();
        testList.add("caitlin");
        testList.add(0, "caitlin");
        assertEquals(2, testList.size());
        SingleLinkedList<String> testList1 = new SingleLinkedList<String>();
        testList1.add("caitlin");
        testList1.add(1, "caitlin");
        assertEquals(2, testList1.size());
        SingleLinkedList<String> testList2 = new SingleLinkedList<String>();
        testList2.add(0, "caitlin");
        testList2.remove("caitlin");
        testList3.add("object");
        testList3.remove(0);
        assertEquals(0, testList3.size());
        testInfo.add("caitlin");
        assertEquals("caitlin", testInfo.get(0));
        assertTrue(testInfo.contains("caitlin"));
        assertFalse(testInfo.contains("why"));
        testInfo.clear();
        assertEquals(0, testInfo.size());
        testInfo.clear();
        assertEquals(-1, testInfo.lastIndexOf("caitlin"));
        testInfo.add("caitlin");
        assertEquals("{caitlin}", testInfo.toString());
        testInfo.add("why");
        assertEquals("{caitlin, why}", testInfo.toString());
        testInfo.add("caitlin");
        assertEquals(2, testInfo.lastIndexOf("caitlin"));
        assertEquals("caitlin", testInfo.get(2));
        assertTrue(testInfo.remove(2));
        testList4.remove(0);
        testList4.add("kai");
        testList4.add("is");
        testList4.add("dead");
        assertFalse(testList4.remove("good"));
        assertTrue(testList4.remove("kai"));
        testList4.add("kai");
        assertTrue(testList4.remove("dead"));
        SingleLinkedList<String> testTest = new SingleLinkedList<String>();
        testTest.add("julia");
        testTest.remove("julia");
        SingleLinkedList<String> testTest1 = new SingleLinkedList<String>();
        testTest1.add("julia");
        testTest1.add("kai");
        testTest1.remove("julia");
        SingleLinkedList<String> testTest2 = new SingleLinkedList<String>();
        assertFalse(testTest2.remove("test"));
        testTest2.add("help");
        assertTrue(testTest2.remove("help"));
        testTest2.add("help");
        testTest2.add("pls");
        assertTrue(testTest2.remove("pls"));
        testTest2.add("help");
        testTest2.add("pls");
        testTest2.add("come back");
        assertTrue(testTest2.remove("come back"));
        testTest2.add("I'm");
        testTest2.add("dying");
        assertTrue(testTest2.remove("dying"));
        assertFalse(testTest2.remove("nvm"));
    }

}
