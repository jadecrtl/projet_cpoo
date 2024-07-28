package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import enums.Couleur;
import utils.Dialogue;
import utils.TerminalAffichage;

/**
 * La classe JeuDeLaVie est la classe principale du projet.
 * Elle permet de lire les données d'une grille à partir d'un fichier,
 * d'exécuter les itérations du jeu, de sauvegarder les résultats dans un fichier en les dessinant sous forme de grille.
 */

public class JeuDeLaVie {

    /**
     * Méthode principale qui lance l'application du Jeu de la Vie.
     * 
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        
        TerminalAffichage terminal = new TerminalAffichage();
        Dialogue dialogue = new Dialogue();

        terminal.effaceEcran();
        terminal.println(Couleur.MAUVE.getCrayon(), "*******************");
        terminal.println(Couleur.MAUVE.getCrayon(), "*****Bonjour voici le Jeu de la Vie!*****");

        String fichier = dialogue.demandeString(Couleur.VERT.getCrayon(), "Entrez le chemin vers le fichier contenant les données de la grille :");
        Grille grille = lireFichierEtCreerGrille(fichier);
        int maxIterations = dialogue.demandeInt(Couleur.VERT.getCrayon(), "Entrez le nombre maximum d'itérations :");
        Automate automate = new Automate(grille, 3, 2, maxIterations);
        automate.lanceJeu();
        String nomFichier = dialogue.demandeString(Couleur.VERT.getCrayon(), "Entrez le nom du fichier dans lequel vous voulez sauvegarder les résultats :");
        FileWriter ficRes = creerFichierResultat(nomFichier);
        dessinerGrilleDeResultats(ficRes, grille, automate);
        fermerFichier(ficRes);
    }

    /**
     * Lit les données d'une grille à partir d'un fichier et crée la grille correspondante.
     * 
     * @param fichier est le chemin vers le fichier contenant les données de la grille
     * @return la grille créée
     */

    public static Grille lireFichierEtCreerGrille(String fichier) {
        try {
            BufferedReader lecteur = new BufferedReader(new FileReader(fichier));

            // Lecture de la largeur de la grille
            int hauteurGrille = Integer.parseInt(lecteur.readLine());

            // Lecture de la hauteur de la grille
            int largeurGrille = Integer.parseInt(lecteur.readLine());

            // Lecture des états des cellules
            List<Integer> etatCellules = new ArrayList<>();
            for (int i = 0; i < hauteurGrille; i++) {
                String ligne = lecteur.readLine();
                for (int j = 0; j < largeurGrille; j++) {
                    char etat = ligne.charAt(j);
                    etatCellules.add(etat - '0');
                }
            }

            // Création de la grille avec les données lues
            Grille grille = new Grille(largeurGrille, hauteurGrille, etatCellules);

            // Fermeture du lecteur
            lecteur.close();
            
            return grille;
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            return null;
        }
    }    

    /**
     * Crée un fichier résultat pour sauvegarder les grilles générées par le jeu.
     * 
     * @param nomFichier est le nom du fichier résultat à créer
     * @return le FileWriter correspondant au fichier résultat créé
     */

    public static FileWriter creerFichierResultat(String nomFichier) {
        try {
            FileWriter writer = new FileWriter(nomFichier + ".txt");
            System.out.println("Le fichier résultat a été créé avec succès !");
            return writer;
        } catch (IOException e) {
            System.out.println("Erreur lors de la création du fichier résultat : " + e.getMessage());
            return null;
        }
    }

    /**
     * Dessine les grilles résultantes dans un fichier.
     * 
     * @param writer est le FileWriter correspondant au fichier dans lequel dessiner les grilles
     * @param grille est la grille initiale
     * @param automate est l'automate du jeu
     */

    public static void dessinerGrilleDeResultats(FileWriter writer, Grille grille, Automate automate) {
        try {
            for (int i = 0; i < automate.getResultats().size(); i++) {
                writer.write("Dessin de la grille " + i + " (itération " + (i) + "):\n");

                List<Integer> listeEtatCellules = automate.getResultatIteration(i);
                dessinerGrilleIteration(writer, grille, listeEtatCellules);

                writer.write("\n\n");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }

    /**
     * Ferme le fichier résultat.
     * 
     * @param writer est le FileWriter correspondant au fichier résultat à fermer
     */

    public static void fermerFichier(FileWriter writer) {
        try {
            writer.close();
            System.out.println("Le fichier résultat a été fermé avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la fermeture du fichier résultat : " + e.getMessage());
        }
    }    

    /**
     * Dessine une grille à une itération donnée.
     * 
     * @param writer est le FileWriter correspondant au fichier dans lequel dessiner la grille
     * @param grille est la grille initiale
     * @param etatCellules est la liste des états des cellules à l'itération donnée
     * 
     */

    public static void dessinerGrilleIteration(FileWriter writer, Grille grille, List<Integer> etatCellules) {
        try {
            // Récupérer les informations de la grille à partir de l'objet Grille
            int largeurGrille = grille.getLargeurGrille();
            int hauteurGrille = grille.getHauteurGrille();
            
            // Dessiner la bordure supérieure
            writer.write("+" + "-".repeat(largeurGrille) + "+\n");
            
            // Dessiner les lignes de la grille
            for (int i = 0; i < hauteurGrille; i++) {
                writer.write("|");
                for (int j = 0; j < largeurGrille; j++) {
                    int index = i * largeurGrille + j;
                    int etat = etatCellules.get(index);
                
                    // Dessiner l'état de la cellule
                    if (etat == 0) {
                        writer.write(" ");
                    } else if (etat == 1) {
                        writer.write("*");
                    }
                }
                writer.write("|\n");
            }
            // Dessiner la bordure inférieure
            writer.write("+" + "-".repeat(largeurGrille) + "+\n");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
    
}