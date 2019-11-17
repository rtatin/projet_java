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
            if(this.teams.get(i).isPlayer==false){
            this.teams.get(i).createPlayingTeamBot();
            }
        }
        while(this.teamsInCompetition.size()>1){
            
            while(g<this.teamsInCompetition.size()){
//                    System.out.println("equipe encore en competition");
//                    for(int j=0;j<this.teamsInCompetition.size();j++){
//                    System.out.println(teamsInCompetition.get(j).name);
//                    System.out.println(teamsInCompetition.get(j).loose);
//                    //System.out.println("j="+j);
//                    }
            ArrayList <Team> equipes=new <Team> ArrayList();
            equipes.add(this.teamsInCompetition.get(g));
            equipes.add(this.teamsInCompetition.get(g+1));
            Referee arbitre=new Referee();
            Match match1 = new Match(equipes,arbitre);
                for (int i=0;i<2;i++){
                if(match1.teams.get(i).isPlayer==true ){
                match1.teams.get(i).createPlayingTeam();
                
                }
            }
            match1.FullMatch();
            g++;
            g++;
            }
            int tampon=this.teamsInCompetition.size();
//            for (Team var : teamsInCompetition){
//                System.out.println("azertyu");
//                if(var.loose==true){
//                    this.teamsEliminated.add(var);
//                    System.out.println("gxrg");
//                    this.teamsInCompetition.remove(var);
//                    System.out.println("gxrgghg");
//                    System.out.println(this.teamsInCompetition.size());
//                }
//                System.out.println("gxrg");
//            } 
            
            for(int i=0;i<tampon;i++)//probleme la
            {
                System.out.println("i="+i);
                if(this.teamsInCompetition.get(i).loose==true){
                    System.out.println("remove "+teamsInCompetition.get(i).players.get(0).boostAttack);
                    this.teamsEliminated.add(this.teamsInCompetition.get(i));
                    this.teamsInCompetition.remove(this.teamsInCompetition.get(i));
                    i=0;
                    tampon=this.teamsInCompetition.size();
                    System.out.println(this.teamsInCompetition.size()+"\n");
                }
            }
        
        g=0;
        } 
        System.out.println("victoire de "+ this.teamsInCompetition.get(0).name);
    }
    
}
