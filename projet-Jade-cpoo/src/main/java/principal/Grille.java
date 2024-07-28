package principal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * La classe Grille représente une grille dans un automate cellulaire.
 * Elle contient des cellules et permet de manipuler la grille.
 */

public class Grille {
    private int largeurGrille;
    private int hauteurGrille;
    private List<Cellule> cellulesGrille = new LinkedList<Cellule>();
    private List<Integer> etatCellulesInitial = new LinkedList<Integer>();

    /**
     * Constructeur de la classe Grille.
     * 
     * @param largeurGrille est la largeur de la grille
     * @param hauteurGrille est la hauteur de la grille
     * @throws IllegalArgumentException si la largeur ou la hauteur de la grille est négative ou nulle
     */

    public Grille(int largeurGrille, int hauteurGrille) throws IllegalArgumentException {
        if(largeurGrille <= 0) {
            throw new IllegalArgumentException("La largeur de la grille doit être positive");
        }
        if(hauteurGrille <= 0) {
            throw new IllegalArgumentException("La hauteur de la grille doit être positive");
        }
        this.largeurGrille = largeurGrille;
        this.hauteurGrille = hauteurGrille;
        cellulesGrille = new LinkedList<Cellule>();
        creerCellulesDeLaGrille();
        remplirCellulesVoisines();
    }

    /**
     * Constructeur de la classe Grille avec un état initial des cellules.
     * 
     * @param largeurGrille est la largeur de la grille
     * @param hauteurGrille est la hauteur de la grille
     * @param etatCellulesInitial est la liste des états initiaux des cellules
     * @throws IllegalArgumentException si la largeur ou la hauteur de la grille est négative ou nulle
     *                                  ou si la taille de la liste d'état des cellules est différente de la taille de la grille
     * 
     */

    public Grille(int largeurGrille, int hauteurGrille, List<Integer> etatCellulesInitial) throws IllegalArgumentException {
        if(largeurGrille <= 0) {
            throw new IllegalArgumentException("La largeur de la grille doit être positive");
        }
        if(hauteurGrille <= 0) {
            throw new IllegalArgumentException("La hauteur de la grille doit être positive");
        }        
        if(etatCellulesInitial.size() != (largeurGrille * hauteurGrille)) {
            throw new IllegalArgumentException("La taille de la liste d'état des cellules doit être égale à la taille de la grille");
        }        
        this.largeurGrille = largeurGrille;
        this.hauteurGrille = hauteurGrille;
        cellulesGrille = new LinkedList<Cellule>();
        creerCellulesDeLaGrille();
        remplirCellulesVoisines();        
        setEtatParCellules(etatCellulesInitial);
        setEtatCellulesInitial(etatCellulesInitial);
    }

    /**
     * Retourne la largeur de la grille.
     * 
     * @return la largeur de la grille
     */    

    public int getLargeurGrille() {
        return largeurGrille;
    }

    /**
     * Modifie la largeur de la grille.
     * 
     * @param largeurGrille est la nouvelle largeur de la grille
     */        

    public void setLargeurGrille(int largeurGrille) {
        this.largeurGrille = largeurGrille;
    }

    /**
     * Retourne l'hauteur de la grille.
     * 
     * @return l'hauteur de la grille
     */        

    public int getHauteurGrille() {
        return hauteurGrille;
    }

    /**
     * Modifie l'hauteur de la grille.
     * 
     * @param hauteurGrille est la nouvelle hauteur de la grille
     */            

    public void setHauteurGrille(int hauteurGrille) {
        this.hauteurGrille = hauteurGrille;
    }

    /**
     * Retourne la liste des cellules de la grille.
     * 
     * @return la liste des cellules de la grille
     */

    public List<Cellule> getCellulesGrille() {
        return cellulesGrille;
    }

    /**
     * Modifie la liste des cellules de la grille.
     * 
     * @param cellulesGrille est la nouvelle liste des cellules de la grille
     */

    public void setCellulesGrille(List<Cellule> cellulesGrille) {
        this.cellulesGrille = cellulesGrille;
    }

    /**
     * Retourne la liste des états initiaux des cellules de la grille.
     * 
     * @return la liste des états initiaux des cellules de la grille
     */

    public List<Integer> getEtatCellulesInitial() {
        return etatCellulesInitial;
    }    

    /**
     * Modifie la liste des états initiaux des cellules de la grille.
     * 
     * @param etatCellulesInitial est la nouvelle liste des états initiaux des cellules de la grille
     */

    public void setEtatCellulesInitial(List<Integer> etatCellulesInitial) {
        this.etatCellulesInitial = etatCellulesInitial;
    }

    /**
     * Modifie l'état de chaque cellule de la grille en fonction de la liste des états initiaux.
     * 
     * @param etatCellulesInitial est la liste des états initiaux des cellules de la grille
     */

    public void setEtatParCellules(List<Integer> etatCellulesInitial) {
        for(int i = 0; i < etatCellulesInitial.size(); i++) {
            Cellule celluleCourante = cellulesGrille.get(i);
            celluleCourante.setEtatCellule(etatCellulesInitial.get(i));
        }
    }

    /**
     * Crée les cellules de la grille en fonction de sa largeur et de sa hauteur.
     */

    public void creerCellulesDeLaGrille() {
        for(int i = 0; i < (this.largeurGrille * this.hauteurGrille); i++) {
            Cellule cel = new Cellule(i);
            cellulesGrille.add(cel);
        }
    }

    /**
     * Remplit les cellules voisines pour chaque cellule de la grille.
     */

    public void remplirCellulesVoisines() {
        for (int i = 0; i < (this.largeurGrille * this.hauteurGrille); i++) {
            // Récupérer la cellule courante
            Cellule celluleCourante = cellulesGrille.get(i);
            int posX = i % largeurGrille; // Position en X de la cellule courante
            int posY = i / largeurGrille; // Position en Y de la cellule courante
            // Parcourir les 8 cellules voisines
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    // Ne pas considérer la cellule courante faisant partie de ses voisines
                    if (dx != 0 || dy != 0) {
                        int voisinX = posX + dx;
                        int voisinY = posY + dy;
                        // Vérifier les limites de la grille et exclure les cellules hors de la grille
                        if (voisinX >= 0 && voisinX < largeurGrille && voisinY >= 0 && voisinY < hauteurGrille) {
                            int voisinIndex = voisinY * largeurGrille + voisinX; // formule pour convertir les coordonnées en index (y * largeur + x)
                            Cellule voisin = cellulesGrille.get(voisinIndex);
                            celluleCourante.getCellulesVoisines().add(voisin.getIdCellule());
                        }
                    }
                }
            }
            // Trier la liste des cellules voisines par ordre croissant
            Collections.sort(celluleCourante.getCellulesVoisines());
        }
    }        

}
