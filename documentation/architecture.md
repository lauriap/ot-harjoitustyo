
# Architecture description

## Logical classes

The architecture of the program is based on the idea of separation. The two logical classes, CalculationGenerator and CalculationGame have been kep separate from each other and they are created using the same set of parameters at the beginning of each game. This option was preferred instead of having a dependency from CalculationGame to CalculationGenerator where CalculationGenerator would have asked CalculationGame for details about the number of digits and operation type used for each calculation. The decision is also believed to increase performance, although it does not play a major role in a program of this size.

## Package diagram


![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/package_diagram.PNG?raw=true.png)


## Class diagram


![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/class_diagram.PNG?raw=true.png)



## Database tables


![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/database_tables.PNG?raw=true.png)
