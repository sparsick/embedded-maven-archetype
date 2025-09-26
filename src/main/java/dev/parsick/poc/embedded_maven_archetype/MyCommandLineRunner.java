package dev.parsick.poc.embedded_maven_archetype;

import org.apache.maven.archetype.ArchetypeGenerationResult;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {


    private final ProjectGenerator projectGenerator;

    public MyCommandLineRunner(ProjectGenerator projectGenerator) {
        this.projectGenerator = projectGenerator;
    }

    @Override
    public void run(String... args) throws Exception {
        ArchetypeGenerationResult result = projectGenerator.generate();

        if (result.getCause() != null) {
            result.getCause().printStackTrace();
        }
    }
}
