package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class JeuDeLaVie01CreationUTest {

    @Test
    public void testJeuDeLaVieInitialisation() {
        Grille grille = JeuDeLaVie.lireFichierEtCreerGrille("src/main/java/resources/clock-step0.life");
        assertThat(grille.getCellulesGrille()).hasSize(36);
        assertThat(grille.getLargeurGrille()).isEqualTo(6);
        assertThat(grille.getHauteurGrille()).isEqualTo(6);
        assertThat(grille.getCellulesGrille().get(0).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(1).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(2).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(3).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(4).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(5).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(6).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(7).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(8).getEtatCellule()).isEqualTo(1);
        assertThat(grille.getCellulesGrille().get(9).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(10).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(11).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(12).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(13).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(14).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(15).getEtatCellule()).isEqualTo(1);
        assertThat(grille.getCellulesGrille().get(16).getEtatCellule()).isEqualTo(1);
        assertThat(grille.getCellulesGrille().get(17).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(18).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(19).getEtatCellule()).isEqualTo(1);
        assertThat(grille.getCellulesGrille().get(20).getEtatCellule()).isEqualTo(1);
        assertThat(grille.getCellulesGrille().get(21).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(22).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(23).getEtatCellule()).isEqualTo(0);        
        assertThat(grille.getCellulesGrille().get(24).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(25).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(26).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(27).getEtatCellule()).isEqualTo(1);
        assertThat(grille.getCellulesGrille().get(28).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(29).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(30).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(31).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(32).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(33).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(34).getEtatCellule()).isEqualTo(0);
        assertThat(grille.getCellulesGrille().get(35).getEtatCellule()).isEqualTo(0);        

    }
    
}
