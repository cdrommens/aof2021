package be.rommens.aof2021;

import be.rommens.aof2021.service.SonarSweepService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Aof2021Application {

    private final SonarSweepService sonarSweepService;

    public Aof2021Application(SonarSweepService sonarSweepService) {
        this.sonarSweepService = sonarSweepService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Aof2021Application.class, args);
    }

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        sonarSweepService.measureDepthIncreases("classpath:input.txt");
    }

}