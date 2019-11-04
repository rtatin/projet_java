/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;
import java.util.Random;
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
    
    public void Severite(){
        this.severity=this.severity+((100-this.stamina)/100);
    }
    
    public void YellowCard(Player player){
        if( new Random().nextDouble() <= (1-(this.severity/100)) ) {  
            if(player.card==true){
            RedCard(player);
            }  
            else{
            player.card=1;
            }
        }      
    }
    
    public void RedCard(Player player){
        player.field=false;            
        }   
}
