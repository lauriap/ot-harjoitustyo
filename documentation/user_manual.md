# User Manual


## Running the program using a .jar release

Download the latest [release](https://github.com/lauriap/ot-harjoitustyo/releases) of the application.

Save the .jar file to a folder. Navigate to the folder in the terminal and type 

```
java -jar MentalCalculation_final.jar
```

**Note:** The filename might be different if you are using an earlier release than the final 1.0 version.


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

in the terminal window while in the same folder as the .jar file. **OBS.** a 'db' folder is created to the folder from which you run execute the jar. Therefore it is advisable to copy the .jar file to a new folder first.
