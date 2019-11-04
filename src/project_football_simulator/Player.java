/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rtwam
 */
public class Player extends OnField implements Fatigue{
    int number;
    float attack;
    float defense;
    String favPos;
    String card;
    public Player(int number,int attack,int defense,String favPos,String card,boolean field,String name,String surname, int age, String nationality){        
        super.name=name;
        super.surname=surname;
        super.age=age;
        super.nationality=nationality;
        this.number=number;
        this.attack=attack;
        this.defense=defense;
        this.favPos=favPos;
        this.card=card;
    }
        public void printPlayer(){
    System.out.println("nom: "+this.name+" "+this.surname);
    System.out.println("age: "+this.age);
    System.out.println("position: "+this.favPos);
    System.out.println("stat: ");
    System.out.println("attack: "+this.attack);
    System.out.println("defence: "+this.defense);
    }
        
    @Override
    public void fatigue(){
        this.stamina=this.stamina-(10*super.age/20);
    }
    	
}

