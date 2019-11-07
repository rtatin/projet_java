/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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
        System.out.println("defence :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).favPos=="def"){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number );
            }
        }
    }
       
}
