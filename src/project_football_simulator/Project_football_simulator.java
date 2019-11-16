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
        teammm.createFullTeam();
        teammm.createPlayingTeamBot();
        teammm.printFullTeam();
        
        Referee arbitredemerde=new Referee (2,true,100,"j","p", 40, "français");
        
        ArrayList <Team> equipes=new <Team> ArrayList();
        equipes.add(teamm);
        equipes.add(teammm);
        int scoredebut[]={0,0};
        Match match1 = new Match(equipes,90,scoredebut,arbitredemerde) ;
        match1.PlayingMatch();
    }
    
}
