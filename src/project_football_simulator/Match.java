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
 *
 * @author rtwam
 */
public class Match {
    ArrayList <Team> teams;
    int time=0;
    int[] score={0,0};
    int[] scorePenalties={0,0};
    Referee ref;
    
    public Match(ArrayList <Team> teams, Referee ref){
        this.teams=teams;
        this.ref=ref;
    }
    
    
    public float AtkTeam(int numberTeam){ //retourne l'attaque de l'équipe au complet
        float totalAtk=0;
        
        for(int i=0; i<teams.get(numberTeam).players.size();i++){
            Player play=teams.get(numberTeam).players.get(i);
            if (play.field==true){ //pour tous les joueurs, additionne leur attaque entre eux s'ils sont sur le terrain
                totalAtk+=play.boostAttack;
                 
            }
            
        }
        //System.out.println(totalAtk);
        return totalAtk;
    }
    
    public float DefTeam(int numberTeam){ //meme fonction mais pour determiner la defense totale
        float totalDef=0;
        for(int i=0; i<10;i++){
            Player play=teams.get(numberTeam).players.get(i);
            if (play.field==true){
                totalDef+=play.boostDefense;
            }
        }
        return totalDef;
    }
    
    public void increaseScore(float atkTeam0, float atkTeam1, float defTeam0, float defTeam1){ //fonction qui permet de modifier le score
        float ratioAtkDef0=atkTeam0/defTeam1; //on fait un rapport attaque/defense entre les 2 equipes
        float ratioAtkDef1=atkTeam1/defTeam0;
        float scoreTeam0=(float)((float)Math.random()* (0.5 - 0.25)*ratioAtkDef0);
        float scoreTeam1=(float)((float)Math.random()* (0.5 - 0.25)*ratioAtkDef1);
        
        float rand=(float) ((float)Math.random()* (0.5 - 0.25)); //on cree un random
        if (scoreTeam0>rand){ //si le ratio est superieur, on incremente le score de la premiere equipe
            score[0]++;
        }
        if (scoreTeam1>rand){ //meme chose pour l'autre equipe
            score[1]++;
        }
    }
    
    public void PlayingMatch(){ //fonction qui permet de faire avancer le match
        this.time+=15; //on incremente le temps 
        float atkTeam0=AtkTeam(0);
        float atkTeam1=AtkTeam(1);
        float defTeam0=DefTeam(0);
        float defTeam1=DefTeam(1);
        increaseScore(atkTeam0, atkTeam1, defTeam0, defTeam1); //on appelle la fonction de changement de score
        for (int i=0;i<2;i++){
            for (int j=0;j<10;j++){
                ref.YellowCard(teams.get(i).players.get(j));
                teams.get(i).players.get(j).fatigue();
            }
        }
        System.out.println(this.score[0]+" "+this.score[1]);
    }
    
    public void FullMatch(){
        System.out.println("debut du match entre "+this.teams.get(0).name+" et "+this.teams.get(1).name);
        for (int i=0;i<2;i++){
        if(this.teams.get(i).isPlayer==true){
            this.teams.get(i).manager.teamManagement();
            }
        }
        while(this.time!=45){
            for (int i=0;i<2;i++){
                if(this.teams.get(i).isPlayer==true){
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
          
            PlayingMatch();
            System.out.println(this.time+"min de match");
            }
        System.out.println("End of first half-time between "+this.teams.get(0).name+" and "+this.teams.get(1).name);
        for (int i=0;i<2;i++){
            if(teams.get(i).isPlayer==true ){
            LockerRoom halfTime=new LockerRoom(this.teams,this.time,this.ref,true);
            halfTime.choiceUser();
            }
        }
        System.out.println("End of half-time between "+this.teams.get(0).name+" and "+this.teams.get(1).name);
        while(this.time!=90){
            for (int i=0;i<2;i++){
                if(this.teams.get(i).isPlayer==true){
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
            PlayingMatch();
            System.out.println(this.time+"min de match");
            }
        this.checkWin();
    }
        
    public int checkWin(){
        if(this.score[0]>this.score[1]) {
            System.out.println("victoire de "+this.teams.get(0).name+"score"+this.score[0]+":"+this.score[1] );
            return (this.teams.get(0).idTeam);
        }
        else if(this.score[0]<this.score[1]) {
            System.out.println("victoire de "+this.teams.get(1).name+"score"+this.score[0]+":"+this.score[1] );
            return (this.teams.get(1).idTeam);
        }
        else if(this.score[0]==this.score[1]) {System.out.println("draw "+"score"+this.score[0]+":"+this.score[1] );
        System.out.println("prolongation");
            while((this.score[0]==this.score[1])&&(this.time!=120)){
                PlayingMatch();
                System.out.println(this.time+"min de match");
            }
            if(this.score[0]>this.score[1]) {
                System.out.println("victoire de "+this.teams.get(0).name+"score"+this.score[0]+":"+this.score[1] );
                this.teams.get(1).loose=true;
            return (this.teams.get(0).idTeam);}
            if(this.score[1]>this.score[0]){
                System.out.println("victoire de "+this.teams.get(1).name+"score"+this.score[0]+":"+this.score[1] );
                this.teams.get(0).loose=true;
            return (this.teams.get(1).idTeam);}
            if(this.score[0]==this.score[1]) {
                penalties();
                if(this.scorePenalties[0]>this.scorePenalties[1]) {
                System.out.println("victoire de "+this.teams.get(0).name+"score penalty"+this.scorePenalties[0]+":"+this.scorePenalties[1] );
                this.teams.get(1).loose=true;
                return (this.teams.get(0).idTeam);}
                if(this.scorePenalties[1]>this.scorePenalties[0]){
                    System.out.println("victoire de "+this.teams.get(1).name+"score penalty"+this.scorePenalties[0]+":"+this.scorePenalties[1] );
                    this.teams.get(0).loose=true;
                return (this.teams.get(1).idTeam);}
            }
        }
        return(100);
    }
    public void penalties(){
        System.out.println("begin of penalty");
        float atck1;
        float atck2;
        float deff1;
        float deff2;
        int i=this.teams.get(0).players.size()-1;
        while((this.scorePenalties[0]<5 && this.scorePenalties[1]<5)){
                atck1=this.teams.get(0).players.get(i).boostAttack;
                atck2=this.teams.get(1).players.get(i).boostAttack;
                deff1=this.teams.get(0).goalie.skill;
                deff2=this.teams.get(1).goalie.skill;
                float scoreTeam0=(float)((float)Math.random()* (0.75)*(atck1/deff2));
                float scoreTeam1=(float)((float)Math.random()* (0.75)*(atck2/deff1));
                float rand=(float) (0.1+ (float)Math.random()* (0.2)); //on cree un random
                if (scoreTeam0>rand){ //si le ratio est superieur, on incremente le score de la premiere equipe
                    scorePenalties[0]++;
                    
                }
                if (scoreTeam1>rand){ //si le ratio est superieur, on incremente le score de la premiere equipe
                    scorePenalties[1]++;
                    
                }
            i--;
            if(i<0){
                i=this.teams.get(0).players.size()-1;
            }
            System.out.println(this.scorePenalties[0]+" "+this.scorePenalties[1]);
        }
    }
}

        

