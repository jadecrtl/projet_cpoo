package utils;

/**
 * La classe TerminalAffichage définit les méthodes pour afficher du texte dans la console.
 * Elle permet d'afficher du texte avec ou sans décoration et avec ou sans retour à la ligne.
 */

public class TerminalAffichage {

    /**
     * La méthode print() permet d'afficher du texte dans la console avec ou sans décoration.
     * 
     * @param decoration est le code de couleur ANSI utilisé pour décorer le texte
     * @param chaine est la chaîne de caractères à afficher
     */
    
    public void print(String decoration, String chaine) {
        if (decoration == null) {
            System.out.print(chaine);
        }
        else {
            System.out.print(decoration + chaine + AnsiColors.ANSI_RESET);
        }
    }

    /**
     * La méthode println() permet d'afficher du texte dans la console avec ou sans décoration et avec un retour à la ligne.
     * 
     * @param decoration est le code de couleur ANSI utilisé pour décorer le texte
     * @param chaine est la chaîne de caractères à afficher
     */

    public void println(String decoration, String chaine) {
        if (decoration == null) {
            System.out.println(chaine);
        }
        else {
            System.out.println(decoration + chaine + AnsiColors.ANSI_RESET);
        }
    }

    /**
     * La méthode effaceEcran() permet d'effacer le contenu de la console.
     */

    public void effaceEcran() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}