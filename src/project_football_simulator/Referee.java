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
    private float severity;
    
    
    @Override
    public void fatigue(){
        this.setStamina(this.getStamina()-(3*super.age/20));
    }
    public void setSeverite(float severity){
        this.severity=severity;
    }
    public float getSeverite(){
        return this.severity;
    }
    
    
    public void recalulateSeverite(){
        this.setSeverite(this.getSeverite()+((100-this.getStamina())/100));
    }
    
    public void generateReferee(){
        this.setSeverite((int) ((int) 20+ (Math.random() * (5))));
        this.setField(true);
        super.setStamina(100);
        super.name=Character.getRandomName(Character.getNamePlayer());
        super.surname=Character.getRandomSurname(Character.getSurnamePlayer());
        super.age=(int) (15 + Math.random() * 30);
        super.nationality=Character.getRandomNationality(Character.getNationalityPlayer());
        
    }
    public void yellowCard(Player player){
        float rand=(float) (20+ Math.random() * 300);
        if( rand < this.getSeverite() ) {  
            
            if(player.getCard()==1){
            redCard(player);
                player.setCard(2);
                System.out.println("Referee "+this.name +" gave red card to ");
                player.printPlayer();
                redCard(player);
            }  
            else{
                System.out.println("Referee "+this.name+" gave yellow card to ");
                player.printPlayer();
            player.setCard(1);;
            }
        }      
    }
    
    public void redCard(Player player){
        player.setField(false);            
        }   
}
