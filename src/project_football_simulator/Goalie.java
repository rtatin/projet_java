/*
 * Raphael Tatin / Théophile Vonck
 * Projet java 2019
 * Football manager simulator
 */
package project_football_simulator;

/**
 * Classe goalie
 * @author rtwam
 */
public class Goalie extends OnField implements Fatigue{
    private int skill;
    private int number;
    
    /**
     * Constructeur pour la classe goalie
     * @param field
     * @param number
     * @param stamina
     * @param name
     * @param surname
     * @param age
     * @param nationality
     * @param skill
     * @param equipe
     */
    public Goalie(boolean field,int number,int stamina,String name,String surname, int age, String nationality,int skill,String equipe){
       this.number=number;
       this.skill=skill;
       super.setStamina(stamina);
       super.name=name;
       super.surname=surname;
       super.age=age;
       super.nationality=nationality;
       super.equipe=equipe;
    
    }

    /**
     * @return le skill du goal
     */
    public int getSkill() { 
            return this.skill;
    }
    
    /**
     *retourne son numéro
     * @return
     */
    public int getNumber() { 
            return this.number;
    }

    /**
     * Fonction qui fait baisser l'endurance
     */
    @Override
    public void fatigue(){
        this.setStamina(this.getStamina()-(8*super.age/20));
    }
    
    /**
     * Affiche les stats du goal
     */
    public void printGoalie(){
    System.out.println("goalie: nom: "+this.getName()+" "+this.getSurname()+" number "+this.getNumber() +" age: "+this.getAge()+" nationality :"+getNationality()+" skill :"+getSkill()+"\n");  
    }
}
