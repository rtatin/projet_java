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
    protected ArrayList<Team> teams;
    protected ArrayList<Team> teamsInCompetition;
    protected ArrayList<Team> teamsEliminated;
    protected Match[] matchs;
    
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
        System.out.println("Number of teams in competition? Type 2, 4, 8 or 16\n");
        Scanner obj = new Scanner(System.in);
        String numT = obj.nextLine();
        int numberTeams=0;
        try{
            numberTeams=Integer.parseInt(numT);
            if (numberTeams!=2 && numberTeams!=4 && numberTeams!=8 && numberTeams!=16){
                throw new Exception("Size of competition impossible, 4 by default");
                }
            }
        catch(Exception b){
                System.err.println(b.getMessage());
                numberTeams=4;
            }
            
        for(int i=0;i<numberTeams;i++){
            Team team = new Team();
            team.createFullTeam();
            this.teams.add(team);
            this.teams.get(i).SetIdTeam(i); 
        }
        System.out.println("Type the number of the team you want to play with:\n");
        for(int i=0;i<teams.size();i++){
            System.out.println("Number "+(i+1)+":"+teams.get(i).getName()+"\n");
        }
       Scanner myObj = new Scanner(System.in);
        String num = myObj.nextLine();
        int numberChoice=0;
        try{
            numberChoice=Integer.parseInt(num);
            if (numberChoice<1 || numberChoice>teams.size()){
                throw new Exception("Number not available, 1 by default");
                }
            }
        catch(Exception b){
            System.err.println(b.getMessage());
            numberChoice=1;
        }
        
        this.teams.get(numberChoice-1).SetIsPlayer(true);//a changer en true ou false;
        
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
            if(this.teams.get(i).getIsPlayer()==false){
            this.teams.get(i).createPlayingTeamBot();
            }
        }
        while(this.teamsInCompetition.size()>1){
            
            while(g<this.teamsInCompetition.size()-1){               
            ArrayList <Team> equipes=new <Team> ArrayList();
            equipes.add(this.teamsInCompetition.get(g));
            g++;
            equipes.add(this.teamsInCompetition.get(g));
            g++;
            Referee arbitre=new Referee();
            arbitre.generateReferee();
            Match match1 = new Match(equipes,arbitre);
                for (int i=0;i<2;i++){
                if(match1.teams.get(i).getIsPlayer()==true ){
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
                if(this.teamsInCompetition.get(i).getIsLoose()==true){
                    this.teamsEliminated.add(this.teamsInCompetition.get(i));
                }
            }
            for(int k=0;k<this.teamsEliminated.size();k++){
                id=this.teamsEliminated.get(k).getIdTeam();
                for(int p=0;p<this.teamsInCompetition.size();p++)
                    {
                        if(this.teamsInCompetition.get(p).getIdTeam()==id){
                            this.teamsInCompetition.remove(p);
                       
                        }
                    }
            }
            System.out.println("Teams still in competition:\n");
                for(int j=0;j<this.teamsInCompetition.size();j++){
                    System.out.println("- "+teamsInCompetition.get(j).getName()+"\n");
                //System.out.println("j="+j);
                }
        
        } 
        
      
        System.out.println("Winner of the championship is "+ this.teamsInCompetition.get(0).getName());
    }
    
}
