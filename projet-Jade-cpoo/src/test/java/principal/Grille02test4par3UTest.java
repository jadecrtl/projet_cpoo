package principal;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Grille02test4par3UTest {
    @Test
    public void testVoisinsDeChaqueCelluleGrille4par3() {
        Grille gr2 = new Grille(4, 3);
        assertThat(gr2.getCellulesGrille().get(0).getCellulesVoisines()).containsExactly(1, 4, 
        5);        
        assertThat(gr2.getCellulesGrille().get(1).getCellulesVoisines()).containsExactly(0, 2, 4, 5, 6);
        assertThat(gr2.getCellulesGrille().get(2).getCellulesVoisines()).containsExactly(1, 3, 5, 6, 7);        
        assertThat(gr2.getCellulesGrille().get(3).getCellulesVoisines()).containsExactly(2, 6, 
        7);        
        assertThat(gr2.getCellulesGrille().get(4).getCellulesVoisines()).containsExactly(0, 1, 5, 8, 9);        
        assertThat(gr2.getCellulesGrille().get(5).getCellulesVoisines()).containsExactly(0, 1, 2, 4, 6, 8, 9, 10);        
        assertThat(gr2.getCellulesGrille().get(6).getCellulesVoisines()).containsExactly(1, 2, 3, 5, 7, 9, 10, 11);                        
        assertThat(gr2.getCellulesGrille().get(7).getCellulesVoisines()).containsExactly(2, 3, 6, 10, 11);                
        assertThat(gr2.getCellulesGrille().get(8).getCellulesVoisines()).containsExactly(4, 5, 9);                
        assertThat(gr2.getCellulesGrille().get(9).getCellulesVoisines()).containsExactly(4, 5, 6, 8, 10);                
        assertThat(gr2.getCellulesGrille().get(10).getCellulesVoisines()).containsExactly(5, 6, 7, 9, 11);                
        assertThat(gr2.getCellulesGrille().get(11).getCellulesVoisines()).containsExactly(6, 7, 10);                
    }
}
