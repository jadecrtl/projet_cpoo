package principal;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Grille05sommeEtatVivantDesVoisinsUTest {
    @Test
    public void sommeEtatVivantDesVoisins() {

        //Creation de la grille avec ses etats
        List<Integer> etatCellulesInitial = new LinkedList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0));
        Grille gr5 = new Grille(4, 3, etatCellulesInitial);

        //Creation de l'automate avec la grille
        Automate automate = new Automate(gr5, 3, 2, 30);                

        //Test sur la méthode sommeEtatVivantDesVoisins
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(0)).isEqualTo(2);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(1)).isEqualTo(2);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(2)).isEqualTo(2);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(3)).isEqualTo(1);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(4)).isEqualTo(1);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(5)).isEqualTo(4);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(6)).isEqualTo(2);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(7)).isEqualTo(2);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(8)).isEqualTo(1);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(9)).isEqualTo(3);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(10)).isEqualTo(1);
        assertThat(automate.sommeEtatVivantDesVoisins(automate.getGrilleAutomate(), etatCellulesInitial).get(11)).isEqualTo(2);

    }
}