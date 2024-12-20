package org.blue.dwbackendhive.initializer;
import org.blue.dwbackendhive.service.HiveTableService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer implements CommandLineRunner {

    private final HiveTableService hiveTableService;

    public AppInitializer(HiveTableService hiveTableService) {
        this.hiveTableService = hiveTableService;
    }

    @Override
    public void run(String... args) throws Exception {
        hiveTableService.createTables();
    }
}