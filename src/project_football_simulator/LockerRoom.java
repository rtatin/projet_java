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
    
    public void choiceUser(){
        boolean half=true;
        while (half==true){
            System.out.println("What do you want to do?\n-> Type 1 to change your players\n-> Type 2 to change the boost of the coach\n-> Type 3 to get back on field");
            Scanner obj = new Scanner(System.in);
            String num = obj.nextLine();
            int choice=Integer.parseInt(num);
            switch (choice) {
                case 1:
                    for(int i=0;i<2;i++){
                        if(teams.get(i).isPlayer==true){
                            changePlayers(teams.get(i));
                        }
                    }   break;
                case 2:
                    for(int i=0;i<2;i++){
                        if(teams.get(i).isPlayer==false){
                            teams.get(i).boostTeam();
                        }
                    }   break;
                case 3:
                    half=false;
                    break;
            }
        }
    }
    
    public static void changePlayers(Team team){ //fonction qui permet a l'utilisateur de modifier la composition de son equipe pendant la mi temps

        team.printTeamOnField(); //l'utilisateur a toujours la premiere equipe
        String numberPlayer="";
        System.out.println("What players would you like to change?");
        System.out.println("Write stop if you don't want or you're done");

        while (numberPlayer!="stop"){ //tant que le joueur n'ecrit pas stop
            System.out.println("Player to get off the field:");
            Scanner myObj = new Scanner(System.in);
            numberPlayer = myObj.nextLine(); 

            for(int i=0;i<11;i++){
                if(team.players.get(i).number==Integer.parseInt(numberPlayer)){
                    team.players.remove(team.players.get(i)); //si le joueur est dans players on l'enleve
                }
            System.out.println("Player to get on the field:");
            myObj = new Scanner(System.in);
            numberPlayer = myObj.nextLine(); //on rajoute un nouveau joueur
            team.players.add(team.FullTeam.get(Integer.parseInt(numberPlayer)));
            }
        }
    }
}
