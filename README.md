# Mental Calculation Game (Ohjelmistotekniikka 2020)

## Description

Mental Calculation Game is a simple game for practicing mental calculation with basic arithmetic operations. The game enables the player to choose between specific arithmetic problems or a mix of different types. Addition, subtraction, multiplication and division are supported. The game is a desktop program with a GUI. This is a course excercise for learning the basics about the tools used in software development, including version control etc.

![Game example](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/game_example.png?raw=true)


## Mental calculation game - project links

[Documentation](https://github.com/lauriap/ot-harjoitustyo/tree/master/documentation)

[Specification](https://github.com/lauriap/ot-harjoitustyo/tree/master/documentation/specification.md)

[Architecture](https://github.com/lauriap/ot-harjoitustyo/tree/master/documentation/architecture.md)

[Work time tracker](https://github.com/lauriap/ot-harjoitustyo/tree/master/documentation/work_time_tracker.md)


## Known issues

* **ALL CALCULATIONS NOW SUPPORTED, BUT ONLY WITH INTEGERS.** Division "works", but the results don't include decimals. E.g. 6 / 7 = 0, 5 / 2 = 2.
* No database for scores set up yet.
* No high score tab yet.


## How to run


### Running the program

* Clone the repository to your computer
* In the terminal, navigate to /ot-harjoitustyo/MentalCalculation/ folder and write:

```
mvn compile exec:java -Dexec.mainClass=mentalcalculator.gui.Main
```

* Alternatively, you can open the project on NetBeans and run it there

### Running tests

All the commands are done in the terminal while in the following folder: /ot-harjoitustyo/MentalCalculation/

* Running the tests:

```
mvn test
```

* Creating a jacoco test report:

```
mvn test jacoco:report
```

* Creating a checkstyle report:

```
mvn jxr:jxr checkstyle:checkstyle
```




