package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Automate02effectuerIteUTest {
    
    @Test
    public void effectuerIterationTestInitial() {

        //Creation de la grille avec ses etats
        List<Integer> etatCellules = new LinkedList<>(Arrays.asList(1, 0, 1, 0, 1, 1, 0, 0, 0));
        Grille gr1 = new Grille(3, 3, etatCellules);

        //Creation de l'automate avec la grille
        Automate auto1 = new Automate(gr1, 3, 2, 30);      
          
        //Verification de l'etat de l'automate
        assertThat(auto1.getResultatIteration(0)).isEqualTo(gr1.getEtatCellulesInitial());
        assertThat(auto1.getDernierResultat()).isEqualTo(gr1.getEtatCellulesInitial());
    }

    @Test
    public void effectuerIterationTest01et2() {

        //Creation de la grille avec ses etats
        List<Integer> etatCellules = new LinkedList<>(Arrays.asList(1, 0, 1, 0, 1, 1, 0, 0, 0));
        Grille gr1 = new Grille(3, 3, etatCellules);

        //Creation de l'automate avec la grille
        Automate auto1 = new Automate(gr1, 3, 2, 30);      
          
        //Première itération 
        auto1.effectuerIteration(auto1.getDernierResultat());
        assertThat(auto1.getDernierResultat()).isEqualTo(Arrays.asList(0, 0, 1 ,0, 1, 1, 0, 0, 0));

        
        //Deuxième itération
        auto1.effectuerIteration(auto1.getDernierResultat());
        assertThat(auto1.getDernierResultat()).isEqualTo(Arrays.asList(0, 1, 1, 0, 1, 1, 0, 0, 0));

    }    


}
