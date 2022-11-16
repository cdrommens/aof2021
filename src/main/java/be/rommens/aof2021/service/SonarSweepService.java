package be.rommens.aof2021.service;

import be.rommens.aof2021.core.SonarSweep;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

/**
 *
 */
@Service
public class SonarSweepService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SonarSweepService.class);

    public void measureDepthIncreases(String path) {
        try {
            List<String> rawMeasurements = readInput(path);
            SonarSweep sonarSweep = new SonarSweep(rawMeasurements);
            sonarSweep.measureDepthIncreases();
            LOGGER.info(String.format("There are %d measurements that are larger than the previous measurement.", sonarSweep.getDepthIncreases()));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private List<String> readInput(String path) throws IOException {
        return Files.readAllLines(ResourceUtils.getFile(path).toPath());
    }

}
