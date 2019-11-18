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
    String name;
    Manager manager;
    ArrayList <Player> FullTeam; 
    ArrayList <Player> players;
    Goalie goalie;
    boolean isPlayer=false;
    boolean loose=false;
    int idTeam;

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
        this.FullTeam=newTeam; 
        Manager man=new Manager((int) ((int) 1+ (Math.random() * 4)),Character.getRandomName(),Character.getRandomSurname(), (int) (Math.random() * (60 - 40)),Character.getRandomNationality(),this.name);
        this.manager=man;
        Goalie goal=new Goalie(true,0,100,Character.getRandomName(),Character.getRandomSurname(), (int) (Math.random() * (40 - 16)),Character.getRandomNationality(), (int) (60 + Math.random() * (40 - 0)),this.name);
        this.goalie=goal;
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
        this.players=newPlayer;
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
                int numPlayer = Integer.parseInt(numberPlayer); 
                boolean alreadyInPlayer=false; 
                for(int i=0;i<newPlayer.size();i++){
                    if(newPlayer.get(i).number==numPlayer){
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

    /**
     * Fonction explicite d'elle-meme, elle affiche toutes les donnees d'une equipe
     * a savoir son nom, ses joueurs et son manageur
     */
    public void printFullTeam(){ //permet d'afficher l'équipe au complet
        System.out.println("teamname :"+this.name);
        System.out.println("manager :"+this.manager.name+" "+this.manager.surname);
        System.out.println("golie :"+this.goalie.name+" "+this.goalie.surname);
        
        System.out.println("attack :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).favPos=="atk"){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number+" "+this.FullTeam.get(g).favPos+"nationality :"+this.FullTeam.get(g).nationality+"\n attack stat: "+this.FullTeam.get(g).attack+" defense stat: "+this.FullTeam.get(g).defense+" stamina :"+this.FullTeam.get(g).stamina+"\n" );
            }
        }
        System.out.println("middle :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).favPos=="mid"){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number+" "+this.FullTeam.get(g).favPos+"nationality :"+this.FullTeam.get(g).nationality+"\n attack stat: "+this.FullTeam.get(g).attack+" defense stat: "+this.FullTeam.get(g).defense+" stamina :"+this.FullTeam.get(g).stamina+"\n"  );
            }
        }
        System.out.println("defense :");
        for (int g=0;g<15;g++){
            if(this.FullTeam.get(g).favPos=="def"){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number+" "+this.FullTeam.get(g).favPos+"nationality :"+this.FullTeam.get(g).nationality+"\n attack stat: "+this.FullTeam.get(g).attack+" defense stat: "+this.FullTeam.get(g).defense+" stamina :"+this.FullTeam.get(g).stamina+"\n"  );
            }
        }
    }
    
    /**
     * Fonction qui affiche seulement les joueurs presents sur le terrain
     */
    public void printTeamOnField(){ //permet d'afficher seulement les joueurs sur le terrain
        System.out.println("Players on field:");
        System.out.println("goalie:"+this.goalie.name+" "+this.goalie.surname);  
        System.out.println("attack:");
        for (int g=0;g<players.size();g++){
            if((this.players.get(g).favPos=="atk") && (this.players.get(g).card!=2)){ //affiche le joueur seulement si la position est la bonne et qu'il n'a pas de carton rouge
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number+" "+this.FullTeam.get(g).favPos+"nationality :"+this.FullTeam.get(g).nationality+"\n attack stat: "+this.FullTeam.get(g).boostAttack+" defense stat: "+this.FullTeam.get(g).boostDefense+" stamina :"+this.FullTeam.get(g).stamina+"\n"  );
            }
        }
        System.out.println("middle:");
        for (int g=0;g<players.size();g++){
            if((this.players.get(g).favPos=="mid") && (this.players.get(g).card!=2)){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number+" "+this.FullTeam.get(g).favPos+"nationality :"+this.FullTeam.get(g).nationality+"\n attack stat: "+this.FullTeam.get(g).boostAttack+" defense stat: "+this.FullTeam.get(g).boostDefense+" stamina :"+this.FullTeam.get(g).stamina+"\n"  );
            }
        }
        System.out.println("defense:");
        for (int g=0;g<players.size();g++){
            if((this.players.get(g).favPos=="def") && (this.players.get(g).card!=2)){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number+" "+this.FullTeam.get(g).favPos+"nationality :"+this.FullTeam.get(g).nationality+"\n attack stat: "+this.FullTeam.get(g).boostAttack+" defense stat: "+this.FullTeam.get(g).boostDefense+" stamina :"+this.FullTeam.get(g).stamina+"\n"  );
            }
        }
        System.out.println("Players not playing");
        for (int g=0;g<FullTeam.size();g++){
            if(this.FullTeam.get(g).field==false){
            System.out.println(this.FullTeam.get(g).name+" "+this.FullTeam.get(g).surname+" "+this.FullTeam.get(g).number );
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
            
                if((play.nationality==this.players.get(g).nationality)&&(play.number!=this.players.get(g).number)&&(play.field==true)){
                    cont=cont+1;
                }
                if(cont>1){
                    switch(play.favPos) {
                    case "atk":
                        play.boostAttack=play.attack+play.attack*(cont/10);
                        break;
                    case "mid":
                        play.boostAttack=play.attack+play.attack*(cont/20);
                        play.boostDefense=play.defense+play.defense*(cont/20);
                        break;
                    case "def":
                        play.boostDefense=play.defense+play.defense*(cont/10);
                        break;
                    default:
                        break;
                    }  
                }
                else{
                    play.boostAttack=play.attack;
                    play.boostDefense=play.defense;
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
                    this.players.get(i).boostAttackCoach=this.players.get(i).boostAttack+this.players.get(i).attack*(this.manager.boost/20);
                    this.players.get(i).boostDefenseCoach=this.players.get(i).boostDefense;
                    break;
                case 2:
                    this.players.get(i).boostAttackCoach=this.players.get(i).boostAttack+this.players.get(i).attack*(this.manager.boost/40);
                    this.players.get(i).boostDefenseCoach=this.players.get(i).boostDefense+this.players.get(i).defense*(this.manager.boost/40);
                    break;
                case 3:
                    this.players.get(i).boostAttackCoach=this.players.get(i).boostAttack;
                    this.players.get(i).boostDefenseCoach=this.players.get(i).boostDefense+this.players.get(i).defense*(this.manager.boost/20);
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
