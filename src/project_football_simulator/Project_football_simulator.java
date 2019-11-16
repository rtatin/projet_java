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
        Team teamm = new Team();
        Team teammm = new Team();
        teamm.createFullTeam();
        teamm.createPlayingTeamBot();
        teamm.printFullTeam();
        teamm.nationality();
        
        teammm.createFullTeam();
        teammm.createPlayingTeamBot();
        teammm.printFullTeam();
        teammm.nationality();
        
        Referee arbitredemerde=new Referee();
        arbitredemerde.generateReferee();
       
        ArrayList <Team> equipes=new <Team> ArrayList();
        equipes.add(teamm);
        equipes.add(teammm);
        
        Match match1 = new Match(equipes,90,arbitredemerde) ;
        match1.PlayingMatch();
    }
    
}
