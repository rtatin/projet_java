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
    int number;
    
    public Goalie(boolean field,int number,int stamina,String name,String surname, int age, String nationality,int skill,String equipe){
       this.number=number;
       this.skill=skill;
       super.stamina=stamina;
       super.name=name;
       super.surname=surname;
       super.age=age;
       super.nationality=nationality;
       super.equipe=equipe;
    
    }

    @Override
    public void fatigue(){
        this.stamina=this.stamina-(2*super.age/20);
    }
}
