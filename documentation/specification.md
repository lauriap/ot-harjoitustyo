# Mental Calculation Game - Specification

## Purpose and scope

This program is a mental calculation game made for people interested in practicing the calculation of basic arithmetic operations in their heads. The program is a desktop program with a simple graphical user interface. High scores of the users are tracked and stored in a database. Top 10 high scores can be viewed in a high score window.

## Users

The program allows the user to select a name in the beginning of the practice session. The standard user level is the only user type in the program as there is no need for administrative management in the program itself.

## User interface

### Start screen

![Main Menu](https://raw.githubusercontent.com/lauriap/ot-harjoitustyo/master/documentation/game_screens/main_menu.png)

**DONE**

### Player name and difficulty settings

![New game](https://raw.githubusercontent.com/lauriap/ot-harjoitustyo/master/documentation/game_screens/settings.png)

**DONE**

### Game screen

![Game sceen](https://raw.githubusercontent.com/lauriap/ot-harjoitustyo/master/documentation/game_screens/game_screen.png)

**DONE**

### High score screen

![High scores](https://raw.githubusercontent.com/lauriap/ot-harjoitustyo/master/documentation/game_screens/high_score.png)

**DONE**

## Functionalities

**Start screen**

* The user is able to choose between three buttons
	* New game - starts a new game in a new window
	* High scores - opens a high score window
	* Quit - exits the program

**DONE**


**Player name and difficulty settings**

* The user gets to input a name. The previous name used to play is remembered 
* When starting a new game, difficulty settings are chosen. There are two options to choose from:
	* Arithmetic operations type (addition, subtraction, multiplication, division, all)
	* Number of digits (1-5)

**DONE**

**Game screen**

* The user sees an arithmetic problem and a text box to which an answer may be inputted 
* User input is tested and only valid answers are allowed. The answer can be input using the 'Answer' button on screen
* The user may quit to the menu screen at any time using a 'Exit game' button

**DONE**

**High score screen**

* The user sees a top 10 list of the players with highest scores. The rows are ordered by points in descending order. 
* The point system works as follows: 100 * d for each correct answer where d is the number of digits in the problem

**DONE**

## Ideas for further development

* Adding more game modes, e.g. game of 10/20/50 problems with records for each game type
* Additional mathematical operations
* A proper sign in mechanism for all players
* Time constraints for answering
* A database is a bit heavy for this kind of a program. It was done here for educational purposes, but a quicker way would be to use a save to file system

