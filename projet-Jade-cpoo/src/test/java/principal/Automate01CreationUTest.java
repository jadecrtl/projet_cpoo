package principal;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Automate01CreationUTest {

    @Test
    public void testAutomateCreationException() {
        List<Integer> etatCellules = new LinkedList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0));
        Grille grilleAutomate = new Grille(4, 3, etatCellules);

        assertThatThrownBy(() -> new Automate(grilleAutomate, -1, 3, 0)).isInstanceOf(IllegalArgumentException.class).hasMessage("La première borne doit être positive");
        assertThatThrownBy(() -> new Automate(grilleAutomate, 2, -1, 0)).isInstanceOf(IllegalArgumentException.class).hasMessage("La deuxième borne doit être positive");
        assertThatThrownBy(() -> new Automate(grilleAutomate, 0, 3, 0)).isInstanceOf(IllegalArgumentException.class).hasMessage("La première borne doit être positive");
        assertThatThrownBy(() -> new Automate(grilleAutomate, 3, 0, 0)).isInstanceOf(IllegalArgumentException.class).hasMessage("La deuxième borne doit être positive");
    }

    @Test
    public void testAutomate() {
        List<Integer> etatCellules = new LinkedList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0));
        Grille grilleAutomate = new Grille(4, 3, etatCellules);
        Automate automate = new Automate(grilleAutomate, 2, 3, 0);

        assertThat(automate.getGrilleAutomate()).isEqualTo(grilleAutomate);
        assertThat(automate.getGrilleAutomate().getLargeurGrille()).isEqualTo(4);
        assertThat(automate.getGrilleAutomate().getHauteurGrille()).isEqualTo(3);
        assertThat(automate.getGrilleAutomate().getCellulesGrille()).hasSize(12);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(0).getEtatCellule()).isEqualTo(0);
        System.out.println("automate.getGrilleAutomate().getCellulesGrille().get(0).getEtatCellule()" + automate.getGrilleAutomate().getCellulesGrille().get(0).getEtatCellule());
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(1).getEtatCellule()).isEqualTo(1);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(2).getEtatCellule()).isEqualTo(0);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(3).getEtatCellule()).isEqualTo(0);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(4).getEtatCellule()).isEqualTo(1);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(5).getEtatCellule()).isEqualTo(0);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(6).getEtatCellule()).isEqualTo(1);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(7).getEtatCellule()).isEqualTo(0);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(8).getEtatCellule()).isEqualTo(0);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(9).getEtatCellule()).isEqualTo(0);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(10).getEtatCellule()).isEqualTo(1);
        assertThat(automate.getGrilleAutomate().getCellulesGrille().get(11).getEtatCellule()).isEqualTo(0);

        assertThat(automate.getResultatIteration(0)).isEqualTo(grilleAutomate.getEtatCellulesInitial());
        assertThat(automate.getResultatIteration(0)).isEqualTo(etatCellules);

        System.out.println("getResulatIteration(0) : " + automate.getResultatIteration(0));
        System.out.println("automate.getGrilleAutomate().getEtatCellules() : " + automate.getGrilleAutomate().getEtatCellulesInitial());   

    }
}