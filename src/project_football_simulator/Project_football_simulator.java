/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;

import java.util.ArrayList;

/**
 *
 * @author rtwam
 */
public class Project_football_simulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Team teamm = new Team();
        teamm.createFullTeam();
        teamm.printFullTeam();
    }
    
}
