package principal;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Grille04test6par1UTest {
    @Test
    public void testVoisinsDeChaqueCelluleGrille6par1() {
        Grille gr4 = new Grille(6, 1);
        assertThat(gr4.getCellulesGrille().get(0).getCellulesVoisines()).containsExactly(1);        
        assertThat(gr4.getCellulesGrille().get(1).getCellulesVoisines()).containsExactly(0, 2);
        assertThat(gr4.getCellulesGrille().get(2).getCellulesVoisines()).containsExactly(1, 3);
        assertThat(gr4.getCellulesGrille().get(3).getCellulesVoisines()).containsExactly(2, 4);
        assertThat(gr4.getCellulesGrille().get(4).getCellulesVoisines()).containsExactly(3, 5);
        assertThat(gr4.getCellulesGrille().get(5).getCellulesVoisines()).containsExactly(4);        
    }    
}
