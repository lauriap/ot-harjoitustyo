# Mental Calculation Game - Specification

## Purpose and scope

This program is a mental calculation game made for people interested in practicing the calculation of basic arithmetic operations in their heads. The program is a desktop program with a simple graphical user interface. The performance of the users is tracked and stored in a file. The user is able to check his/her performance against other players from a "high score" tab.

## Users

The program allows the user to select a name in the beginning of the practice session. The standard user level is the only user type in the program as there is no need for administrative management in the program itself.

## User interface

### Start screen

![Menu](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/menu.PNG?raw=true.png)

**DONE**

### Player name and difficulty settings

![New game](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/new_game.PNG?raw=true)

**DONE**

### Game screen

![Game sceen](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/game_screen.PNG?raw=true)

**DONE, NEEDS IMPROVEMENT**

### High score screen

![High score](https://github.com/lauriap/ot-harjoitustyo/blob/master/documentation/high_score.PNG?raw=true)

**DONE, NEEDS IMPROVEMENT**

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

* The user sees an arithmetic problem and a text box to which an answer may be inputted **DONE**
* User input is tested and only valid answers are allowed. The answer can be input using the keyboard and submitted using 'enter' or the 'Enter' button on screen **ENTER NOT SUPPORTED YET**
* The user may quit to the menu screen at any time using a 'return to main menu' button **DONE**



**High score screen**

* The user sees a list of the players with highest scores based on the amount of points they have earned. 
* The point system works as follows: 
	* (100 points * d) for each correct answer where d is the number of digits in the problem

**DONE**

## Ideas for further development

* Adding more game modes, e.g. game of 10/20/50 problems with records for each game type
* Additional mathematical operations
* A proper sign in mechanism for all players
* Time constraints for answering
* A database to enable more detailed analysis of performance (e.g. % of correct answers by arithmetic operation type etc.) **DATABASE INCLUDED**

