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
     * @param args the command line argumentss
     */
    public static void main(String[] args) {
        ArrayList<Team> teams= new <Team>ArrayList();
        ArrayList<Team> teamsInCompetition= new <Team>ArrayList();
        ArrayList<Team> teamsEliminated= new <Team>ArrayList();
        Championship coupe=new Championship(teams,teamsInCompetition,teamsEliminated);
        coupe.createChampionship();
        coupe.playChampionship();
    }
}
