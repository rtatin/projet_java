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
    int number;
    float attack;
    float defense;
    float boostAttack=0;
    float boostDefense=0;
     float boostAttackCoach=0;
    float boostDefenseCoach=0;
    String favPos;
    int card;
    
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

    /**
     * Affiche les stats d'un joueur
     */
    public void printPlayer(){ 
        System.out.println("nom: "+this.name+" "+this.surname);
        System.out.println("age: "+this.age);
        System.out.println("position: "+this.favPos);
        System.out.println("stat: ");
        System.out.println("attack: "+this.attack);
        System.out.println("defence: "+this.defense);
    }
        
    /**
     * Grace a l'interface, gere la fatigue en fonction de l'age du joueur
     */
    @Override
    public void fatigue(){
        this.stamina=this.stamina-(10*super.age/20);
    }
    
    
}
