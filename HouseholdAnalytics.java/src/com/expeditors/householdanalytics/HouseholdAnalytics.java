package com.expeditors.householdanalytics;

import java.util.*;
import java.io.*;

public class HouseholdAnalytics {

    // stores a household, and its occupants
    protected static final Map<String, ArrayList<Person>> household = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        // read each line from text file
        File file = new File("../HouseholdAnalytics.java/Files/Input.txt");
        //Scanner scan = new Scanner(file);

        // method to read, clean and manage data
        addHousehold(file);
        // filters object properties, prints to console and writes to a file
        filterAndWrite();
    }

    // reads each line and takes in information such as: firstname, lastname, address and age.
    // creates a person object for each household member using the data from the string input.
    // method also takes care of cleaning the strings.
    // parameter: file
    public static void addHousehold(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            // splits all strings at comma ONLY if it is surrounded by quotations
            String[] inputToken = input.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            // cleaning each token to get rid of quotations and punctuations.
            for (int i = 0; i < inputToken.length; i++) {
                String token = inputToken[i];
                // gets rid of punctuations and removes trailing whitespace
                inputToken[i] = token.replaceAll("\\p{Punct}", "").trim();
            }

            // get the address from the line, and concat it to a single string
            // this represents a single household
            String address = inputToken[2] + " " + inputToken[3] + " " + inputToken[4];
            address = address.toLowerCase(); // making all addresses lowercase
                                             // so map recognizes duplicates (a single household)

            // create a person object for each household member
            // and map each occupant (person) to their household address
            createPerson(inputToken, address);

        }
    }

    // Creates a new person object for each line of data read by scanner
    // adds data from inputToken array to the Person object
    // Maps the occupants (Person) to each unique address which is representative of a single household
    // parameters: String array of input tokens (data), String address key
    public static void createPerson(String[] inputToken, String address) {
        Person person = new Person(inputToken[0], inputToken[1], inputToken[2],
                inputToken[3], inputToken[4], inputToken[5]);

        ArrayList<Person> holdsPerson;
        if (household.containsKey(address)) {
            holdsPerson = household.get(address);
        } else {
            holdsPerson = new ArrayList<>();
        }
        holdsPerson.add(person);
        household.put(address, holdsPerson);
    }

    // method to filter for occupants over the age of 18, and sort them based on lastname and firstname
    // the data is then written to a text file in addition to being printed to the console.
    public static void filterAndWrite() {

        try {
            File file = new File("../HouseholdAnalytics.java/Files/Output.txt");
            FileWriter writeFile = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(writeFile);

            // for each address (household),
            // sort the contents of the list which stores the occupants living within that address
            for (String address : household.keySet()) {
                ArrayList<Person> holdsPerson;
                holdsPerson = household.get(address);

                // sorting objects based on last name, then first name, alphabetically
                Collections.sort(holdsPerson, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
                Collections.sort(holdsPerson,
                        Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));

                // gets the size of the array which hold the number occupants in a single household
                // includes persons 18 and below
                int countOccupants = holdsPerson.size();

                // writes to file
                writer.write("Household of address: " + address + ", Number of occupants: " + countOccupants +
                        "\nOccupants over the age of 18:");
                // writes to console
                System.out.println("Household of address: " + address + ", Number of occupants: " + countOccupants +
                        "\nOccupants over the age of 18:");

                // for each person in the household (arraylist)
                // if the person is over the age of 18, write their data to the console and in an output file.
                for (Person person : holdsPerson) {
                    if (person.isOver18()) {
                        writer.newLine();
                        writer.write("     " + person.getFirstName() + " " + person.getLastName() +
                                " " + person.fullAddress() + " " + person.getAge());
                        writer.flush();

                        // write output to console
                        System.out.println("     " + person.getFirstName() + " " + person.getLastName() +
                                " " + person.fullAddress() + " " + person.getAge());
                    }
                }
                // writing empty lines for a cleaner output
                writer.newLine();
                writer.write(" ");
                writer.newLine();
                System.out.println(" ");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

