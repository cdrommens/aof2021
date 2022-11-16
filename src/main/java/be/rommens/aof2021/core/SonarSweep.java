package be.rommens.aof2021.core;

import static java.util.stream.Collectors.toList;

import be.rommens.aof2021.model.Measurement;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class SonarSweep {

    private static final Logger LOGGER = LoggerFactory.getLogger(SonarSweep.class);

    private final List<Measurement> measurements;

    private int depthIncreases = 0;

    public SonarSweep(List<String> rawMeasurements) {
        this.measurements = rawMeasurements.stream()
                .map(Measurement::new)
                .collect(toList());
    }

    public void measureDepthIncreases() {
        LOGGER.info(String.format("%d (N/A - no previous measurement", measurements.get(0).getDepth()));
        for(int i = 1; i < measurements.size(); i++) {
            if (measurements.get(i).getDepth() > measurements.get(i-1).getDepth() ) {
                LOGGER.info(String.format("%d (increased)", measurements.get(i).getDepth()));
                this.depthIncreases++;
            } else {
                LOGGER.info(String.format("%d (decreased)", measurements.get(i).getDepth()));
            }
        }
    }

    public int getDepthIncreases() {
        return depthIncreases;
    }
}
