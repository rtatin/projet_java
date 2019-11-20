/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Match, où toutes les méthodes utilisées pour le déroulement des matchs sont écrites
 * Elle prend en compte une arraylist composées de deux équipes, du temps du match, d'un arbitre et des scores
 * @author rtwam
 */
public class Match {
    protected ArrayList <Team> teams;
    protected int time=0;
    protected int[] score={0,0};
    protected int[] scorePenalties={0,0};
    protected Referee ref;
    protected boolean playerInGame;
    
    /**
     *
     * @param teams
     * @param ref
     */
    public Match(ArrayList <Team> teams, Referee ref){
        this.teams=teams;
        this.ref=ref;
    }
    
    protected boolean getPlayerInGame(){
        return this.playerInGame;
    }
    
    protected void setPlayerInGame(boolean player){
        this.playerInGame=player;
    }
    
    /**
     * Retourne l'attaque de l'équipe au complet
     * Additionne l'attaque finale de chaque membre de l'equipe sur le terrain
     * @param numberTeam
     * @return
     */
    public float AtkTeam(int numberTeam){ 
        float totalAtk=0;   
        for(int i=0; i<teams.get(numberTeam).getPlayers().size();i++){
            Player play=teams.get(numberTeam).getPlayers().get(i);       
                totalAtk+=play.getBoostAttackCoach();        
        }
        return totalAtk;
    }
    
    /**
     * Même fonction mais pour determiner la defense totale
     * @param numberTeam
     * @return
     */
    public float DefTeam(int numberTeam){ 
        float totalDef=0;
        for(int i=0; i<teams.get(numberTeam).getPlayers().size();i++){
            Player play=teams.get(numberTeam).getPlayers().get(i);
            if (play.getField()==true){
                totalDef+=play.getBoostDefenseCoach();
            }
        }
        return totalDef;
    }
    
    /**
     * Cette fonction est appelée chaque fois que 15min de match sont jouées
     * Fait le rapport entre l'attaque d'une équipe et la défense de l'autre
     * Ce rapport est comparé à un chiffre aléatoire, s'il est supérieur il y a but
     * Nous faisons la même chose pour les 2 équipes
     * @param atkTeam0
     * @param atkTeam1
     * @param defTeam0
     * @param defTeam1
     */
    public void increaseScore(float atkTeam0, float atkTeam1, float defTeam0, float defTeam1){ 
        float ratioAtkDef0=atkTeam0/defTeam1; 
        float ratioAtkDef1=atkTeam1/defTeam0;
        float scoreTeam0=(float)((float)Math.random()* (0.5 - 0.25)*ratioAtkDef0);
        float scoreTeam1=(float)((float)Math.random()* (0.5 - 0.25)*ratioAtkDef1);
        
        float rand=(float) ((float) Math.random()* (0.4 - 0.25)); 
        if (scoreTeam0>rand){ 
            this.score[0]++;
        }
        if (scoreTeam1>rand){ 
            this.score[1]++;
        }
    }
    
    /** 
     * Fonction qui permet de faire avancer le match de 15min
     * On appelle la fonction précédente qui permet d'incrémenter le score
     * De plus, chaque joueur peut potentiellement prendre un carton jaune 
     */
    public void PlayingMatch(){ 
        this.time+=15; 
        
        teams.get(0).getPlayers().get(2).printPlayer();
        float atkTeam0=AtkTeam(0);
        float atkTeam1=AtkTeam(1);
        float defTeam0=DefTeam(0);
        float defTeam1=DefTeam(1);
        increaseScore(atkTeam0, atkTeam1, defTeam0, defTeam1); 
        for (int i=0;i<2;i++){
            teams.get(i).nationality();
            for (int j=0;j<10;j++){
                ref.YellowCard(teams.get(i).getPlayers().get(j));
                teams.get(i).getPlayers().get(j).fatigue();
                
            }
        }
        this.ref.RecalulateSeverite();
        if(getPlayerInGame()==true){
            System.out.println(this.score[0]+" "+this.score[1]);
        }
    }
    
    /**
     * Fonction qui permet de jouer le match en entier
     * Tant que nous ne nous trouvons pas à la mi-temps, l'utilisateur doit appuyer sur espace pour continuer le match
     * Les matchs non joués par l'utilisateur sont joués directement avec cette fonction, sans afficher les lignes de texte
     * Au bout de 45min, les équipes sont envoyées dans les vestiaires
     * A la fin du match, nous appelons la méthode checkWin pour déterminer le gagnant 
     */
    public void FullMatch(){
        //this.teams.get(0).printFullTeam();
        //this.teams.get(0).printFullTeam();
        boolean playerPlaying=false;
        for (int i=0;i<teams.size();i++){
            if (this.teams.get(i).getIsPlayer()==true){
                playerPlaying=true;
            }
        }
        setPlayerInGame(playerPlaying);
        if(getPlayerInGame()==true){
            System.out.println("Beginning of the match between "+this.teams.get(0).getName()+" and "+this.teams.get(1).getName());
        }
        this.teams.get(0).boostTeam();
        this.teams.get(1).boostTeam();
        
        while(this.time!=45){
            for (int i=0;i<2;i++){
                if(this.teams.get(i).getIsPlayer()==true){
                    if(getPlayerInGame()==true){
                        System.out.println("Click enter to continue");
                        char c;
                        try{
                            c = (char)System.in.read();
                        }
                         catch(IOException ioe){
                           System.out.println("Error, click on enter to continue");
                           return;
                        }
                    } 
                }
            }
          
            PlayingMatch();
            if(getPlayerInGame()==true){
                System.out.println(this.time+"min de match");
            }
        }
        if(getPlayerInGame()==true){
            System.out.println("End of first half-time between "+this.teams.get(0).getName()+" and "+this.teams.get(1).getName());
        }
        for (int i=0;i<2;i++){
            if(teams.get(i).getIsPlayer()==true ){
                LockerRoom halfTime=new LockerRoom(this.teams,this.time,this.ref,true);
                halfTime.choiceUser();
            }
        }
        if(getPlayerInGame()==true){
            System.out.println("End of half-time between "+this.teams.get(0).getName()+" and "+this.teams.get(1).getName());
        }
        while(this.time!=90){
            for (int i=0;i<2;i++){
                if(getPlayerInGame()==true){
                    if(this.teams.get(i).getIsPlayer()==true){
                        System.out.println("Click enter to continue");
                        char c;
                        try{
                            c = (char)System.in.read();
                        }
                         catch(IOException ioe){
                           System.out.println("Error, click on enter to continue");
                           return;
                        }
                    }   
                }
            }
            PlayingMatch();
            if(getPlayerInGame()==true){
                System.out.println(this.time+"min de match");
            }
        }
        this.checkWin();
    }
        
    /**
     * Fonction qui détermine le gagnant
     * S'il y a égalité, nous faisons les prolongations, qui vont jusqu'à 120min et en but en or
     * Sinon, nous appelons la méthode penalties
     * @return
     */
    public int checkWin(){
        if(this.score[0]>this.score[1]) {
            System.out.println("Winning team is "+this.teams.get(0).getName()+"\nScore "+this.score[0]+":"+this.score[1] );
            this.teams.get(1).SetLoose(true);
            return (this.teams.get(0).getIdTeam());
        }
        else if(this.score[0]<this.score[1]) {
            System.out.println("Winning team is "+this.teams.get(1).getName()+"\nScore: "+this.score[0]+":"+this.score[1] );
            this.teams.get(0).SetLoose(true);
            return (this.teams.get(1).getIdTeam());
        }
        else if(this.score[0]==this.score[1]) {
            if(getPlayerInGame()==true){
                System.out.println("Draw "+"\nScore: "+this.score[0]+":"+this.score[1] );
                System.out.println("Overtime");
            }
            while((this.score[0]==this.score[1])&&(this.time!=120)){
                PlayingMatch();
                if(getPlayerInGame()==true){
                    System.out.println(this.time+"min de match");
                }
            }
            if(this.score[0]>this.score[1]) {
                System.out.println("Winning team is "+this.teams.get(0).getName()+" \nScore: "+this.score[0]+":"+this.score[1] );
                this.teams.get(1).SetLoose(true);
            return (this.teams.get(0).getIdTeam());}
            if(this.score[1]>this.score[0]){
                System.out.println("Winning team is "+this.teams.get(1).getName()+" \nScore: "+this.score[0]+":"+this.score[1] );
                this.teams.get(0).SetLoose(true);
            return (this.teams.get(1).getIdTeam());}
            if(this.score[0]==this.score[1]) {
                penalties();
                if(this.scorePenalties[0]>this.scorePenalties[1]) {
                System.out.println("Winning team is "+this.teams.get(0).getName()+" \nScore penalties: "+this.scorePenalties[0]+":"+this.scorePenalties[1] );
                this.teams.get(1).SetLoose(true);
                return (this.teams.get(0).getIdTeam());}
                if(this.scorePenalties[1]>this.scorePenalties[0]){
                    System.out.println("Winning team is "+this.teams.get(1).getName()+" \nScore penalties: "+this.scorePenalties[0]+":"+this.scorePenalties[1] );
                    this.teams.get(0).SetLoose(true);
                return (this.teams.get(1).getIdTeam());}
            }
        }
        return(100);
    }

    /**
     * Session de penalty
     * Fonction de la même manière qu'increase score, sauf que les équipes ont plus de chances de marquer
     * On compare alors le skill du gardien
     */
    public void penalties(){
        if(getPlayerInGame()==true){
            System.out.println("Beginning of penalties");
        }
        float atck1;
        float atck2;
        float deff1;
        float deff2;
        int i=this.teams.get(0).getPlayers().size()-1;
        while((this.scorePenalties[0]<5 && this.scorePenalties[1]<5)||(this.scorePenalties[0]==this.scorePenalties[1])){
                atck1=this.teams.get(0).getPlayers().get(i).getBoostAttackCoach();
                atck2=this.teams.get(1).getPlayers().get(i).getBoostAttackCoach();
                deff1=this.teams.get(0).getGoalie().getSkill();
                deff2=this.teams.get(1).getGoalie().getSkill();
                float scoreTeam0=(float)((float)Math.random()* (0.75)*(atck1/deff2));
                float scoreTeam1=(float)((float)Math.random()* (0.75)*(atck2/deff1));
                float rand=(float) ((float)Math.random()* (0.1)); //on cree un random
                if (scoreTeam0>rand){ //si le ratio est superieur, on incremente le score de la premiere equipe
                    this.scorePenalties[0]++;
                    
                }
                if (scoreTeam1>rand){ //si le ratio est superieur, on incremente le score de la premiere equipe
                    this.scorePenalties[1]++;
                    
                }
            i--;
            if(i<0){
                i=this.teams.get(0).getPlayers().size()-1;
            }
            if(getPlayerInGame()==true){
                System.out.println(this.scorePenalties[0]+" "+this.scorePenalties[1]);
            }
        }
    }
}