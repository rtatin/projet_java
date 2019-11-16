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
public class LockerRoom extends Match{
    boolean halfTime;

    public LockerRoom(ArrayList <Team> teams, int time, Referee ref, boolean halfTime) {
        super( teams, time, ref);
        this.halfTime=halfTime;
    }
    
    public static void changePlayers(ArrayList <Team> teams){ //fonction qui permet a l'utilisateur de modifier la composition de son equipe pendant la mi temps
        for (int j=0;j<2;j++){
            if(teams.get(j).isPlayer==true){
            teams.get(j).printTeamOnField(); //l'utilisateur a toujours la premiere equipe
            String numberPlayer="";
            System.out.println("What players would you like to change?");
            System.out.println("Write stop if you don't want or you're done");

            while (numberPlayer!="stop"){ //tant que le joueur n'ecrit pas stop
                System.out.println("Player to get off the field:");
                Scanner myObj = new Scanner(System.in);
                numberPlayer = myObj.nextLine(); 

                for(int i=0;i<11;i++){
                    if(teams.get(0).players.get(i).number==Integer.parseInt(numberPlayer)){
                        teams.get(0).players.remove(teams.get(0).players.get(i)); //si le joueur est dans players on l'enleve
                    }
                System.out.println("Player to get on the field:");
                myObj = new Scanner(System.in);
                numberPlayer = myObj.nextLine(); //on rajoute un nouveau joueur
                teams.get(0).players.add(teams.get(0).FullTeam.get(Integer.parseInt(numberPlayer)));
                    }
                }
            teams.get(j).manager.teamManagement();
            }
        }
    }
}
