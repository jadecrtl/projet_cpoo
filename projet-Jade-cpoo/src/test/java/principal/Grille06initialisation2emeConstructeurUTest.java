package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Grille06initialisation2emeConstructeurUTest {
    @Test
    public void testCreationGrilleException2emeConstructeur() {
        assertThatThrownBy(() -> new Grille(0, 3, new LinkedList<Integer>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("La largeur de la grille doit être positive");
        assertThatThrownBy(() -> new Grille(4, 0, new LinkedList<Integer>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("La hauteur de la grille doit être positive");
        assertThatThrownBy(() -> new Grille(4, 3, new LinkedList<Integer>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("La taille de la liste d'état des cellules doit être égale à la taille de la grille");
    }

    @Test
    public void testCreationGrille2emeConstructeur() {
        List<Integer> etatCellules = new LinkedList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0));
        Grille gr6 = new Grille(4, 3, etatCellules);
        assertThat(gr6.getCellulesGrille()).hasSize(12);
        assertThat(gr6.getCellulesGrille().get(0).getEtatCellule()).isEqualTo(0);
        assertThat(gr6.getCellulesGrille().get(1).getEtatCellule()).isEqualTo(1);
        assertThat(gr6.getCellulesGrille().get(2).getEtatCellule()).isEqualTo(0);
        assertThat(gr6.getCellulesGrille().get(3).getEtatCellule()).isEqualTo(0);
        assertThat(gr6.getCellulesGrille().get(4).getEtatCellule()).isEqualTo(1);
        assertThat(gr6.getCellulesGrille().get(5).getEtatCellule()).isEqualTo(0);
        assertThat(gr6.getCellulesGrille().get(6).getEtatCellule()).isEqualTo(1);
        assertThat(gr6.getCellulesGrille().get(7).getEtatCellule()).isEqualTo(0);
        assertThat(gr6.getCellulesGrille().get(8).getEtatCellule()).isEqualTo(0);
        assertThat(gr6.getCellulesGrille().get(9).getEtatCellule()).isEqualTo(0);
        assertThat(gr6.getCellulesGrille().get(10).getEtatCellule()).isEqualTo(1);
        assertThat(gr6.getCellulesGrille().get(11).getEtatCellule()).isEqualTo(0);
    }
}
