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
    public int teamManagement(){
        System.out.println("select the boost: \n enter 1 to boost attack\n enter 2 to boost middle\n enter 3 to boost defense");
        Scanner choice=new Scanner(System.in);
        String obj = choice.nextLine();
        int choosenBoost=(Integer.parseInt(obj));
        while ((choosenBoost>3)||(choosenBoost<1)){
            System.out.println("select the boost: \n enter 1 to boost attack\n enter 2 to boost middle\n enter 3 to boost defense");
             obj = choice.nextLine();  
        }
        return (choosenBoost); 
        }
         
    }

