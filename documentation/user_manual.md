# User Manual


## Running the program using a .jar release

Download the latest [release](https://github.com/lauriap/ot-harjoitustyo/releases) of the application.

Save the .jar file to a folder. Navigate to the folder in the terminal and type 

```
java -jar MentalCalculation_final.jar
```

**Note:** The filename might be different if you are using an earlier release than the full release 1.0.


## Running the program from the terminal


### Using Maven commands

* Clone the repository to your computer
* In the terminal, navigate to /ot-harjoitustyo/MentalCalculation/ folder and write:

```
mvn compile exec:java -Dexec.mainClass=mentalcalculator.gui.Main
```


### Using an executable jar

Alternatively, you can run the program by creating a jar file using

```
mvn package
```

in /ot-harjoitustyo/MentalCalculation/ folder. The jar file is created to /ot-harjoitustyo/MentalCalculation/target folder.

You can run the program using

```
java -jar MentalCalculation-1.0-SNAPSHOT.jar
```

in the terminal window while in the same folder as the .jar file. **OBS.** a 'db' folder is created to the folder from which you execute the jar. Therefore it is advisable to copy the .jar file to a new folder first.


## Using the application

For a visualization of the game screens, please refer to [the application specification](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/specification.md).

### Starting a new game

Click the "New game" button. This opens a window where you can customize game settings and insert your username (optional). The following settings are included:

* Defining a username
* Selecting an operation type: Addition, Subtraction, Multiplication, Division and All
* Selecting the number of digits you want to include, i.e. 2 digits gives you a game with calculation problems such as 24 + 51, 14 / 28 etc.

Once you have chosen the settings for the next game, click "Start game".

### Playing a round

Once you have solved the problem given to you, type your answer into the answer field in the upper half of the window. You can check your answer by clicking the "Answer" button. The "Correct answers this session:" text will update depending on the answer being correct or incorrect. 

When you have had enough of practice with the current settings, you can click the Exit game button to return to main menu. Your score will be updated into the high score database and it becomes visible in the high score screen if you reach the current top 10 list.

### Checking high scores

While in the main menu, click the High scores button to check the top 10 best players and their scores. The data can be sorted by clicking on the column names.

You can return to the main menu by pressing the Main Menu button.


