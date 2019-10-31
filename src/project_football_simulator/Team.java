/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;
import java.util.ArrayList;

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
        ArrayList <Player> newTeam= new <Player>ArrayList();
        for(int i=1;i<6;i++){
            Player newPlayer=new Player(i,(100 + (int)Math.random()* (100 - 60)),(40 + (int)Math.random()* (40 - 0)),"atk","no",false,"benoi","bebe",40,"ang");
            newTeam.add(newPlayer);
        }
        for(int i=6;i<11;i++){
            Player newPlayer=new Player(i,(80 + (int)Math.random()* (80 - 60)),(80 + (int)Math.random()* (80 - 40)),"mid","no",false,"benoi","bebe",40,"ang");
            newTeam.add(newPlayer);
        }
        for(int i=11;i<16;i++){
            Player newPlayer=new Player(i,(60 + (int)Math.random()* (40 - 0)),(100 + (int)Math.random()* (100 - 60)),"def","no",false,"benoi","bebe",40,"ang");
            newTeam.add(newPlayer);
        }
        this.FullTeam=newTeam;
        String[] teamNames={"DFC","cftgh","losc"};
        this.name=teamNames[0];
        Manager man=new Manager(5,"borris","lemanager",42,"polonais");
        this.manager=man;
        Goalie goal=new Goalie(true,100,"Rodrigo","bg",20,"ang",(60 + (int)Math.random()* (40 - 0)));
        this.goalie=goal;
        
    }
}
