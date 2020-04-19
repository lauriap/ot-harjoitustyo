
# Architecture description

## Logical classes

The architecture of the program is based on the idea of separation. The two logical classes, CalculationGenerator and CalculationGame have been kept separate from each other and they are created using the same set of parameters at the beginning of each game. This option was preferred instead of having a dependency from CalculationGame to CalculationGenerator where CalculationGenerator would have asked CalculationGame for details about the number of digits and operation type used for each calculation. The decision is also believed to increase performance, although it does not play a major role in a program of this size.

## Package diagram


![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/package_diagram.PNG?raw=true.png)


## Class diagram


![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/class_diagram.PNG?raw=true.png)



## Database tables


![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/database_tables.PNG?raw=true.png)


## Sequence diagrams


### Creating a game

![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/sequence_diagrams/create_game.PNG?raw=true.png)


### Playing a round

![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/sequence_diagrams/play_round.PNG?raw=true.png)


### Ending and saving a game

![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/sequence_diagrams/end_save_game.PNG?raw=true.png)


### Checking high scores

![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/sequence_diagrams/high_scores.PNG?raw=true.png)
