/*
 * Raphael Tatin / Théophile Vonck
 * Projet java 2019
 * Football manager simulator
 */
package project_football_simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe abstraite character, qui définit les etres humains
 * @author rtwam
 */
public abstract class Character {
    protected String name;
    protected String surname;
    protected int age;
    protected String nationality;
    protected String equipe;
    
    /**
     * Recupere le nom du joueur
     * @return
     */
    public String getName() { 
            return this.name;
    }

    /**
     * Le prenom
     * @return
     */
    public String getSurname() { 
            return this.surname;
    }

    /**
     * L'age
     * @return
     */
    public int getAge() { 
            return this.age;
    }

    /**
     * La nationalite
     * @return
     */
    public String getNationality() { 
            return this.nationality;
    }

    /**
     * L'equipe dans laquelle il se trouve
     * @return
     */
    public String getEquipe() { 
            return this.equipe;
    }
    
    /**
     * Cherche dans un fichier texte le nom d'un joueur
     * L'exception verifie si le fichier existe
     * @return le nom random d'un joueur
     */
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
		catch(FileNotFoundException e){ 
                    System.out.println(" Fichier noms_equipes nexiste pas");
                    System.out.println("ou erreur ouverture");} 
		catch(IOException e)
		{ 
                    System.out.println("Erreur lecture noms_joueurs.txt.");
                }
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
    
    /**
     * Meme fonction que getNamePlayer mais pour les prenoms
     * @return
     */
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

    /**
     * Retourne les differentes nationalites possibles d'un joueur, depuis 
     * un fichier texte
     * @return
     */
    public static ArrayList<String> getNationalityPlayer() {
        ArrayList<String> nameArray=new ArrayList<String>();
     
		try {
			BufferedReader fluxEntree= new BufferedReader(new FileReader("nationalite_joueurs.txt"));
			String ligne = "";
			
		while (!(ligne==null)) {
		ligne = fluxEntree.readLine( );  
	
		if (!(ligne==null)) {
			nameArray.add(ligne);
		}
		}
                
		}
		catch(FileNotFoundException e)
		{ System.out.println("Fichier noms_equipes n'existe pas");
		System.out.println("ou erreur ouverture");} 
		catch(IOException e)
		{ System.out.println("Erreur lecture nationalite_joueurs.txt.");}
                return nameArray;
    }
    
    /**
     * Recupere une nationalite aleatoire de l'array
     * @param nameArray
     * @return
     */
    public static String getRandomNationality(ArrayList<String> nameArray) {
        
        String name = nameArray.get(new Random().nextInt(nameArray.size()));
		return name;
    }
}

       