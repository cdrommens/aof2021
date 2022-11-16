package be.rommens.aof2021.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 *
 */
public class SonarSweepTest {

    @Test
    void testMeasureDepthIncreases() {
        SonarSweep sonarSweep = new SonarSweep(List.of("199", "200", "208", "210", "200", "207", "240", "269", "260", "263"));
        sonarSweep.measureDepthIncreases(3);
        assertThat(sonarSweep.getDepthIncreases()).isEqualTo(5);
    }

}
