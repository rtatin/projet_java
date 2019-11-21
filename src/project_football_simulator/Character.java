/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_football_simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    public String getName() { 
            return this.name;
    }
    public String getSurname() { 
            return this.surname;
    }
    public int getAge() { 
            return this.age;
    }
    public String getNationality() { 
            return this.nationality;
    }
    public String getEquipe() { 
            return this.equipe;
    }
    
    public static ArrayList<String> getNamePlayer() {
        ArrayList<String> nameArray=new ArrayList<String>();
     
		try {
			BufferedReader fluxEntree= new BufferedReader(new FileReader("noms_joueurs.txt"));
			String ligne = "";
			
		while (!(ligne==null)) {
		ligne = fluxEntree.readLine( );  
	
		if (!(ligne==null)) {
			nameArray.add(ligne);
		}
		}
                
		}
		catch(FileNotFoundException e)
		{ System.out.println(" Fichier noms_equipes nexiste pas");
		System.out.println("ou erreur ouverture");} 
		catch(IOException e)
		{ System.out.println("Erreur lecture noms_joueurs.txt.");}
                return nameArray;
    }
    
    /**
     * Meme fonction mais pour les noms des joueurs
     * @param nameArray
     * @return
     */
    public static String getRandomName(ArrayList<String> nameArray) {
        
        String name = nameArray.get(new Random().nextInt(nameArray.size()));
		return name;
    }
    
    public static ArrayList<String> getSurnamePlayer() {
        ArrayList<String> nameArray=new ArrayList<String>();
     
		try {
			BufferedReader fluxEntree= new BufferedReader(new FileReader("noms_joueurs.txt"));
			String ligne = "";
			
		while (!(ligne==null)) {
		ligne = fluxEntree.readLine( );  
	
		if (!(ligne==null)) {
			nameArray.add(ligne);
		}
		}
                
		}
		catch(FileNotFoundException e)
		{ System.out.println(" Fichier noms_equipes nexiste pas");
		System.out.println("ou erreur ouverture");} 
		catch(IOException e)
		{ System.out.println("Erreur lecture noms_joueurs.txt.");}
                return nameArray;
    }
    
    /**
     * Meme fonction mais pour les noms des joueurs
     * @param nameArray
     * @return
     */
    public static String getRandomSurname(ArrayList<String> nameArray) {
        
        String name = nameArray.get(new Random().nextInt(nameArray.size()));
		return name;
    }
      public static ArrayList<String> getNationalityPlayer() {
        ArrayList<String> nameArray=new ArrayList<String>();
     
		try {
			BufferedReader fluxEntree= new BufferedReader(new FileReader("nationaliter_joueurs.txt"));
			String ligne = "";
			
		while (!(ligne==null)) {
		ligne = fluxEntree.readLine( );  
	
		if (!(ligne==null)) {
			nameArray.add(ligne);
		}
		}
                
		}
		catch(FileNotFoundException e)
		{ System.out.println(" Fichier noms_equipes nexiste pas");
		System.out.println("ou erreur ouverture");} 
		catch(IOException e)
		{ System.out.println("Erreur lecture nationaliter_joueurs.txt.");}
                return nameArray;
    }
    
    /**
     * Meme fonction mais pour les noms des joueurs
     * @param nameArray
     * @return
     */
    public static String getRandomNationality(ArrayList<String> nameArray) {
        
        String name = nameArray.get(new Random().nextInt(nameArray.size()));
		return name;
    }
}

       