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
    private int severity;
    
    
    @Override
    public void fatigue(){
        this.setStamina(this.getStamina()-(8*super.age/20));
    }
    public void setSeverite(int severity){
        this.severity=severity;
    }
    public int getSeverite(){
        return this.severity;
    }
    
    
    public void RecalulateSeverite(){
        this.setSeverite(this.getSeverite()+((100-this.getStamina())/100));
        System.out.println(getStamina());
        System.out.println(getSeverite());
    }
    
    public void generateReferee(){
        this.severity=(int) ((int) 20+ (Math.random() * (80)));
        this.setField(true);
        super.setStamina(100);
        super.name=Character.getRandomName();
        super.surname=Character.getRandomSurname();
        super.age=(int) (20 + Math.random() * 30);
        super.nationality=Character.getRandomNationality();
        
    }
    public void YellowCard(Player player){
        float rand=(float) (Math.random() * (1 - 0.5));
        if( rand > (1-(this.getSeverite()/100)) ) {  
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
        player.setField(false);            
        }   
}
