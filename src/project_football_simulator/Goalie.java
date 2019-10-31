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
public class Goalie extends OnField implements Fatigue{
    int skill;
    
    public Goalie(boolean field,int stamina,String name,String surname, int age, String nationality,int skill){
       
       this.skill=skill;
       super.stamina=stamina;
       super.name=name;
       super.surname=surname;
       super.age=age;
       super.nationality=nationality;
    
    }
    
   
    @Override
    public float fatigue(float stamina){
        return stamina-5;
    }
}
