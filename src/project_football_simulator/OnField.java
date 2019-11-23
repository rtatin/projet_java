/*
 * Raphael Tatin / Théophile Vonck
 * Projet java 2019
 * Football manager simulator
 */
package project_football_simulator;

/**
 *
 * @author rtwam
 */
public class OnField extends Character{ 
    private boolean field;
    private float stamina=100;
    
    /**
     * Retourne la stamina d'un joueur
     * @return
     */
    public float getStamina(){
        return this.stamina;
    }

    /**
     * Permet de savoir s'il est sur le terrain
     * @return
     */
    public boolean getField(){
       return this.field;
   } 

    /**
     * CHange la valeur field
     * @param onfield
     */
    public void setField(boolean onfield){
        this.field=onfield;
    }

    /**
     * Change la stamina
     * @param stamina
     */
    public void setStamina(float stamina){
        this.stamina=stamina;
    }
}