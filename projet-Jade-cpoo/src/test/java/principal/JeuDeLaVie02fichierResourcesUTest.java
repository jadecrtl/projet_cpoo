package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileWriter;

public class JeuDeLaVie02fichierResourcesUTest {

    @Test
    public void testSurFichierClockStep0SurUneIteration() {
        //Chemin vers le fichier qu'on veut tester
        String fic = "src/main/java/resources/clock-step0.life";

        //Création de la grille à partir du fichier
        Grille gr2 = JeuDeLaVie.lireFichierEtCreerGrille(fic);

        //Assertion pour être sur que la grille est bien créée
        assertThat(gr2.getCellulesGrille()).hasSize(36);
        assertThat(gr2.getLargeurGrille()).isEqualTo(6);
        assertThat(gr2.getHauteurGrille()).isEqualTo(6);

        //Création de l'automate à partir de la grille
        Automate auto2 = new Automate(gr2, 3, 2, 2);

        //Lancement du jeu de la vie sur l'automate
        auto2.lanceJeu();

        //création du fichier résultat
        String nomFicRes = "resultatIte0ClockStep";
        FileWriter ficRes = JeuDeLaVie.creerFichierResultat(nomFicRes);

        JeuDeLaVie.dessinerGrilleIteration(ficRes, gr2, auto2.getResultatIteration(0));

        JeuDeLaVie.fermerFichier(ficRes);

    }    

    @Test
    public void testSurFichierGliderStepSurUneIteration() {
        //Chemin vers le fichier qu'on veut tester
        String fic = "src/main/java/resources/glider-step0.life";

        //Création de la grille à partir du fichier
        Grille gr2 = JeuDeLaVie.lireFichierEtCreerGrille(fic);

        //Assertion pour être sur que la grille est bien créée
        assertThat(gr2.getCellulesGrille()).hasSize(400);
        assertThat(gr2.getLargeurGrille()).isEqualTo(20);
        assertThat(gr2.getHauteurGrille()).isEqualTo(20);

        //Création de l'automate à partir de la grille
        Automate auto2 = new Automate(gr2, 3, 2, 2);

        //Lancement du jeu de la vie sur l'automate
        auto2.lanceJeu();

        //création du fichier résultat
        String nomFicRes = "resultatIte0GliderStep";
        FileWriter ficRes = JeuDeLaVie.creerFichierResultat(nomFicRes);

        JeuDeLaVie.dessinerGrilleIteration(ficRes, gr2, auto2.getResultatIteration(0));

        JeuDeLaVie.fermerFichier(ficRes);

    }    

    @Test
    public void testSurFichierClockStep0SurResultats() {
        //Chemin vers le fichier qu'on veut tester
        String fic = "src/main/java/resources/clock-step0.life";

        //Création de la grille à partir du fichier
        Grille gr2 = JeuDeLaVie.lireFichierEtCreerGrille(fic);

        //Assertion pour être sur que la grille est bien créée
        assertThat(gr2.getCellulesGrille()).hasSize(36);
        assertThat(gr2.getLargeurGrille()).isEqualTo(6);
        assertThat(gr2.getHauteurGrille()).isEqualTo(6);

        //Création de l'automate à partir de la grille
        Automate auto2 = new Automate(gr2, 3, 2, 10);

        //Lancement du jeu de la vie sur l'automate
        auto2.lanceJeu();

        //création du fichier résultat
        String nomFicRes = "resultatFinalClockStep";
        FileWriter ficRes = JeuDeLaVie.creerFichierResultat(nomFicRes);

        JeuDeLaVie.dessinerGrilleDeResultats(ficRes, gr2, auto2);

        JeuDeLaVie.fermerFichier(ficRes);

    }        

    @Test
    public void testSurFichierGliderStepSurResultats() {
        //Chemin vers le fichier qu'on veut tester
        String fic = "src/main/java/resources/glider-step0.life";

        //Création de la grille à partir du fichier
        Grille gr2 = JeuDeLaVie.lireFichierEtCreerGrille(fic);

        //Assertion pour être sur que la grille est bien créée
        assertThat(gr2.getCellulesGrille()).hasSize(400);
        assertThat(gr2.getLargeurGrille()).isEqualTo(20);
        assertThat(gr2.getHauteurGrille()).isEqualTo(20);

        //Création de l'automate à partir de la grille
        Automate auto2 = new Automate(gr2, 3, 2, 69);

        //Lancement du jeu de la vie sur l'automate
        auto2.lanceJeu();

        //création du fichier résultat
        String nomFicRes = "resultatFinalGliderStep";
        FileWriter ficRes = JeuDeLaVie.creerFichierResultat(nomFicRes);

        JeuDeLaVie.dessinerGrilleDeResultats(ficRes, gr2, auto2);

        JeuDeLaVie.fermerFichier(ficRes);

    }        

    @Test
    public void testSurFichierGosperGliderGunStepTestSurUneIteration() {
        //Chemin vers le fichier qu'on veut tester
        String fic = "src/main/java/resources/gosper-glider-gun-step0.life";

        //Création de la grille à partir du fichier
        Grille gr2 = JeuDeLaVie.lireFichierEtCreerGrille(fic);

        //Assertion pour être sur que la grille est bien créée
        assertThat(gr2.getCellulesGrille()).hasSize(1080);
        assertThat(gr2.getLargeurGrille()).isEqualTo(36);
        assertThat(gr2.getHauteurGrille()).isEqualTo(30);

        //Création de l'automate à partir de la grille
        Automate auto2 = new Automate(gr2, 3, 2, 2);

        //Lancement du jeu de la vie sur l'automate
        auto2.lanceJeu();

        //création du fichier résultat
        String nomFicRes = "resultatIte0GosperGliderGunStepTest";
        FileWriter ficRes = JeuDeLaVie.creerFichierResultat(nomFicRes);

        JeuDeLaVie.dessinerGrilleIteration(ficRes, gr2, auto2.getResultatIteration(0));

        JeuDeLaVie.fermerFichier(ficRes);

    }

    @Test
    public void testSurFichierGosperGliderGunStepTestSurResultats() {
        //Chemin vers le fichier qu'on veut tester
        String fic = "src/main/java/resources/gosper-glider-gun-step0.life";

        //Création de la grille à partir du fichier
        Grille gr2 = JeuDeLaVie.lireFichierEtCreerGrille(fic);

        //Assertion pour être sur que la grille est bien créée
        assertThat(gr2.getCellulesGrille()).hasSize(1080);
        assertThat(gr2.getLargeurGrille()).isEqualTo(36);
        assertThat(gr2.getHauteurGrille()).isEqualTo(30);

        //Création de l'automate à partir de la grille
        Automate auto2 = new Automate(gr2, 3, 2, 31);

        //Lancement du jeu de la vie sur l'automate
        auto2.lanceJeu();

        //création du fichier résultat
        String nomFicRes = "resultatFinalGosperGliderGunStepTest";
        FileWriter ficRes = JeuDeLaVie.creerFichierResultat(nomFicRes);

        JeuDeLaVie.dessinerGrilleDeResultats(ficRes, gr2, auto2);

        JeuDeLaVie.fermerFichier(ficRes);

    }    

    
}
