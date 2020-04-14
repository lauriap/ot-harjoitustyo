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
* **Database for high scores now functioning, but with limitations.** Showing all results instead of ordered top 10. Rank numbers missing.
* High score tab set up, but points system still not complete.
* Test coverage needs to be increased (will be done next week).


## How to run


### Running the program

* Clone the repository to your computer
* In the terminal, navigate to /ot-harjoitustyo/MentalCalculation/ folder and write:

```
mvn compile exec:java -Dexec.mainClass=mentalcalculator.gui.Main
```

### Creating an executable jar

Alternatively, you can run the program by creating a jar file using

```
mvn package
```

in /ot-harjoitustyo/MentalCalculation/ folder. The jar file is created to /ot-harjoitustyo/MentalCalculation/target folder.

You can run the program using

```
java -jar MentalCalculation-1.0-SNAPSHOT.jar
```

in the terminal window while in the same folder as the .jar file. **OBS.** a 'db' folder is created to the folder from which you run execute the jar.

## Running tests

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





