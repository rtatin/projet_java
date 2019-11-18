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
    
    
    @Override
    public void fatigue(){
        this.stamina=this.stamina-(8*super.age/20);
    }
    
    public void Severite(){
        this.severity=this.severity+((100-this.stamina)/100);
    }
    
    public void generateReferee(){
        this.severity=(int) (Math.random() * (100 - 0));
        this.field=true;
        super.stamina=100;
        super.name=Character.getRandomName();
        super.surname=Character.getRandomSurname();
        super.age=(int) (20 + Math.random() * 30);
        super.nationality=Character.getRandomNationality();
    }
    public void YellowCard(Player player){
        float rand=(float) (Math.random() * (1 - 0.5));
        if( rand > (1-(this.severity/100)) ) {  
            if(player.card==1){
            RedCard(player);
                player.card=2;
                System.out.println("refere "+this.name +"give red card to "+player.name);
                RedCard(player);
            }  
            else{
                System.out.println("refere "+this.name+"give yellow card to "+player.name);
            player.card=1;
            }
        }      
    }
    
    public void RedCard(Player player){
        player.field=false;            
        }   
}
