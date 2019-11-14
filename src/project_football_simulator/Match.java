/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;

/**
 *
 * @author rtwam
 */
public class Match {
    Team[] teams;
    int time;
    int[] score;
    Referee ref;
    
    public Match(Team[] teams, int time, int[] score, Referee ref){
        this.teams=teams;
        this.time=time;
        this.score=score;
        this.ref=ref;
    }
    
    
    public float AtkTeam(int numberTeam){ //retourne l'attaque de l'équipe au complet
        float totalAtk=0;
        for(int i=0; i<10;i++){
            Player play=teams[numberTeam].players.get(i);
            if (play.field==true){ //pour tous les joueurs, additionne leur attaque entre eux s'ils sont sur le terrain
                totalAtk+=play.boostAttack;
            }
        }
        return totalAtk;
    }
    
    public float DefTeam(int numberTeam){ //meme fonction mais pour determiner la defense totale
        float totalDef=0;
        for(int i=0; i<10;i++){
            Player play=teams[numberTeam].players.get(i);
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
                ref.YellowCard(teams[i].players.get(j));
            }
        }    
    }
}
