/*
 * Raphael Tatin / Théophile Vonck
 * Projet java 2019
 * Football manager simulator
 */
package project_football_simulator;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe appelee pendant la mi-temps
 * Les equipes presentes dans matchs sont envoyees ici
 * @author rtwam
 */
public class LockerRoom extends Match{
    boolean halfTime;

    /**
     * Constructeur de LockerRoom
     * @param teams
     * @param time
     * @param ref
     * @param halfTime
     */
    public LockerRoom(ArrayList <Team> teams, int time, Referee ref, boolean halfTime) {
        super( teams, ref);
        this.halfTime=halfTime;
    }
    
    /**
     * Pendant la mi-temps, dans le vestiaire, l'utilisateur a le choix entre 
     * 2 possibilites: faire des remplacements et choisir son boost
     * L'exception verifie si la reponse de l'utilsateur est valide
     */
    public void choiceUser(){
        boolean half=true;
        while (half==true){
            System.out.println("What do you want to do?\n-> Type 1 to change your players\n-> Type 2 to change the boost of the coach\n-> Type 3 to get back on field");
            Scanner obj = new Scanner(System.in);
            String num = obj.nextLine();
            int choice;
            try{
                choice=Integer.parseInt(num);
                if (1>choice || choice>3){
                    throw new Exception("Choice not in range, please select a number between 1 and 3");
                }
            }
            catch(NumberFormatException b){
                System.err.println("Please write a number between 1 and 3");
                choice=0;
            }
            catch(Exception b){
                System.err.println(b.getMessage());
                choice=0;
            }
            
            switch (choice) {
                case 1:
                    for(int i=0;i<2;i++){
                        if(teams.get(i).getIsPlayer()==true){
                            changePlayers();
                        }
                    }   break;
                case 2:
                    for(int i=0;i<2;i++){
                        if(teams.get(i).getIsPlayer()==true){
                            teams.get(i).boostTeam();
                        }
                    }   break;
                case 3:
                    half=false;
                    break;
            }
        }
    }
    
    /**
     * Ici, nous avons la fonction qui permet de changer ses joueurs
     * on demande a l'utilisateur de rentrer un numero de joueur qu'il veut 
     * faire sortir du terrain puis un autre numero du joueur qu'il veut faire 
     * rentrer
     * @param team
     */
    public void changePlayers(){ 
        int add=0;
        int tampon=0;
        String pos="";
        String stop="stop";
        for(int j=0;j<2;j++){
            if(this.teams.get(j).getIsPlayer()==true){
                this.teams.get(j).printTeamOnField();
                tampon=j;
            }
        }
        String numberPlayer="";
        System.out.println("What player would you like to change?");
        System.out.println("Write stop if you don't want or you're done");

        System.out.println("Player to get off the field:");
            Scanner myObj = new Scanner(System.in);
            numberPlayer = myObj.nextLine();     
            try{
                int number=Integer.parseInt(numberPlayer);
            }
            catch(NumberFormatException b){
                numberPlayer="stop";
                System.err.println("Not a player, stop replacing players");
            }
        while (!(numberPlayer.equals(stop))){ 
            
            for(int i=0;i<this.teams.get(tampon).getPlayers().size();i++){
                if(this.teams.get(tampon).getPlayers().get(i).getNumber()==Integer.parseInt(numberPlayer)){
                    pos=this.teams.get(tampon).getPlayers().get(i).getFavPos();
                    this.teams.get(tampon).getPlayers().get(i).setField(false);
                    this.teams.get(tampon).getPlayers().remove(this.teams.get(tampon).getPlayers().get(i)); 
                }
            }    
            System.out.println("Player to get on the field:");
            myObj = new Scanner(System.in);
            numberPlayer = myObj.nextLine();
            int number=Integer.parseInt(numberPlayer);

            if((this.teams.get(tampon).getFullTeam().get(number-1).getFavPos().equals(pos))&&(this.teams.get(tampon).getFullTeam().get(number-1).getField()==false)&&(this.teams.get(tampon).getFullTeam().get(number-1).card!=2)){
                this.teams.get(tampon).getFullTeam().get(number-1).setField(true);
                this.teams.get(tampon).getPlayers().add(this.teams.get(tampon).getFullTeam().get(number-1));
                this.teams.get(tampon).getPlayers().get(this.teams.get(tampon).getPlayers().size()-1).setField(true);
            }
            System.out.println("Player to get off the field:");
            System.out.println("Write stop if you don't want or you're done");
            numberPlayer = myObj.nextLine();
            try{
                number=Integer.parseInt(numberPlayer);
            }
            catch(NumberFormatException b){
                numberPlayer="stop";
                System.err.println("Not a player, stop replacing players");
            }
        }

    this.teams.get(tampon).printTeamOnField(); 
    }
}
    
