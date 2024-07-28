package utils;

import java.util.Scanner;

/**
 * La classe Dialogue fournit des méthodes pour intéragir avec l'utilisateur via la console.
 * Elle permet de demander à l'utilisateur de saisir un entier, une chaîne de caractères et de simuler une pause en attendant que l'utilisateur appuie sur la touche Entrée.
 */

public class Dialogue {
    private Scanner scanner = new Scanner(System.in);
    private TerminalAffichage terminal = new TerminalAffichage();

    /**
     * La méthode demandeInt() permet de demander à l'utilisateur de saisir un entier supérieur à 0.
     * 
     * @param decoration est le code de couleur ANSI utilisé pour décorer la question
     * @param question est la question posée à l'utilisateur
     * @return l'entier saisi par l'utilisateur
     * @throws IllegalArgumentException si l'entier saisi est inférieur ou égal à 0
     */
    
    public int demandeInt(String decoration, String question) throws IllegalArgumentException{
        boolean erreur;
        do {
            terminal.print(decoration, question + " ");
            try {
                int value = scanner.nextInt();
                if (value <= 0) {
                    throw new IllegalArgumentException("La valeur doit être supérieure à zéro.");
                }
                erreur = false;
                return value;                
            }
            catch(Exception e) {
                scanner.next();
                erreur = true;
                terminal.println(AnsiColors.ANSI_GREEN, "Entree incorrecte, veuillez reessayer a nouveau svp.");

            }
        }
        while (erreur == true);
        return 0;
    }   
    
    /**
     * La méthode demandeString() permet de demander à l'utilisateur de saisir une chaîne de caractères.
     * 
     * @param decoration est le code de couleur ANSI utilisé pour décorer la question
     * @param question est la question posée à l'utilisateur
     * @return la chaîne de caractères saisie par l'utilisateur
     */

    public String demandeString(String decoration, String question) {
        boolean erreur;
        do {
            terminal.print(decoration, question + " ");
            try {
                erreur = false;
                return scanner.next();
            }
            catch(Exception e) {
                scanner.next();
                erreur = true;
                terminal.println(AnsiColors.ANSI_GREEN, "Entree incorrecte, veuillez reessayer a nouveau svp.");
            }
        }
        while (erreur == true);
        return null;
    }    

    /**
     * La méthode appuyerSurEntree() permet de simuler une pause en attendant que l'utilisateur appuie sur la touche Entrée.
     */

    public void appuyerSurEntree() {
        //String str1 = this.demandeString(AnsiColors.ANSI_GREEN, "Veuillez appuyer sur entree svp.");
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }    
}