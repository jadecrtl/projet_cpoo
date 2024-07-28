package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Automate03setResultatUTest {
    
    @Test
    public void setResultatTest() {
        List<Integer> etatCellules0 = Arrays.asList(1, 0, 1, 0, 1, 1, 0, 0, 0);
        Grille grilleTest = new Grille(3, 3, etatCellules0);

        Automate automate = new Automate(grilleTest, 3, 2, 30);        

        List<Integer> etatCellules1 = new LinkedList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0));

        automate.ajouteListeAResultats(etatCellules1);

        assertThat(automate.getResultatIteration(0)).isEqualTo(etatCellules0);
        assertThat(automate.getResultatIteration(1)).isEqualTo(etatCellules1);



    }


}
