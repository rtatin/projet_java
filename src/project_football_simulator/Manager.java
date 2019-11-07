/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;

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
}
