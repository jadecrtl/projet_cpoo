package enums;

import utils.AnsiColors;

/**
 * L'énumération Couleur représente différentes couleurs avec leurs attributs de crayon et de stabilo.
 * Chaque couleur est associée à des codes de couleur ANSI pour le crayon et le stabilo.
 * Les codes de couleur ANSI sont définis dans la classe AnsiColors.
 */

public enum Couleur {
    BLEU(AnsiColors.ANSI_BLUE, AnsiColors.ANSI_BLUE_BACKGROUND + AnsiColors.ANSI_BLACK),
    BLANC(AnsiColors.ANSI_WHITE, AnsiColors.ANSI_WHITE_BACKGROUND + AnsiColors.ANSI_BLACK),
    ROUGE(AnsiColors.ANSI_RED, AnsiColors.ANSI_RED_BACKGROUND + AnsiColors.ANSI_BLACK),
    VERT(AnsiColors.ANSI_GREEN, AnsiColors.ANSI_GREEN_BACKGROUND + AnsiColors.ANSI_BLACK),
    MAUVE(AnsiColors.ANSI_PURPLE, AnsiColors.ANSI_PURPLE_BACKGROUND + AnsiColors.ANSI_BLACK),
    JAUNE(AnsiColors.ANSI_YELLOW, AnsiColors.ANSI_YELLOW_BACKGROUND + AnsiColors.ANSI_BLACK);
    

    private String crayon;
    private String stabilo;

    /**
     * Constructeur de l'énumération Couleur.
     * 
     * @param crayon est le code de couleur ANSI utilisé pour le crayon
     * @param stabilo est le code de couleur ANSI utilisé pour le stabilo
     */

    private Couleur(String crayon, String stabilo) {
        this.crayon = crayon;
        this.stabilo = stabilo;
    }

    /**
     * Retourne le code de couleur ANSI utilisé pour le crayon.
     *
     * @return le code de couleur ANSI utilisé pour le crayon 
     */

    public String getStabilo() {
        return stabilo;
    }

    /**
     * Retourne le code de couleur ANSI utilisé pour le stabilo.
     *
     * @return le code de couleur ANSI utilisé pour le stabilo 
     */

    public String getCrayon() {
        return this.crayon;
    }    
}
