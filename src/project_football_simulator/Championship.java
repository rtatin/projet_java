/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Fonction qui cree un championnat et le deroule
 * Nous avons des equipes en general, celles qui sont encore en competition et
 * celles qui sont eliminees
 * @author rtwam
 */
public class Championship {
    ArrayList<Team> teams;
    ArrayList<Team> teamsInCompetition;
    ArrayList<Team> teamsEliminated;
    Match[] matchs;
    
    /**
     *
     * @param teams
     * @param teamsInCompetition
     * @param teamsEliminated
     */
    public Championship(ArrayList<Team> teams,ArrayList<Team> teamsInCompetition, ArrayList<Team> teamsEliminated ){ 
    this.teams=teams;
    this.teamsEliminated=teamsEliminated;
    this.teamsInCompetition=teamsInCompetition;
    }       
        
    /**
     * Premiere fonction appelee lors du debut du jeu
     * L'utilisateur selectionne le nombre de joueurs qu'il veut voir dans son 
     * championnat (qui lui est a elimination directe)
     * Il peut aussi selectionner l'equipe avec laquelle il veut jouer
     */
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
        this.teams.get(numberChoice-1).isPlayer=false;//a changer en true ou false;
        
    }
    
    /**
     * Fonction du deroulement du championnat
     * Joue chacun des matchs jusqu'a ce qu'il n'y ai plus qu'une seule equipe
     * en liste
     * Les equipes perdantes son supprimees de teamsInCompetition pour etre placees
     * dans teamsEliminated
     */
    public void playChampionship(){
        
        int g=0;
        for(int i=0;i<this.teams.size();i++){
            this.teamsInCompetition.add(this.teams.get(i));
            if(this.teams.get(i).isPlayer==false){
            this.teams.get(i).createPlayingTeamBot();
            }
        }
        while(this.teamsInCompetition.size()>1){
            
            while(g<this.teamsInCompetition.size()-1){
//                    System.out.println("equipe encore en competition");
//                    for(int j=0;j<this.teamsInCompetition.size();j++){
//                    System.out.println(teamsInCompetition.get(j).name);
//                    System.out.println(teamsInCompetition.get(j).loose);
//                    //System.out.println("j="+j);
//                    }
            ArrayList <Team> equipes=new <Team> ArrayList();
            equipes.add(this.teamsInCompetition.get(g));
            g++;
            equipes.add(this.teamsInCompetition.get(g));
            g++;
            Referee arbitre=new Referee();
            Match match1 = new Match(equipes,arbitre);
                for (int i=0;i<2;i++){
                if(match1.teams.get(i).isPlayer==true ){
                match1.teams.get(i).createPlayingTeam();
                
                }
            }
            match1.FullMatch();
            }
            g=0;
            int tampon=this.teamsInCompetition.size();
            int id;
            for(int i=0;i<tampon;i++)
            {
                if(this.teamsInCompetition.get(i).loose==true){
                    this.teamsEliminated.add(this.teamsInCompetition.get(i));
                }
            }
            for(int k=0;k<this.teamsEliminated.size();k++){
                id=this.teamsEliminated.get(k).idTeam;
                for(int p=0;p<this.teamsInCompetition.size();p++)
                    {
                        if(this.teamsInCompetition.get(p).idTeam==id){
                            this.teamsInCompetition.remove(p);
                        }
                    }
            }
        
        } 
        
      
        System.out.println("victoire de "+ this.teamsInCompetition.get(0).name);
    }
    
}
