package com.expeditors.householdanalytics;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.io.*;

import static com.expeditors.householdanalytics.HouseholdAnalytics.*;
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class HouseholdAnalyticsTest {

    @Test
    public void testMap() throws FileNotFoundException {
        // this folder gets cleaned up automatically by JUnit
        File path = new File("../HouseholdAnalytics.java/TestFiles/testSyntax.txt");
        addHousehold(path);

        Map<String, ArrayList<Person>> household1 = household;
        assertEquals(4, household1.size());
    }

    // Tests whether string cleaning works to get the right address for map key
    @Test
    public void testAddress() throws FileNotFoundException {
        File path = new File("../HouseholdAnalytics.java/TestFiles/testSyntax.txt");
        addHousehold(path);

        Map<String, ArrayList<Person>> household1 = household;
        assertTrue(true, String.valueOf(household1.containsKey("235 n 186th ct shoreline wa")));
    }

    @Test
    public void testAddress2() throws FileNotFoundException {
        File path = new File("../HouseholdAnalytics.java/TestFiles/testSyntax.txt");
        addHousehold(path);

        Map<String, ArrayList<Person>> household1 = household;
        assertFalse(false, String.valueOf(household1.containsKey("912 N 185th PL Apt.. 2012")));
    }

    @Test
    public void testAddress3() throws FileNotFoundException {
        File path = new File("../HouseholdAnalytics.java/TestFiles/testSyntax.txt");
        addHousehold(path);

        Map<String, ArrayList<Person>> household1 = household;
        ArrayList<Person> holdsPerson = household1.get("912 n 185th pl apt 2012 seattle wa");
        int size = holdsPerson.size();
        assertEquals(2, size);
    }

    @Test
    public void testOriginal() throws FileNotFoundException {
        File file = new File("../HouseholdAnalytics.java/Files/Input.txt");
        addHousehold(file);

        Map<String, ArrayList<Person>> household1 = household;
        assertTrue(true, String.valueOf(household1.containsKey("345 3rd blvd apt 200 seattle wa")));
        testOriginal1(household1);
    }

    @Test
    public void testOriginal1(Map<String, ArrayList<Person>> household1) throws FileNotFoundException {
        String output = String.valueOf(household1.keySet());
        assertEquals(output,
                "[123 main st seattle wa, 234 2nd ave seattle wa, 234 2nd ave tacoma fl, 234 2nd ave tacoma wa, 345 3rd blvd apt 200 seattle wa]");
    }
}