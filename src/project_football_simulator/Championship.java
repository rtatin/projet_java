/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rtwam
 */
public class Championship {
    ArrayList<Team> teams;
    ArrayList<Team> teamsInCompetition;
    ArrayList<Team> teamsEliminated;
    Match[] matchs;
    int userTeamChoice;
    
    public void createChampionship(){ 
        Scanner obj = new Scanner(System.in);
        String numT = obj.nextLine();
        int numberTeams=Integer.parseInt(numT);
        System.out.println("Number of teams in competition? Type 4,8 or 16\n");
        for(int i=0;i<numberTeams;i++){
            Team team = new Team();
            team.createFullTeam();
            this.teams.get(i).idTeam=i;
            teams.add(team);
        }
        System.out.println("Type the number of the team you want to play with:\n");
        for(int i=0;i<teams.size();i++){
            System.out.println("Number "+i+":"+teams.get(i).name+"\n");
        }
        Scanner myObj = new Scanner(System.in);
        String num = myObj.nextLine();
        int numberChoice=Integer.parseInt(num);
        
    }
    
}
