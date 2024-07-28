package principal;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Grille01initialisationGrilleUTest {
    @Test
    public void testGrilleException() {
        assertThatThrownBy(() -> new Grille(0, 3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("La largeur de la grille doit être positive");
        assertThatThrownBy(() -> new Grille(4, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("La hauteur de la grille doit être positive");
    }

    @Test
    public void testComptageDeCellules() {
        Grille gr1 = new Grille(4, 3);
        assertThat(gr1.getCellulesGrille()).hasSize(12);
    }
}
