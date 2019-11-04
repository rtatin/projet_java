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
    
    public int playersOnField(Team team){
    }
    public float atkTeam(int numberTeam){
        for(int i=0; i<10;i++){
            if (super.teams[numberTeam].players
        }
    }
    public void playingMatch(){
        this.time+=15;
        float atkTeam1=0;
    }
}
