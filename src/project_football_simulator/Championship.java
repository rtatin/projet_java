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
public class Championship {
    ArrayList<Team> teams;
    ArrayList<Team> teamsInCompetition;
    ArrayList<Team> teamsEliminated;
    Match[] matchs;
    int[] results;
    
    public void createChampionship(){ 
        for(int i=0;i<4;i++){
            Team team = new Team();
            team.createFullTeam();
            teams.add(team);
        }
    }
    
}
