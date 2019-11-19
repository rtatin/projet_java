/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe qui correspond a l'equipe complete de football
 * Elle est compose d'un nom, d'un coach, d'une equipe au complet, de joueurs 
 * qui seront sur le terrain, d'un booleen qui permettra de determiner si l'utilisateur 
 * a choisi cette équipe et d'un autre qui permettra de savoir si l'equipe est eliminee
 * de la competition
 * @author rtwam
 */
public class Team {
    private String name;
    private Manager manager;
    private ArrayList <Player> FullTeam; 
    private ArrayList <Player> players;
    private Goalie goalie;
    private boolean isPlayer=false;
    private boolean loose=false;
    private int idTeam;
    
public String getName() { 
            return this.name;
    }
public Manager getManager() { 
            return this.manager;
    }
public ArrayList <Player> getFullTeam() { 
            return this.FullTeam;
    }
public ArrayList <Player> getPlayers() { 
            return this.players;
    }
public Goalie getGoalie() { 
            return this.goalie;
    }
public boolean getIsPlayer() { 
            return this.isPlayer;
    }
public boolean getIsLoose() { 
            return this.loose;
    }
public int getIdTeam() { 
            return this.idTeam;
    }

public void SetName(String name){
    this.name=name;
}
public void SetManager(Manager manager){
    this.manager=manager;
}
public void SetFullTeam(ArrayList <Player> fullteam){
    this.FullTeam=fullteam;
}
public void SetPlayer(ArrayList <Player> player){
    this.players=player;
}
public void SetGoalie(Goalie goal){
    this.goalie=goal;
}
public void SetIsPlayer(Boolean variable){
    this.isPlayer=variable;
}
public void SetIdTeam(int number){
    this.idTeam=number;
}
public void SetLoose(boolean perte){
    this.loose=perte;
}
    /**
     * Permet de generer une equipe complete de joueurs
     * Dans chaque equipe, on cree 5 joueurs en attaque, avec des stats 
     * aléatoires qu'on place dans l'arraylist.
     * On fait de meme pour les milieux de terrain et la defense
     * On genere aussi un manager et un goalie 
     */
    public void createFullTeam(){ 
        
        this.name=this.getRandomNameTeam(getNameTeam());
        ArrayList <Player> newTeam= new <Player>ArrayList();  
        for(int i=1;i<6;i++){ 
            Player newPlayer=new Player(i, (int) (60 + Math.random() * (100 - 60)), (int) (20 + Math.random() * (40 - 0)),"atk",false,Character.getRandomName(),Character.getRandomSurname(), (int) (Math.random() * (40 - 16)),Character.getRandomNationality(),this.name);
            newTeam.add(newPlayer);
        }
        for(int i=6;i<11;i++){ 
            Player newPlayer=new Player(i, (int) (40 + Math.random() * (80 - 40)), (int) (40 + Math.random() * (80 - 40)),"mid",false,Character.getRandomName(),Character.getRandomSurname(), (int) (Math.random() * (40 - 16)),Character.getRandomNationality(),this.name);
            newTeam.add(newPlayer);
        }
        for(int i=11;i<16;i++){ 
            Player newPlayer=new Player(i, (int) (20 + Math.random() * (40 - 0)), (int) (60 + Math.random() * (100 - 60)),"def",false,Character.getRandomName(),Character.getRandomSurname(), (int) (Math.random() * (40 - 16)),Character.getRandomNationality(),this.name);
            newTeam.add(newPlayer);
        }
        SetFullTeam(newTeam); 
        Manager man=new Manager((int) ((int) 1+ (Math.random() * 4)),Character.getRandomName(),Character.getRandomSurname(), (int) (Math.random() * (60 - 40)),Character.getRandomNationality(),this.name);
        SetManager(man);
        Goalie goal=new Goalie(true,0,100,Character.getRandomName(),Character.getRandomSurname(), (int) (Math.random() * (40 - 16)),Character.getRandomNationality(), (int) (60 + Math.random() * (40 - 0)),this.name);
        SetGoalie(goal);
    }
    
    /**
     * Permet de generer automatiquement une equipe de joueurs qui sera sur le 
     * terrain
     * Elle aura une 3 dispositions différentes et sera donnee par un random
     */
    public void createPlayingTeamBot(){
        ArrayList <Player> newPlayer=new <Player>ArrayList();
        int numberChoice=(int)Math.random()* (2 - 0);
        int defCount=4;
        int midCount=4;
        int atkCount=2;
        switch (numberChoice) { 
            case 0: 
                {
                    defCount=4;
                    midCount=4;
                    atkCount=2;
                    break;
                }
            case 1: 
                {
                    defCount=4;
                    midCount=3;
                    atkCount=3;
                    break;
                }
            case 2: 
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
        SetPlayer(newPlayer);
    }
    
    /**
     * Permet a l'utilisateur de composee lui-meme son equipe sur le terrain
     * Il choisit entre 3 dispositions differentes
     * L'utilisateur peut ensuite selectionner chacun des joueurs qu'il veut 
     * faire rentrer sur le terrain, en suivant la disposition choisie
     * precedemment
     */
    public void createPlayingTeam(){ 
        ArrayList <Player> newPlayer=new <Player>ArrayList(); 
        System.out.println("Choose the disposition:\n -> 1 for 4-4-2\n -> 2 for 4-3-3\n -> 3 for 5-3-2");
        Scanner myObj = new Scanner(System.in);
        String num = myObj.nextLine();
        int numberChoice;
        try{
            numberChoice=Integer.parseInt(num);
            if (numberChoice>3 && numberChoice<1){
                throw new Exception("Choice out of range, 4-4-2 by default");
                }
            }
        catch(Exception b){
                System.err.println(b.getMessage());
                numberChoice=1;
            }
        
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
        
        int count=0;
        String pos="";
        
        for (int j=0;j<3;j++){ 
            switch (j) {
                case 0: 
                    {
                        System.out.println("Choose your "+defCount+" players in defense:");
                        count=defCount;
                        pos="def";
                        
                        break;
                    }
                case 1: 
                    {
                        System.out.println("Choose your "+midCount+" players in mid:");
                        count=midCount;
                        pos="mid";
                        break;
                    }
                case 2: 
                    {
                        System.out.println("Choose your "+atkCount+" players in atk:");
                        count=atkCount;
                        pos="atk";
                        break;
                    }
                default:
                    break;
            }
            
            while (count>0){ 
                myObj = new Scanner(System.in); 
                String numberPlayer = myObj.nextLine();                 
                try{
                    int numPlayer = Integer.parseInt(numberPlayer); 
                    if (numPlayer<1 || numPlayer>15){
                        throw new Exception("No player with this number");
                    }
                    else{
                        boolean alreadyInPlayer=false; 
                        for(int i=0;i<newPlayer.size();i++){
                            if(newPlayer.get(i).getNumber()==numPlayer){
                                alreadyInPlayer=true;
                            }
                        }
                        if((alreadyInPlayer==false)&&(this.FullTeam.get(numPlayer-1).getFavPos()==pos)){ 
                            newPlayer.add(FullTeam.get(numPlayer-1)); 
                            FullTeam.get(numPlayer-1).field=true; 
                            count--; 
                        }
                        try{
                            if ((alreadyInPlayer==true)&&(this.FullTeam.get(numPlayer-1).getFavPos()==pos)){
                                throw new Exception("This player is already on field");
                            }
                        }
                        catch(Exception b){
                            System.err.println(b.getMessage());
                        }
                        System.out.println("your team for now ");
                            for(int k=0;k<newPlayer.size();k++){
                            System.out.println(newPlayer.get(k).name+" "+newPlayer.get(k).surname+" "+newPlayer.get(k).getFavPos());
                            }
                        }
                    }
                catch(Exception e){
                    System.err.println(e.getMessage());
                }
            }          
        }
        this.players=newPlayer;
    }

    /**
     * Fonction explicite d'elle-meme, elle affiche toutes les donnees d'une equipe
     * a savoir son nom, ses joueurs et son manageur
     */
    public void printFullTeam(){ //permet d'afficher l'équipe au complet
        System.out.println("teamname :"+this.name);
        this.manager.printManager();
        this.goalie.printGoalie();
        
        System.out.println("attack :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).getFavPos()=="atk"){
            this.FullTeam.get(g).printPlayer();
            }
        }
        System.out.println("middle :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).getFavPos()=="mid"){
                this.FullTeam.get(g).printPlayer();
            }
        }
        System.out.println("defense :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).getFavPos()=="def"){
                this.FullTeam.get(g).printPlayer();
            }
        }
    }
    
    /**
     * Fonction qui affiche seulement les joueurs presents sur le terrain
     */
    public void printTeamOnField(){ //permet d'afficher seulement les joueurs sur le terrain
        String atk="atk";
        String def="def";
        String mid="mid";
        
        System.out.println("Players on field:");
        this.goalie.printGoalie();
        System.out.println("attack:");
        for (int g=0;g<players.size();g++){
            if((this.players.get(g).getFavPos().equals(atk)) && (this.players.get(g).card!=2)){ //affiche le joueur seulement si la position est la bonne et qu'il n'a pas de carton rouge
            this.players.get(g).printPlayer();
            }
        }
        System.out.println("middle:");
        for (int g=0;g<players.size();g++){
            if((this.players.get(g).getFavPos()=="mid") && (this.players.get(g).card!=2)){
                this.players.get(g).printPlayer();
            }
        }
        System.out.println("defense:");
        for (int g=0;g<players.size();g++){
            if((this.players.get(g).getFavPos()=="def") && (this.players.get(g).card!=2)){
                this.players.get(g).printPlayer();
            }
        }
        System.out.println("Players not playing");
        for (int g=0;g<FullTeam.size();g++){
            if(this.FullTeam.get(g).field==false){
                this.FullTeam.get(g).printPlayer();
            }
        }
    }

    /**
     * nationality permet de booster les statistiques des joueurs s'ils ont la 
     * meme nationalite
     * Pour chaque joueur, on recupere le nombre de coequipiers ayants la meme
     * nationalite, et on incremente son attaque qu'on place dans boostAttack
     */
    public void nationality(){
        int cont=0; 
        for (int i=0;i<this.players.size();i++){
            Player play=this.players.get(i);
            for (int g=0;g<this.players.size();g++){
            
                if((play.nationality==this.players.get(g).nationality)&&(play.getNumber()!=this.players.get(g).getNumber())&&(play.field==true)){
                    cont=cont+1;
                }
                if(cont>1){
                    switch(play.getFavPos()) {
                    case "atk":
                        play.setBoostAttack(play.getAttack()+play.getAttack()*(cont/10));
                        break;
                    case "mid":
                        play.setBoostAttack(play.getAttack()+play.getAttack()*(cont/20));
                        play.setBoostDefense(play.getDefense()+play.getDefense()*(cont/20));
                        break;
                    case "def":
                        play.setBoostDefense(play.getDefense()+play.getDefense()*(cont/10));
                        break;
                    default:
                        break;
                    }  
                }
                else{
                    play.setBoostAttack(play.getAttack());
                    play.setBoostDefense(play.getDefense());
                }
            }
        }  
    }

    /**
     * A chaque boostTeam, on rappelle nationalite pour mettre a jour les boosts d'attaque
     * D'un autre cote, fonction applique le type de boost choisi par l'utilisateur pendant
     * le debut de match ou bien pendant la pause
     */
    public void boostTeam(){
        this.nationality(); 
        int choice=0;
        if(this.isPlayer==true){
            choice = this.manager.teamManagement();
        }
        else{
            choice= (int) (1 + Math.random() * 3);
        }
        for (int i=0;i<this.players.size();i++){            
            switch(choice) {
                case 1:
                    this.players.get(i).setBoostAttackCoach(this.players.get(i).getBoostAttack()+this.players.get(i).getAttack()*(this.manager.getBoost()/20));
                    this.players.get(i).setBoostDefenseCoach(this.players.get(i).getBoostDefense());
                    break;
                case 2:
                    this.players.get(i).setBoostAttackCoach(this.players.get(i).getBoostAttack()+this.players.get(i).getAttack()*(this.manager.getBoost()/40));
                    this.players.get(i).setBoostDefenseCoach(this.players.get(i).getBoostDefense()+this.players.get(i).getDefense()*(this.manager.getBoost()/40));
                    break;
                case 3:
                    this.players.get(i).setBoostAttackCoach(this.players.get(i).getBoostAttack());
                    this.players.get(i).setBoostDefenseCoach(this.players.get(i).getBoostDefense()+this.players.get(i).getDefense()*(this.manager.getBoost()/20));
                    break;
                default:
                    break;
            }
        }
    }
    
    /**
     * Recupere l'arraylist des joueurs depuis un fichier txt
     * @return
     */
    public static ArrayList<String> getNameTeam() {
        ArrayList<String> nameArray=new ArrayList<String>();
     
		try {
			BufferedReader fluxEntree= new BufferedReader(new FileReader("noms_equipes.txt"));
			String ligne = "";
			
		while (!(ligne==null)) {
		ligne = fluxEntree.readLine( );  
	
		if (!(ligne==null)) {
			nameArray.add(ligne);
		}
		}
                
		}
		catch(FileNotFoundException e)
		{ System.out.println(" Fichier noms_equipes nexiste pas");
		System.out.println("ou erreur ouverture");} 
		catch(IOException e)
		{ System.out.println("Erreur lecture noms_equipes.txt.");}
                return nameArray;
    }
    
    /**
     * Meme fonction mais pour les noms des joueurs
     * @param nameArray
     * @return
     */
    public static String getRandomNameTeam(ArrayList<String> nameArray) {
        
        String name = nameArray.get(new Random().nextInt(nameArray.size()));
		return name;
    }
}
