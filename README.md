# Mental Calculation Game (Ohjelmistotekniikka 2020)

## Description

Mental Calculation Game is a simple game for practicing mental calculation with basic arithmetic operations. The game enables the player to choose between specific arithmetic problems or a mix of different types. Addition, subtraction, multiplication and division are supported. The game is a desktop program with a GUI. This is a course excercise for learning the basics about the tools used in software development, including version control etc.

## How to run

### Running the program

* Clone the repository to your computer
* In the terminal, navigate to /ot-harjoitustyo/MentalCalculation/ folder and write:

```
mvn compile exec:java -Dexec.mainClass=gui.Main
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


## Known issues

* **ONLY ADDITION PROBLEMS ARE SUPPORTED AT THIS STAGE.** Using other settings won't crash the program, but they will only yield addition problems.
* No database for scores set up yet.
* No high score tab yet.
* Low test coverage.

## Mental calculation game - project links

[Documentation](https://github.com/lauriap/ot-harjoitustyo/tree/master/documentation)

[Specification](https://github.com/lauriap/ot-harjoitustyo/tree/master/documentation/specification.md)

[Work time tracker](https://github.com/lauriap/ot-harjoitustyo/tree/master/documentation/work_time_tracker.md)

