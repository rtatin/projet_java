/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;

import java.util.Scanner;

/**
 *
 * @author rtwam
 */
public class Manager extends Character {
    int boost;
    public Manager(int boost,String name,String surname, int age, String nationality,String equipe){
        this.boost=boost;
        super.name=name;
        super.surname=surname;
        super.age=age;
        super.nationality=nationality;
        super.equipe=equipe;
    }
    public void teamManagement(){
        System.out.println("select the boost: \n enter 1 to boost attack\n enter 2 to boost middle\n enter 3 to boost defense");
        Scanner choice=new Scanner(System.in);
        String obj = choice.nextLine();
        int choosenboost=(Integer.parseInt(obj));
        
        switch(choosenboost) {
            case 1:
                this.boostAttack=this.attack+this.attack*(cont/10);
                break;
            case 2:
                this.boostAttack=this.attack+this.attack*(cont/20);
                this.boostDefence=this.defense+this.defense*(cont/20);
                break;
            case 3:
                this.boostDefence=this.defense+this.defense*(cont/10);
                break;
            default:
                break;
            }  
    
    }
}
