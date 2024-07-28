package principal;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Grille03test1par6UTest {
    @Test
    public void testVoisinsDeChaqueCelluleGrille1par6() {
        Grille gr3 = new Grille(1, 6);
        assertThat(gr3.getCellulesGrille().get(0).getCellulesVoisines()).containsExactly(1);        
        assertThat(gr3.getCellulesGrille().get(1).getCellulesVoisines()).containsExactly(0, 2);                
        assertThat(gr3.getCellulesGrille().get(2).getCellulesVoisines()).containsExactly(1, 3);        
        assertThat(gr3.getCellulesGrille().get(3).getCellulesVoisines()).containsExactly(2, 4);        
        assertThat(gr3.getCellulesGrille().get(4).getCellulesVoisines()).containsExactly(3, 5);        
        assertThat(gr3.getCellulesGrille().get(5).getCellulesVoisines()).containsExactly(4);
    }
}
