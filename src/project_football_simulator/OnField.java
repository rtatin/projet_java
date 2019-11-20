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
public class OnField extends Character{
    
    private boolean field;
    private int stamina=100;
    
    
    public int getStamina(){
        return this.stamina;
    }
   public boolean getField(){
       return this.field;
   } 
   public void setField(boolean onfield){
        this.field=onfield;
    }
   public void setStamina(int stamina){
        this.stamina=stamina;
    }
}