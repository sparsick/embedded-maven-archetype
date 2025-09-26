package dev.parsick.poc.embedded_maven_archetype;

import org.apache.maven.archetype.ArchetypeGenerationRequest;
import org.apache.maven.archetype.ArchetypeGenerationResult;
import org.apache.maven.archetype.ArchetypeManager;
import org.apache.maven.archetype.catalog.Archetype;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.repository.RemoteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

@Component
public class ProjectGenerator {


    private final RepositorySystemSession repositorySystemSession;
    private final List<RemoteRepository> remoteRepositories;
    ArchetypeManager archetypeManager;

    public ProjectGenerator(ArchetypeManager archetypeManager, RepositorySystemSession repositorySystemSession, List<RemoteRepository> remoteRepositories) {
        this.archetypeManager = archetypeManager;
        this.repositorySystemSession = repositorySystemSession;
        this.remoteRepositories = remoteRepositories;
    }

    public ArchetypeGenerationResult generate() {
        Archetype archetype = new Archetype();
        archetype.setGroupId("org.apache.maven.archetypes");
        archetype.setArtifactId("maven-archetype-quickstart");
        archetype.setVersion("1.5");
        ArchetypeGenerationRequest archetypeGenerationRequest = new ArchetypeGenerationRequest(archetype);
        archetypeGenerationRequest.setGroupId("com.example");
        archetypeGenerationRequest.setArtifactId("java-example");
        archetypeGenerationRequest.setVersion("1.0.0-SNAPSHOT");
        archetypeGenerationRequest.setPackage("com.example");
        archetypeGenerationRequest.setRepositorySession(repositorySystemSession);
        archetypeGenerationRequest.setRemoteRepositories(remoteRepositories);
        archetypeGenerationRequest.setOutputDirectory("./target");
        Properties archetypeProperties = new Properties();
        archetypeProperties.setProperty("javaCompilerVersion", "21");
        archetypeProperties.setProperty("junitVersion", "5");
//        archetypeProperties.setProperty("package", "jar");
        archetypeGenerationRequest.setProperties(archetypeProperties);



        return archetypeManager.generateProjectFromArchetype(archetypeGenerationRequest);
    }
}
