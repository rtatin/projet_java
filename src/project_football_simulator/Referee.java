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
public class Referee extends OnField implements Fatigue {
    int severity;
    public Referee (int severity,boolean field,int stamina,String name,String surname, int age, String nationality){
        this.severity=severity;
        super.field=field;
        super.stamina=stamina;
        super.name=name;
        super.surname=surname;
        super.age=age;
        super.nationality=nationality;
    }
    @Override
    public void fatigue(){
        this.stamina=this.stamina-(8*super.age/20);
    }
}
