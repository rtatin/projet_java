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
    
    protected boolean field;
    protected int stamina=100;
    
    public float getStamina(){
        return this.stamina;
    }
}