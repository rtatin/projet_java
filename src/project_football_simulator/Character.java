/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rtwam
 */
public abstract class Character {
    protected String name;
    protected String surname;
    protected int age;
    protected String nationality;
    protected String equipe;
    
    public static String getRandomName() {
		 ArrayList<String> nameArray=new ArrayList<String>(){{
        add("Martin");
        add("Bernard");
        add("Thomas");
        add("Petit");
        add("Robert");
        add("Richard");
        add("Durand");
        add("Dubois");
        add("Moreau");
        add("Laurent");
        add("Simon");
        add("Michel");
        add("Lefebvre");
        add("Leroy");
        add("Roux");
        add("David");
        add("Bertrand");
        add("Morel");
        add("Fournier");
        add("Girard");
        }}; 
 
		// Get Random Company Name from Arraylist using Random().nextInt()
		String name = nameArray.get(new Random().nextInt(nameArray.size()));
		return name;
	}
        public static String getRandomSurname() {
		 ArrayList<String> surnameArray=new ArrayList<String>(){{
        add("louis");
        add("gabriel");
        add("léo");
        add("maël");
        add("paul");
        add("hugo");
        add("valentin");
        add("gabin");
        add("arthur");
        add("théo");
        add("jules");
        add("lucas");
        add("sacha");
        add("ethan");
        add("clement");
        add("antoine");
        add("nathan");
        add("raphaël");
        add("thomas");
        add("tom");
        }}; 
 
		// Get Random Company Name from Arraylist using Random().nextInt()
		String surname = surnameArray.get(new Random().nextInt(surnameArray.size()));
		return surname;
	}
    
}
