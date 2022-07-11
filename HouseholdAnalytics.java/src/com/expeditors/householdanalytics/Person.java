package com.expeditors.householdanalytics;

public class Person {

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private int age;

    public Person(String firstName, String lastName, String streetAddress,
                  String city, String state, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.age = Integer.parseInt(age);
    }

    // add getter and setter methods for each
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getAge() {
        return age;
    }

    public boolean isOver18() {
        return this.getAge() > 18;
    }

    public String fullAddress() {
        return this.streetAddress + ", " + this.city + ", " + this.state + ".";
    }
}
