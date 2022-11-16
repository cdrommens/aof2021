package be.rommens.aof2021.service;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class SonarSweepServiceTest {

    @Test
    void measureDepthIncreases() {
        SonarSweepService sonarSweepService = new SonarSweepService();
        sonarSweepService.measureDepthIncreases("classpath:depth.txt");
    }

}
