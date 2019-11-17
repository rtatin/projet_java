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
    
    public Championship(ArrayList<Team> teams,ArrayList<Team> teamsInCompetition, ArrayList<Team> teamsEliminated ){ 
    this.teams=teams;
    this.teamsEliminated=teamsEliminated;
    this.teamsInCompetition=teamsInCompetition;
    }       
        
    
    public void createChampionship(){ 
        System.out.println("Number of teams in competition? Type 4,8 or 16\n");
        Scanner obj = new Scanner(System.in);
        String numT = obj.nextLine();
        int numberTeams=Integer.parseInt(numT);
        for(int i=0;i<numberTeams;i++){
            Team team = new Team();
            team.createFullTeam();
            this.teams.add(team);
            this.teams.get(i).idTeam=i; 
        }
        System.out.println("Type the number of the team you want to play with:\n");
        for(int i=0;i<teams.size();i++){
            System.out.println("Number "+(i+1)+":"+teams.get(i).name+"\n");
        }
        Scanner myObj = new Scanner(System.in);
        String num = myObj.nextLine();
        int numberChoice=Integer.parseInt(num);
        this.teams.get(numberChoice-1).isPlayer=true;
        
    }
    
    public void playChampionship(){
        int g=0;
        for(int i=0;i<this.teams.size();i++){
            this.teamsInCompetition.add(this.teams.get(i));
        }
        while(this.teamsInCompetition.size()==1){
            while(g>this.teamsInCompetition.size()){
            ArrayList <Team> equipes=new <Team> ArrayList();
            equipes.add(this.teamsInCompetition.get(g));
            equipes.add(this.teamsInCompetition.get(g+1));
            Referee arbitre=new Referee();
            Match match1 = new Match(equipes,arbitre);
            g++;
            g++;
            }
            for(int i=0;i<this.teamsInCompetition.size();i++){
                if(this.teams.get(i).loose==true){
                this.teamsEliminated.add(this.teams.get(i));
                this.teamsInCompetition.remove(this.teams.get(i));
                System.out.println(this.teamsInCompetition.size());
                }
        }
        g=0;
    
        } 
        System.out.println("victoire de "+ this.teamsInCompetition.get(0).name);
    }
    
}
