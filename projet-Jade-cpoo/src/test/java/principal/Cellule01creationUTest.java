package principal;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class Cellule01creationUTest {
    
    @Test
    public void testCelluleIdNegatif() {
        assertThatThrownBy(() -> new Cellule(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("L'id de la cellule doit être positif");
    }

    @Test
    public void testCelluleEtat() {
        Cellule cel1 = new Cellule(0);
        assertThat(cel1.getIdCellule()).isEqualTo(0);
        cel1.setEtatMort();
        assertThat(cel1.getEtatCellule()).isEqualTo(0);
        cel1.setEtatVivant();
        assertThat(cel1.getEtatCellule()).isEqualTo(1);
    }

    @Test
    public void testCelluleVoisines() {
        Cellule cel2 = new Cellule(0);
        assertThat(cel2.getCellulesVoisines()).isEmpty();
        cel2.setCellulesVoisines(List.of(1, 2, 3));
        assertThat(cel2.getCellulesVoisines()).contains(1);
        assertThat(cel2.getCellulesVoisines()).contains(2);
        assertThat(cel2.getCellulesVoisines()).contains(3);
        assertThat(cel2.getCellulesVoisines()).doesNotContain(4);
    }

}
