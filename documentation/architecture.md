
# Architecture description

## Logical classes

The architecture of the program is based on the idea of separation. The two logical classes, CalculationGenerator and CalculationGame have been kept separate from each other and they are created using the same set of user-inputted parameters at the beginning of each game. This option was preferred instead of having a dependency from CalculationGame to CalculationGenerator where CalculationGenerator would have asked CalculationGame for details about the number of digits and operation type used for each calculation. The decision is also believed to increase performance, although it does not play a major role in a program of this size. 

## Application structure

The application has a three-level structure with the GUI being dependent on CalculationGenerator and CalculationGame classes. Storage for gamedata is done through a Database Access Object for which CalculationGame is dependent on.

![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/package_diagram.PNG?raw=true.png)


## Class diagram

The class diagram shows a slightly more detailed version of class dependencies.

![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/class_diagram.PNG?raw=true.png)


## User interface

The user interface has four separate scenes: Main menu, Game settings, Game screen and High scores. For illustrations of these scenes, please refer to the application [specification](https://github.com/lauriap/ot-harjoitustyo/tree/master/documentation/specification.md).

## Database tables


The database for storing high scores of individual games consists of a single table that tracks the game data for each individual player. Each game is unique and thus the same player name can be entered multiple times. Tracking of game data is done through ids which are invisible to the user.

![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/database_tables.PNG?raw=true.png)


## Main functionalities

The sequence diagrams give a coarse overview of the functioning of the main actions in the application.

### Creating a game

Creating a game shows how a new game is started. After the user has clicked on the New Game button in the main menu, a Game Settings screen is opened. The user inputs the desired game settings (including player name, operation type (e.g. "Addition") and the number of digits. Upon clicking start, the application creates a new instance of CalculationGenerator and CalculationGame based on the user's input. The game screen is also shown to the player once it has been set up, including fetching a new calculation using getCalculation().

![Menu](https://raw.githubusercontent.com/lauriap/ot-harjoitustyo/master/documentation/sequence_diagrams/create_game.png)


### Playing a round

After the user has inputted an answer and clicked the Submit button, the correctness of the answer is checked in CalculationGenerator. Based on the result (in this case the checkAnswer() method returns true), the text on the screen showing the number of right and total answers is updated  and a new calculation is retrieved to the screen. Finally, the previous answer is erased from the TextField and focus is given to the answer field to facilitate faster answering.

![Menu](https://raw.githubusercontent.com/lauriap/ot-harjoitustyo/master/documentation/sequence_diagrams/play_round.png)


### Ending and saving a game

Once the user has had enough and wants to end the game, s/he clicks Exit Game. The game data is then stored to the database using the DBCalculationGameDAO object. Finally, the menu screen is shown to the user.

![Menu](https://raw.githubusercontent.com/lauriap/ot-harjoitustyo/master/documentation/sequence_diagrams/end_save_game.png)


### Checking high scores

Once the user has clicked the High Scores button in the main menu, a list of high scores is retrieved from the database and arranged in a table format. Once the information is retrieved, the high score screen is shown.

![Menu](https://raw.githubusercontent.com/lauriap/ot-harjoitustyo/master/documentation/sequence_diagrams/high_scores.png)


## Weaknesses in the current architecture

The current architecture has some weak points that could be improved upon:

* Choosing between different operation types is now done by repetitive if-else structures. This could be replaced by a new class that would handle operation type generation and selection.
* The GUI could be differentiated further. Especially the start method is very long. All button actions could be turned into their own methods.



















