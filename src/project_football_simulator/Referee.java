/*
 * Raphael Tatin / Théophile Vonck
 * Projet java 2019
 * Football manager simulator
 */
package project_football_simulator;
import java.util.Random;
/**
 *
 * @author rtwam
 */
public class Referee extends OnField implements Fatigue {
    private float severity;
    
    /**
     * Modifie l'endurance de l'arbitre
     */
    @Override
    public void fatigue(){
        this.setStamina(this.getStamina()-(3*super.age/20));
    }

    /**
     * Permet de set la severite
     * @param severity
     */
    public void setSeverite(float severity){
        this.severity=severity;
    }

    /**
     * Retourne la severite
     * @return
     */
    public float getSeverite(){
        return this.severity;
    }
    
    /**
     * Calcule a nouveau la severite en fonction de la fatigue
     */
    public void RecalulateSeverite(){
        this.setSeverite(this.getSeverite()+((100-this.getStamina())/100));
    }
    
    /**
     * Fonction qui genere un arbitre
     * Avec des statistiques aleatoires
     */
    public void generateReferee(){
        this.setSeverite((int) ((int) 20+ (Math.random() * (5))));
        this.setField(true);
        super.setStamina(100);
        super.name=Character.getRandomName(Character.getNamePlayer());
        super.surname=Character.getRandomSurname(Character.getSurnamePlayer());
        super.age=(int) (15 + Math.random() * 30);
        super.nationality=Character.getRandomNationality(Character.getNationalityPlayer());
        
    }

    /**
     * Fonction qui donne des cartons jaunes aux joueurs
     * Si le random passe une valeur seuille, un carton jaune est donne au joueur
     * Le seuil varie en fonction de la severite de l'arbitre, et donc aussi de sa
     * fatigue
     * @param player
     */
    public void YellowCard(Player player){
        float rand=(float) (20+ Math.random() * 300);
        if( rand < this.getSeverite() ) {  
            
            if(player.getCard()==1){
                RedCard(player);
                player.setCard(2);
                System.out.println("Referee "+this.name +" gave red card to ");
                player.printPlayer();
                RedCard(player);
            }  
            else{
                System.out.println("Referee "+this.name+" gave yellow card to ");
                player.printPlayer();
                player.setCard(1);;
            }
        }      
    }
    
    /**
     * Si carton rouge, le joueur est renvoye du terrain
     * @param player
     */
    public void RedCard(Player player){
        player.setField(false);            
        }   
}
