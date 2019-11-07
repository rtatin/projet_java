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
public class Team {
    String name;
    Manager manager;
    ArrayList <Player> FullTeam;
    ArrayList <Player> players;
    Goalie goalie;

    
    public void createFullTeam(){
        String[] teamNames={"DFC","cftgh","losc"};
        this.name=teamNames[0];
        ArrayList <Player> newTeam= new <Player>ArrayList();
        for(int i=1;i<6;i++){
            Player newPlayer=new Player(i,(100 + (int)Math.random()* (100 - 60)),(40 + (int)Math.random()* (40 - 0)),"atk",false,Character.getRandomName(),Character.getRandomSurname(),(int)Math.random()* (40 - 16),"ang",this.name);
            newTeam.add(newPlayer);
        }
        for(int i=6;i<11;i++){
            Player newPlayer=new Player(i,(80 + (int)Math.random()* (80 - 60)),(80 + (int)Math.random()* (80 - 40)),"mid",false,Character.getRandomName(),Character.getRandomSurname(),(int)Math.random()* (40 - 16),"ang",this.name);
            newTeam.add(newPlayer);
        }
        for(int i=11;i<16;i++){
            Player newPlayer=new Player(i,(60 + (int)Math.random()* (40 - 0)),(100 + (int)Math.random()* (100 - 60)),"def",false,Character.getRandomName(),Character.getRandomSurname(),(int)Math.random()* (40 - 16),"ang",this.name);
            newTeam.add(newPlayer);
        }
        this.FullTeam=newTeam;
        Manager man=new Manager(5,Character.getRandomName(),Character.getRandomSurname(),(int)Math.random()* (60 - 40),"polonais",this.name);
        this.manager=man;
        Goalie goal=new Goalie(true,0,100,Character.getRandomName(),Character.getRandomSurname(),(int)Math.random()* (40 - 16),"ang",(60 + (int)Math.random()* (40 - 0)),this.name);
        this.goalie=goal;
        
    }
    
    public void createPlayingTeam(){
        System.out.println("Choose the disposition:\n -> 1 for 4-4-2\n -> 2 for 4-3-3\n -> 3 for 5-3-2");
        Scanner myObj = new Scanner(System.in);
        String num = myObj.nextLine();
        int numberChoice=Integer.parseInt(num);
        int defCount=4;
        int midCount=4;
        int atkCount=2;
        switch (numberChoice) {
            case 1:
                {
                    defCount=4;
                    midCount=4;
                    atkCount=2;
                    break;
                }
            case 2:
                {
                    defCount=4;
                    midCount=3;
                    atkCount=3;
                    break;
                }
            case 3:
                {
                    defCount=5;
                    midCount=3;
                    atkCount=2;
                    break;
                }
            default:
                break;
        }
        printFullTeam();
        System.out.println("Choose your "+defCount+" players in defense:");
        while (defCount>0){
            myObj = new Scanner(System.in);
            String numberPlayer = myObj.nextLine(); 
            int numPlayer = Integer.parseInt(numberPlayer);
            boolean alreadyInPlayer=false;
            for(int i=0;i<players.size();i++){
                if(players.get(i).number==numPlayer){
                    alreadyInPlayer=true;
                }
            }
            if((alreadyInPlayer==false) && (this.players.get(numPlayer-1).favPos=="def")){
                players.add(FullTeam.get(Integer.parseInt(numberPlayer)));
            }
        }
        while (midCount>0){
            myObj = new Scanner(System.in);
            String numberPlayer = myObj.nextLine(); 
            int numPlayer = Integer.parseInt(numberPlayer);
            boolean alreadyInPlayer=false;
            for(int i=0;i<players.size();i++){
                if(players.get(i).number==numPlayer){
                    alreadyInPlayer=true;
                }
            }
            if((alreadyInPlayer==false) && (this.players.get(numPlayer-1).favPos=="mid")){
                players.add(FullTeam.get(Integer.parseInt(numberPlayer)));
            }
        }
        while (atkCount>0){
            myObj = new Scanner(System.in);
            String numberPlayer = myObj.nextLine(); 
            int numPlayer = Integer.parseInt(numberPlayer);
            boolean alreadyInPlayer=false;
            for(int i=0;i<players.size();i++){
                if(players.get(i).number==numPlayer){
                    alreadyInPlayer=true;
                }
            }
            if((alreadyInPlayer==false) && (this.players.get(numPlayer-1).favPos=="atk")){
                players.add(FullTeam.get(Integer.parseInt(numberPlayer)));
            }
        }
    }
    public void printFullTeam(){
        System.out.println("teamname :"+this.name);
        System.out.println("manager :"+this.manager.name+" "+this.manager.surname);
        System.out.println("golie :"+this.goalie.name+" "+this.goalie.surname);
        
        System.out.println("attack :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).favPos=="atk"){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number );
            }
        }
        System.out.println("middle :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).favPos=="mid"){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number );
            }
        }
        System.out.println("defense :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).favPos=="def"){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number );
            }
        }
    }
    public void printTeamOnField(){
        System.out.println("Players on field:");
        System.out.println("goalie:"+this.goalie.name+" "+this.goalie.surname);  
        System.out.println("attack:");
        for (int g=0;g<11;g++){
            if((this.players.get(g).favPos=="atk") && (this.players.get(g).card!=2)){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number );
            }
        }
        System.out.println("middle:");
        for (int g=0;g<11;g++){
            if((this.FullTeam.get(g).favPos=="mid") && (this.players.get(g).card!=2)){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number );
            }
        }
        System.out.println("defense:");
        for (int g=0;g<11;g++){
            if((this.FullTeam.get(g).favPos=="def") && (this.players.get(g).card!=2)){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number );
            }
        }
        System.out.println("Players not playing");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).field==false){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number );
            }
        }
    }
       
}
