/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public int getNumber() { 
            return this.number;
    }
    public float getAttack() { 
            return this.attack;
    }
     public float getDefense() { 
            return this.defense;
    }
    public float getBoostAttack() { 
            return this.boostAttack;
    }
    public float getBoostDefense() { 
            return this.boostDefense;
    }
    public float getBoostAttackCoach() { 
            return this.boostAttackCoach;
    }
    public float getBoostDefenseCoach() { 
            return this.boostDefenseCoach;
    }
    public String getFavPos() { 
            return this.favPos;
    }
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
     *
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

    public void resetPlayerBoostAtck(Player player){
    this.setBoostAttack(player.getBoostAttack());
    this.setBoostDefense(player.getBoostDefense());
    }
    /**
     * Affiche les stats d'un joueur
     */
            
    public void printPlayer(){ 
        System.out.println(" Name: "+this.getName()+" "+this.getSurname()+" Number: "+this.getNumber() +" Age: "+this.getAge()+" Nationality: "+getNationality() +" Position: "+this.getFavPos()+"\n Stats-> "+"Attack: "+this.getAttack()+" Defense: "+this.getDefense()+" Stamina: "+this.getStamina()+" boostatack: "+this.getBoostAttack()+" boostdefence: "+this.getBoostDefense()+"\n" );
    }
        
    /**
     * Grace a l'interface, gere la fatigue en fonction de l'age du joueur
     */
    @Override
    public void fatigue(){
        this.setStamina(this.getStamina()-(4*super.age/20));
    }
}
