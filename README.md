# HouseholdAnalytics
## Roshani Shiwakoti

Prompt from Expeditors: 

Exercise Summary:
This Developer Design and Development exercise is used in the evaluation process for potential new hire candidates.  Please approach this exercise as you would approach a design and development project at work and include unit tests.  Any documentation or explanations about your approach and assumptions are helpful.  Please post your completed exercise on Github and send a link back to your recruiting contact at Expeditors when complete.

Requirements:
Write a standalone executable or script using the language of your preference (Java is the primary dev language at Expeditors).  Given the provided input data, print the expected output to the console or write to a text file.  Please also include Java unit tests that test your code.

Input data:
"Dave","Smith","123 main st.","seattle","wa","43"
"Alice","Smith","123 Main St.","Seattle","WA","45"
"Bob","Williams","234 2nd Ave.","Tacoma","WA","26"
"Carol","Johnson","234 2nd Ave","Seattle","WA","67"
"Eve","Smith","234 2nd Ave.","Tacoma","WA","25"
"Frank","Jones","234 2nd Ave.","Tacoma","FL","23"
"George","Brown","345 3rd Blvd., Apt. 200","Seattle","WA","18"
"Helen","Brown","345 3rd Blvd. Apt. 200","Seattle","WA","18"
"Ian","Smith","123 main st ","Seattle","Wa","18"
"Jane","Smith","123 Main St.","Seattle","WA","13"

Expected output: 
Each household and number of occupants, followed by:
Each First Name, Last Name, Address and Age sorted by Last Name then First Name where the occupant(s) is older than 18

# Assumptions

<ul> Data will be sent in a text file </ul>

<ul> There will not be an empty file </ul>

<ul> Tokens will be separated by commas, and enveloped in parenthesis </ul>

<ul> Each address is considered a household </ul>

<ul> All strings will be sent in the same format: Firstname, Lastname, address, city, state, age </ul>

<ul> All individuals are within the U.S. and follow the U.S. address system </ul>

# Description of Program

## HouseholdAnalytics.java

This java class houses the main entry point into the program. The file takes care of the computations. The program creates a HashMap which maps address keys to occupants of that address. It is assumed that each address accounts for a single household, as a household can consist of individuals with different surnames as well. Therefore, a John Smith and a Jake McDowell may be considered of the same household if they reside in the same address. It is also assumed that the addresses follow the U.S. address system. Each address key is mapped to an ArrayList of values which store individual person objects which represent the occupants.

### addHousehold(File file)

<ul> This function reads each line and takes in information such as: firstname, lastname, address and age. </ul>
<ul> Creates a person object for each household member using the data from the string input, and also takes care of cleaning the strings </ul>
<ul> Parameter: text input file </ul>

### createPerson(String[] inputToken, String address)

<ul> Creates a new person object for each line of data read by scanner </ul>
<ul> adds data from inputToken array to the Person object </ul>
<ul> Maps the occupants (Person) to each unique address which is representative of a single household </ul>
<ul> Parameters: String array of input tokens (data), String address key </ul>

### filterAndWrite()

<ul> This method filters for occupants over the age of 18, and sorts them based on lastname and firstname </ul>
<ul> The data is then written to a text file in addition to being printed to the console </ul>

## Person.java

This class stores data on each individual occupant of a single address. The class returns the individual's first name, last name, street address, city, state, age, and a boolean function which returns whether the individual is over the age of 18. For the purpose of the assignment, the class does not have any setters, as we are not going to be updating any data, and only retrieving it. 

## Input.txt

A text file which contains the original data given by the program assignment.

## Output.txt

A text file which stores the output of the program

## testSyntax.txt

A text file to store test cases
