/*
 * Raphael Tatin / Théophile Vonck
 * Projet java 2019
 * Football manager simulator
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
