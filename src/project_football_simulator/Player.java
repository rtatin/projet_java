/*
 * Raphael Tatin / Théophile Vonck
 * Projet java 2019
 * Football manager simulator
 */
package project_football_simulator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe du joueur
 * Possede son numeros, les statistiques, les differents boost et son positionnement
 * favori 
 * @author rtwam
 */
public class Player extends OnField implements Fatigue{
    private int number;
    private float attack;
    private float defense;
    private float boostAttack=0;
    private float boostDefense=0;
    private float boostAttackCoach=0;
    private float boostDefenseCoach=0;
    private String favPos;
    public int card;
    
    /**
     * retourne numero du joueur
     * @return
     */
    public int getNumber() { 
            return this.number;
    }

    /**
     *Retourne l'attaque
     * @return
     */
    public float getAttack() { 
            return this.attack;
    }
 
    /**
     * Retourne la defense
     * @return
     */
    public float getDefense() { 
            return this.defense;
    }

    /**
     * Retourne le boost atk
     * @return
     */
    public float getBoostAttack() { 
            return this.boostAttack;
    }

    /**
     * Boost def
     * @return
     */
    public float getBoostDefense() { 
            return this.boostDefense;
    }

    /**
     * Retourne boost attaque apres le boost du coach
     * @return
     */
    public float getBoostAttackCoach() { 
            return this.boostAttackCoach;
    }

    /**
     * Pareil mais pour defense
     * @return
     */
    public float getBoostDefenseCoach() { 
            return this.boostDefenseCoach;
    }

    /**
     *Recupere la position du joueur 
     * @return
     */
    public String getFavPos() { 
            return this.favPos;
    }

    /**
     * Retourne si le joueur a un carton
     * @return
     */
    public int getCard() { 
            return this.card;
    }
    

    public void setNumber(int number) { 
             this.number=number;
    }


    public void setAttack(float atck) { 
             this.attack=atck;
    }
 

    public void setDefense(float def) { 
             this.defense=def;
    }


    public void setBoostAttack(float atck) { 
             this.boostAttack=atck;
    }


    public void setBoostDefense(float def) { 
             this.boostDefense=def;
    }


    public void setBoostAttackCoach(float atck) { 
             this.boostAttackCoach=atck;
    }


    public void setBoostDefenseCoach(float def) { 
             this.boostDefenseCoach=def;
    }


    public void setFavPos(String pos) { 
             this.favPos=pos;
    }


    public void setCard(int card) { 
             this.card=card;
    }
    
    
    
    /**
     * Constructeur du player
     * @param number
     * @param attack
     * @param defense
     * @param favPos
     * @param field
     * @param name
     * @param surname
     * @param age
     * @param nationality
     * @param equipe
     */
    public Player(int number,int attack,int defense,String favPos,boolean field,String name,String surname, int age, String nationality,String equipe){        
        super.name=name;
        super.surname=surname;
        super.age=age;
        super.nationality=nationality;
        super.equipe=equipe;
        this.number=number;
        this.attack=attack;
        this.defense=defense;
        this.favPos=favPos;
        
    }

    /**
     * Méthode qui change le boost en fonction des nouveaux joueurs qui sont places
     * sur le terrain
     * @param player
     */
    public void resetPlayerBoostAtck(Player player){
    this.setBoostAttack(player.getBoostAttack());
    this.setBoostDefense(player.getBoostDefense());
    }
    /**
     * Affiche les stats d'un joueur
     */
            
    public void printPlayer(){ 
        System.out.println(" Name: "+this.getName()+" "+this.getSurname()+" Number: "+this.getNumber() +" Age: "+this.getAge()+" Nationality: "+getNationality() +" Position: "+this.getFavPos()+"\n Stats-> "+"Attack: "+this.getAttack()+" Defense: "+this.getDefense()+" Stamina: "+this.getStamina()+"\n" );
    }
        
    /**
     * Grace a l'interface, gere la fatigue en fonction de l'age du joueur
     */
    @Override
    public void fatigue(){
        this.setStamina(this.getStamina()-(4*super.age/20));
    }
}
