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
    
    
    public float atkTeam(int numberTeam){
        float totalAtk=0;
        for(int i=0; i<10;i++){
            Player play=teams[numberTeam].players.get(i);
            if (play.field==true){
                totalAtk+=play.attack;
            }
        }
        return totalAtk;
    }
    
    public float defTeam(int numberTeam){
        float totalDef=0;
        for(int i=0; i<10;i++){
            Player play=teams[numberTeam].players.get(i);
            if (play.field==true){
                totalDef+=play.defense;
            }
        }
        return totalDef;
    }
    
    public void playingMatch(){
        this.time+=15;
        float atkTeam1=atkTeam(0);
        float atkTeam2=atkTeam(1);
    }
}
