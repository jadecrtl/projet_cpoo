package principal;
import java.util.List;
import java.util.LinkedList;

/**
 * La classe Cellule représente une cellule dans un automate cellulaire.
 * Elle possède une identifiant, un état et une liste d'identifiants de cellules voisines.
 */

public class Cellule {
    private int idCellule;
    private int etatCellule;
    List<Integer> cellulesVoisines;

    /**
     * Constructeur de la classe Cellule.
     * 
     * @param idCellule est l'identifiant de la cellule
     * @throws IllegalArgumentException si l'identifiant de la cellule est négatif
     */

    public Cellule(int idCellule) throws IllegalArgumentException {
        if(idCellule < 0) {
            throw new IllegalArgumentException("L'id de la cellule doit être positif");
        }
        this.idCellule = idCellule;
        cellulesVoisines = new LinkedList<Integer>();
    }

    /**
     * Retourne l'identifiant de la cellule.
     * 
     * @return l'identifiant de la cellule
     */

    public int getIdCellule() {
        return idCellule;
    }

    /**
     * Retourne l'état de la cellule.
     * 
     * @return l'état de la cellule
     */    
    
    public int getEtatCellule() {
        return etatCellule;
    }

    
    /**
     * Retourne la liste des identifiants des cellules voisines.
     * 
     * @return la liste des identifiants des cellules voisines
     */

    public List<Integer> getCellulesVoisines() {
        return cellulesVoisines;
    }

    /**
     * Modifie l'état de la cellule.
     * 
     * @param etatCellule est le nouvel état de la cellule
     */

    public void setEtatCellule(int etatCellule) {
        this.etatCellule = etatCellule;
    }

    /**
     * Modifie l'état de la cellule à vivant.
     * Elle utilise la méthode setEtatCellule() en lui passant 1 en paramètre.
     */

    public void setEtatVivant() {
        setEtatCellule(1);
    }

    /**
     * Modifie l'état de la cellule à mort.
     * Elle utilise la méthode setEtatCellule() en lui passant 0 en paramètre.
     */

    public void setEtatMort() {
        setEtatCellule(0);
    }

    /**
     * Modifie la liste des identifiants des cellules voisines.
     * 
     * @param cellulesVoisines est la nouvelle liste des identifiants des cellules voisines
     */

    public void setCellulesVoisines(List<Integer> cellulesVoisines) {
        this.cellulesVoisines = cellulesVoisines;
    }

}
