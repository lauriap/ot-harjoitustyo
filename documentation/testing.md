# Testing documentation

The application has been tested with automatic unit and integration tests using JUnit and with manual system tests. All the test classes discussed below can be found [here](https://github.com/lauriap/ot-harjoitustyo/tree/master/MentalCalculation/src/test/java/mentalcalculatortest).

## Unit and integration tests

### Application logic

The application logic is contained within the mentalcalculator.generator and mentalcalculator.game packages. The respective test classes are CalculationGeneratorTest.java and CalculationGameTest.java. The files contain both unit and integration tests. Data storage is done in a separate DAO test class.

### DAO classes

The DAO test class DBCalculationGameDAOTest.java contains integration tests for the application's high score data storage functionality. The class uses the same database as the production environment, which enables testing for the existence of a database in the game folder. The integration tests in this class also cover some functionalities from the CalculationGame class that weren't included in the test class of the latter.

### Test coverage

Excluding the user interface, test coverage for the application is 96 %.

![Test coverage](https://raw.githubusercontent.com/lauriap/ot-harjoitustyo/master/documentation/test_coverage.png)

## System tests

System tests were done manually through the user interface.

### Installing and configuration

The application has been tested in Linux environment with Java OpenJDK version 11.0.7. No additional configuration is needed because the application creates a high score database if one does not exist already.

### Functionalities

All functionalities listed in the specification document have been checked. In addition to normal circumstances, the program has been tested with erroneous input from the user.


## Remaining quality issues

There is some repetitive code in some of the classes and certain classes should still be divided into smaller parts. Examples include the updateAnswers() method in CalculationGame.java and databaseExists() method in DBCalculationGameDAO.java.
