package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Automate04lanceJeuTestUTest {
    
    @Test
    public void lanceJeuTest3par3() {
        //Creation de la grille avec ses etats
        List<Integer> etatCellules = new LinkedList<>(Arrays.asList(1, 0, 1, 0, 1, 1, 0, 0, 0));
        Grille gr1 = new Grille(3, 3, etatCellules);

        //Creation de l'automate avec la grille
        Automate auto1 = new Automate(gr1, 3, 2, 5);   

        //Lancement du jeu
        auto1.lanceJeu();

        //Verification de l'etat de resultats
        assertThat(auto1.getResultatIteration(0)).isEqualTo(gr1.getEtatCellulesInitial());
        assertThat(auto1.getResultatIteration(1)).isEqualTo(Arrays.asList(0, 0, 1 ,0, 1, 1, 0, 0, 0));
        assertThat(auto1.getResultatIteration(2)).isEqualTo(Arrays.asList(0, 1, 1, 0, 1, 1, 0, 0, 0));
        assertThat(auto1.getDernierResultat()).isEqualTo(Arrays.asList(0, 1, 1, 0, 1, 1, 0, 0, 0));


    }


}
