/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;

/**
 * Classe goalie
 * @author rtwam
 */
public class Goalie extends OnField implements Fatigue{
    private int skill;
    private int number;
    
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
    public int getSkill() { 
            return this.skill;
    }
    
    public int getNumber() { 
            return this.number;
    }

    @Override
    public void fatigue(){
        this.stamina=this.stamina-(2*super.age/20);
    }
    
    public void printGoalie(){
    System.out.println("goalie: nom: "+this.getName()+" "+this.getSurname()+" number "+this.getNumber() +" age: "+this.getAge()+" nationality :"+getNationality()+" skill :"+getSkill()+"\n");  
    }
}
