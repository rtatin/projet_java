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
    private int boost;
    
    /**
     * Constructeur d'un manager
     * @param boost
     * @param name
     * @param surname
     * @param age
     * @param nationality
     * @param equipe
     */
    public Manager(int boost,String name,String surname, int age, String nationality,String equipe){
        this.boost=boost;
        super.name=name;
        super.surname=surname;
        super.age=age;
        super.nationality=nationality;
        super.equipe=equipe;
    }
 
    /**
     * Retourne le boost choisi par l'utilisateur
     * @return
     */
    public int getBoost() { 
            return this.boost;
    }

    /**
     * Affiche le manager
     */
    public void printManager(){
    System.out.println("Manager: nom: "+this.getName()+" "+this.getSurname() +" age: "+this.getAge()+" nationality :"+getNationality()+" boost :"+getBoost()+"\n");  
    }
    
    /**
     * Methode permettant a l'utilisateur de selectionner son boost
     * @return
     */
    public int teamManagement(){
        System.out.println("select the boost: \n enter 1 to boost attack\n enter 2 to boost middle\n enter 3 to boost defense");
        Scanner choice=new Scanner(System.in);
        String obj = choice.nextLine();
        int choosenBoost=2;
        try{
            choosenBoost=Integer.parseInt(obj);
            if ((choosenBoost>3)||(choosenBoost<1)){
                throw new Exception("Wrong input, mid boost by default");
                }
            }
        catch(NumberFormatException b){
            System.err.println("Not a number, mid boost by default");
            choosenBoost=2;
        }
        catch(Exception b){
            System.err.println(b.getMessage());
            choosenBoost=2;
            }
        return (choosenBoost); 
        }
         
    }
