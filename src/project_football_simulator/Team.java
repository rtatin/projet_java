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
    ArrayList <Player> FullTeam; //correspond à l'equipe complete
    ArrayList <Player> players; //correspond aux joueurs qui sont sur le terrain 
    Goalie goalie;

    
    public void createFullTeam(){ //permet de generer une equipe complete de joueurs
        String[] teamNames={"DFC","cftgh","losc"};
        this.name=teamNames[0];
        ArrayList <Player> newTeam= new <Player>ArrayList(); //on créé une arraylist de joueurs 
        for(int i=1;i<6;i++){ //dans chaque equipe, on cree 5 joueurs en attaques, avec des stats aléatoires qu'on place dans l'arraylist
            Player newPlayer=new Player(i,(100 + (int)Math.random()* (100 - 60)),(40 + (int)Math.random()* (40 - 0)),"atk",false,Character.getRandomName(),Character.getRandomSurname(),(int)Math.random()* (40 - 16),"ang",this.name);
            newTeam.add(newPlayer);
        }
        for(int i=6;i<11;i++){ //puis 5 milieux de terrain
            Player newPlayer=new Player(i,(80 + (int)Math.random()* (80 - 60)),(80 + (int)Math.random()* (80 - 40)),"mid",false,Character.getRandomName(),Character.getRandomSurname(),(int)Math.random()* (40 - 16),"ang",this.name);
            newTeam.add(newPlayer);
        }
        for(int i=11;i<16;i++){ //et enfin 5 defenseurs 
            Player newPlayer=new Player(i,(60 + (int)Math.random()* (40 - 0)),(100 + (int)Math.random()* (100 - 60)),"def",false,Character.getRandomName(),Character.getRandomSurname(),(int)Math.random()* (40 - 16),"ang",this.name);
            newTeam.add(newPlayer);
        }
        this.FullTeam=newTeam; //on place le newTeam dans l'array correspondant a l'equipe complete de joueurs
        Manager man=new Manager(5,Character.getRandomName(),Character.getRandomSurname(),(int)Math.random()* (60 - 40),"polonais",this.name);
        this.manager=man;
        Goalie goal=new Goalie(true,0,100,Character.getRandomName(),Character.getRandomSurname(),(int)Math.random()* (40 - 16),"ang",(60 + (int)Math.random()* (40 - 0)),this.name);
        this.goalie=goal;
    }
    
    public void createPlayingTeamBot(){
        ArrayList <Player> newPlayer=new <Player>ArrayList();
        int numberChoice=(int)Math.random()* (2 - 0);
        int defCount=4;
        int midCount=4;
        int atkCount=2;
        switch (numberChoice) { //3 cas differents
            case 0: //si le random donne 0 on prend une disposition 4-4-2
                {
                    defCount=4;
                    midCount=4;
                    atkCount=2;
                    break;
                }
            case 1: //si 1 4-3-3
                {
                    defCount=4;
                    midCount=3;
                    atkCount=3;
                    break;
                }
            case 2: //si 2 5-3-2
                {
                    defCount=5;
                    midCount=3;
                    atkCount=2;
                    break;
                }
            default:
                break;
        }
        
        for (int j=0;j<atkCount;j++){
            newPlayer.add(FullTeam.get(j));
            FullTeam.get(j).field=true;
        }
        for (int j=5;j<midCount+5;j++){
            newPlayer.add(FullTeam.get(j));
            FullTeam.get(j).field=true;

        }
        for (int j=10;j<defCount+10;j++){
            newPlayer.add(FullTeam.get(j));
            FullTeam.get(j).field=true;

        }
        this.players=newPlayer;
    }
    
    public void createPlayingTeam(){ //permet a l'utilisateur de choisir les joueurs qui seront sur le terrain
        ArrayList <Player> newPlayer=new <Player>ArrayList(); //on cree une arraylist pour les joueurs
        System.out.println("Choose the disposition:\n -> 1 for 4-4-2\n -> 2 for 4-3-3\n -> 3 for 5-3-2");
        Scanner myObj = new Scanner(System.in);
        String num = myObj.nextLine();
        int numberChoice=Integer.parseInt(num);
        int defCount=4;
        int midCount=4;
        int atkCount=2;
        switch (numberChoice) { //comme la fonction precedente, mais l'utilisateur choisit lui-meme sa disposition
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
        
        int count=0;
        String pos="";
        
        for (int j=0;j<3;j++){ //la boucle permet d'abord de selectionner les defenseurs, puis les milieux et enfin les attaquants
            switch (j) {
                case 0: //on recupere le nb de defenseurs
                    {
                        System.out.println("Choose your "+defCount+" players in defense:");
                        count=defCount;
                        pos="def";
                        
                        break;
                    }
                case 1: //de milieux de terrain
                    {
                        System.out.println("Choose your "+midCount+" players in mid:");
                        count=midCount;
                        pos="mid";
                        break;
                    }
                case 2: //d'attaquants
                    {
                        System.out.println("Choose your "+atkCount+" players in atk:");
                        count=atkCount;
                        pos="atk";
                        break;
                    }
                default:
                    break;
            }
            
            while (count>0){ //pour chaque position
                myObj = new Scanner(System.in); //on demande a l'utilisateur de ren
                String numberPlayer = myObj.nextLine(); 
                int numPlayer = Integer.parseInt(numberPlayer); //convertit le numero du joueur rentre en int
                boolean alreadyInPlayer=false; //creation d'un bool si le joueur est deja sur le terrain
                for(int i=0;i<newPlayer.size();i++){
                    if(newPlayer.get(i).number==numPlayer){//si on le trouve dans players, passe le bool en true
                        alreadyInPlayer=true;
                    }
                }
                if((alreadyInPlayer==false)&&(this.FullTeam.get(numPlayer-1).favPos==pos)){ //si le joueur n'est pas sur le terrain et on choisit un joueur avec la bonne position
                    newPlayer.add(FullTeam.get(numPlayer-1)); //on l'ajoute dans l'arraylist de joueurs
                    FullTeam.get(numPlayer-1).field=true; //sa caracteristique onField passe alors en true
                    count--; //on decremente le compteur
                    
                }
                System.out.println(newPlayer);
                
            }
            
        }
        this.players=newPlayer;
    }
    public void printFullTeam(){ //permet d'afficher l'équipe au complet
        System.out.println("teamname :"+this.name);
        System.out.println("manager :"+this.manager.name+" "+this.manager.surname);
        System.out.println("golie :"+this.goalie.name+" "+this.goalie.surname);
        
        System.out.println("attack :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).favPos=="atk"){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number+" "+this.FullTeam.get(g).favPos );
            }
        }
        System.out.println("middle :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).favPos=="mid"){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number+" "+this.FullTeam.get(g).favPos );
            }
        }
        System.out.println("defense :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).favPos=="def"){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number+" "+this.FullTeam.get(g).favPos );
            }
        }
    }
    
    public void printTeamOnField(){ //permet d'afficher seulement les joueurs sur le terrain
        System.out.println("Players on field:");
        System.out.println("goalie:"+this.goalie.name+" "+this.goalie.surname);  
        System.out.println("attack:");
        for (int g=0;g<players.size();g++){
            if((this.players.get(g).favPos=="atk") && (this.players.get(g).card!=2)){ //affiche le joueur seulement si la position est la bonne et qu'il n'a pas de carton rouge
            System.out.println(this.players.get(g).name+" "+this.players.get(g).surname+" "+this.players.get(g).number );
            }
        }
        System.out.println("middle:");
        for (int g=0;g<players.size();g++){
            if((this.players.get(g).favPos=="mid") && (this.players.get(g).card!=2)){
            System.out.println(this.players.get(g).name+" "+this.players.get(g).surname+" "+this.players.get(g).number );
            }
        }
        System.out.println("defense:");
        for (int g=0;g<players.size();g++){
            if((this.players.get(g).favPos=="def") && (this.players.get(g).card!=2)){
            System.out.println(this.players.get(g).name+" "+this.players.get(g).surname+" "+this.players.get(g).number );
            }
        }
        System.out.println("Players not playing");
        for (int g=0;g<FullTeam.size();g++){
            if(this.FullTeam.get(g).field==false){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number );
            }
        }
    }
       
}
