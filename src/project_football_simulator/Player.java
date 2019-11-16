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
    float boostAttack=0;
    float boostDefense=0;
    String favPos;
    int card;
    
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
    public void printPlayer(){ //permet d'afficher toutes les caractéristiques propres à un joueur
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
    
    
    public void nationality(Team team){
        Team Tampon = new Team();
        int cont=0;

        
        for (Player var : Tampon.players){
            if((this.nationality==var.nationality)&&(this.number!=var.number)){
                cont=cont+1;
            }
        }
        if(cont>1){
            switch(this.favPos) {
            case "atk":
                this.boostAttack=this.attack+this.attack*(cont/10);
                break;
            case "mid":
                this.boostAttack=this.attack+this.attack*(cont/20);
                this.boostDefense=this.defense+this.defense*(cont/20);
                break;
            case "def":
                this.boostDefense=this.defense+this.defense*(cont/10);
                break;
            default:
                break;
            }  
        }
        switch(Tampon.manager.teamManagement()) {
            case 1:
                this.boostAttack=this.boostAttack+this.attack*(Tampon.manager.boost/10);
                break;
            case 2:
                this.boostAttack=this.boostAttack+this.attack*(Tampon.manager.boost/20);
                this.boostDefense=this.boostDefense+this.defense*(Tampon.manager.boost/20);
                break;
            case 3:
                this.boostDefense=this.boostDefense+this.defense*(Tampon.manager.boost/10);
                break;
            default:
                break;
        }  
    }
}
