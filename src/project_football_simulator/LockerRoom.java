/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;
import java.util.Scanner;

/**
 *
 * @author rtwam
 */
public class LockerRoom extends Match{
    boolean halfTime;

    public LockerRoom(Team[] teams, int time, int[] score, Referee ref, boolean halfTime) {
        super(teams, time, score, ref);
        this.halfTime=halfTime;
    }
    
    public static void changePlayers(Team[] teams){
        teams[0].printTeamOnField();
        String numberPlayer="";
        System.out.println("What players would you like to change?");
        System.out.println("Write stop if you don't want or you're done");
        
        while (numberPlayer!="stop"){
            System.out.println("Player to get off the field:");
            Scanner myObj = new Scanner(System.in);
            numberPlayer = myObj.nextLine(); 
            
            for(int i=0;i<11;i++){
                if(teams[0].players.get(i).number==Integer.parseInt(numberPlayer)){
                    teams[0].players.remove(teams[0].players.get(i));
                }
            System.out.println("Player to get on the field:");
            myObj = new Scanner(System.in);
            numberPlayer = myObj.nextLine(); 
            teams[0].players.add(teams[0].FullTeam.get(Integer.parseInt(numberPlayer)));
            }
        }
    }
}
