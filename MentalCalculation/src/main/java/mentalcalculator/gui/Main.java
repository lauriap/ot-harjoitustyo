/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mentalcalculator.gui;

import java.sql.SQLException;
import mentalcalculator.dao.DBCalculationGameDAO;



/**
 * Main class that creates a database if not already created and launches the
 * GUI.
 * @author lauri
 */
public class Main {
    public static void main(String[] args) {
        
        DBCalculationGameDAO db = new DBCalculationGameDAO();
        if (!db.databaseExists()) {
            db.createDataBase();
            try {
                db.createScoreTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        MentalCalculationGUI.main(args);
    }
}
