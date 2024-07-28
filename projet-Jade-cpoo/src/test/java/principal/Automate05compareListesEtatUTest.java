package principal;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Automate05compareListesEtatUTest {
    
    @Test
    public void compareResultats() {
        List<Integer> etatCellules1 = new LinkedList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0));
        List<Integer> etatCellules2 = new LinkedList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1));

        assertThat(Automate.compareResultats(etatCellules1, etatCellules2)).isEqualTo(false);

        List<Integer> etatCellules3 = new LinkedList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0));
        List<Integer> etatCellules4 = new LinkedList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0));

        assertThat(Automate.compareResultats(etatCellules3, etatCellules4)).isEqualTo(true);
    }

}
