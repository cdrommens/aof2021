package be.rommens.aof2021.core;

import static java.lang.Math.min;
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

    public void measureDepthIncreases(int windowSize) {
        int previousSum = sum(0, windowSize);
        LOGGER.info(String.format("%d (N/A - no previous sum", previousSum));

        int i = 1;
        while (i + windowSize <= this.measurements.size()) {
            int currentSum = sum(i, windowSize);
            if (currentSum > previousSum ) {
                LOGGER.info(String.format("%d (increased)", currentSum));
                this.depthIncreases++;
            } else {
                LOGGER.info(String.format("%d (decreased)", currentSum));
            }
            previousSum = currentSum;
            i++;
        }
    }

    public int getDepthIncreases() {
        return depthIncreases;
    }

    private int sum (int startIndex, int numberOfArguments) {
        return this.measurements.subList(startIndex, min(startIndex + numberOfArguments, this.measurements.size()))
                .stream()
                .map(Measurement::getDepth)
                .reduce(0, Integer::sum);
    }
}
