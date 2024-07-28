package principal;

import java.util.LinkedList;
import java.util.List;

/**
 * La classe Automate représente un automate cellulaire et permet d'exécuter le jeu de la vie.
 * Elle contient une grille, une liste de résultats, des bornes et le nombre maximum d'itérations que lanceJeu peut faire.
 */

public class Automate {
    private Grille grilleAutomate;
    private List<List<Integer>> resultats = new LinkedList<List<Integer>>();
    private int borne1;
    private int borne2;
    private int maxIterations; //nombre maximum d'itérations que lanceJeu peut faire

    /**
     * Constructeur de la classe Automate.
     * 
     * @param grilleAutomate est la grille de l'automate
     * @param borne1 est la première borne de l'automate
     * @param borne2 est la deuxième borne de l'automate
     * @param maxIterations est le nombre maximum d'itérations que lanceJeu peut faire
     * @throws IllegalArgumentException si la première borne ou la deuxième borne est négative ou nulle
     */

    public Automate(Grille grilleAutomate, int borne1, int borne2, int maxIterations) throws IllegalArgumentException {
        if (borne1 <= 0) {
            throw new IllegalArgumentException("La première borne doit être positive");
        }
        if (borne2 <= 0) {
            throw new IllegalArgumentException("La deuxième borne doit être positive");
        }
        this.grilleAutomate = grilleAutomate;
        this.borne1 = borne1;
        this.borne2 = borne2;
        this.resultats = new LinkedList<List<Integer>>();
        setResultatInitial(this.grilleAutomate.getEtatCellulesInitial());
        this.maxIterations = maxIterations;   
    }

    /**
     * Retourne la grille de l'automate.
     * 
     * @return la grille de l'automate
     */

    public Grille getGrilleAutomate() {
        return grilleAutomate;
    }    

    /**
     * Ajoute une liste d'état initial des cellules à la liste de résultats.
     * 
     * @param etatCellulesInitial est la liste des états initiaux des cellules
     */

    public void setResultatInitial(List<Integer> etatCellulesInitial) {
        this.resultats.add(etatCellulesInitial);
    }

    /**
     * Ajoute une liste d'état des cellules à la liste de résultats.
     * 
     * @param liste est la liste des états des cellules
     */

    public void ajouteListeAResultats(List<Integer> liste) {
        this.resultats.add(liste);
    }

    /**
     * Retourne la liste des résultats.
     * 
     * @return la liste des résultats
     */

    public List<List<Integer>> getResultats() {
        return resultats;
    }

    /**
     * Retourne le dernier résultat de la liste des résultats.
     * 
     * @return le dernier résultat de la liste des résultats
     */

    public List<Integer> getDernierResultat() {
        return this.resultats.get(resultats.size() - 1);
    }

    /**
     * Retourne la liste de la liste des résultats à l'indice iteration.
     * 
     * @param iteration est l'indice de la liste de la liste des résultats
     * @return la liste de la liste des résultats à l'indice iteration
     */

    public List<Integer> getResultatIteration(int iteration) {
        return this.resultats.get(iteration);
    }

    /**
     * Compare deux listes d'état des cellules.
     * 
     * @param tmp est la première liste d'état des cellules
     * @param etatCellules est la deuxième liste d'état des cellules
     * @return true si les deux listes sont égales, sinon false
     */

    public static boolean compareResultats(List<Integer> tmp, List<Integer> etatCellules) {
        return tmp.equals(etatCellules); 
    }    

    /**
     * Calcule la somme des états des cellules voisines pour chaque cellule de la grille.
     * 
     * @param grille est la grille de l'automate
     * @param etatCellules est la liste des états des cellules
     * @return la liste des sommes des états des cellules voisines
     */

    public List<Integer> sommeEtatVivantDesVoisins(Grille grille, List<Integer> etatCellules) {
        List<Integer> listeEtatVivantDesVoisins = new LinkedList<Integer>(); //Liste des voisins de chaque cellule vide
        List<Cellule> cellulesGrille = grille.getCellulesGrille(); //Liste des cellules de la grille
        for (int i = 0; i < cellulesGrille.size(); i++) {
            int somme = 0;
            Cellule celluleCourante = cellulesGrille.get(i);
            for (int j = 0; j < celluleCourante.getCellulesVoisines().size(); j++) {
                int idVoisin = celluleCourante.getCellulesVoisines().get(j); //id du voisin de la cellule courante
                somme += etatCellules.get(idVoisin); //La somme des états des cellules voisines de la cellule courante appartenant à etatCellules
            }
            listeEtatVivantDesVoisins.add(somme); 
        }
        return listeEtatVivantDesVoisins;
    }

    /**
     * Effectue une itération du jeu de la vie pour une liste d'état des cellules.
     * 
     * @param etatCellules est la liste des états des cellules avant l'itération
     */

    public void effectuerIteration(List<Integer> etatCellules) {
        List<Integer> tmpEtat = new LinkedList<Integer>(); //Liste temporaire pour stocker le nouvel état
        for (int i = 0; i < etatCellules.size(); i++) {
            int etatCellule = etatCellules.get(i);
            List<Integer> listeEtatVivantDesVoisins = sommeEtatVivantDesVoisins(this.grilleAutomate, etatCellules); //Liste des voisins de chaque cellule
            if (etatCellule == 1) { //Si la cellule est vivante
                if (listeEtatVivantDesVoisins.get(i) == this.borne1 || listeEtatVivantDesVoisins.get(i) == this.borne2) { //Si la cellule a 2 ou 3 voisins vivants
                    tmpEtat.add(1); //La cellule reste vivante
                }
                else {
                    tmpEtat.add(0); //La cellule meurt
                }
            }
            else if (etatCellule == 0){ //Si la cellule est morte
                if (listeEtatVivantDesVoisins.get(i) == this.borne1) { //Si la cellule a 3 voisins vivants
                    tmpEtat.add(1); //La cellule devient vivante
                }
                else {
                    tmpEtat.add(0); //La cellule reste morte
                }
            }
        }
        ajouteListeAResultats(tmpEtat); //On ajoute le nouvel état à la liste des résultats
    }

    /**
     * Lance le jeu de la vie en effectuant les itérations jusqu'à atteindre le nombre maximum d'itéations.
     * Ou jusqu'à ce que deux itérations successives soient identiques.
     */

    public void lanceJeu() {
        List<Integer> etatCellules = this.grilleAutomate.getEtatCellulesInitial();
        for (int iterationJeu = 0; iterationJeu < this.maxIterations; iterationJeu++) {
            effectuerIteration(etatCellules);
            if (compareResultats(getDernierResultat(), etatCellules)) {
                break;
            }
            else {
                etatCellules = getDernierResultat();
            }
        }
        return;
    }

}