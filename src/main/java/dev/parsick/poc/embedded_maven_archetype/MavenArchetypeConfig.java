package dev.parsick.poc.embedded_maven_archetype;

import eu.maveniverse.maven.mima.context.Context;
import eu.maveniverse.maven.mima.context.ContextOverrides;
import eu.maveniverse.maven.mima.context.Runtimes;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.repository.RemoteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"org.apache.maven.archetype", "org.codehaus.plexus.velocity", "org.apache.maven.shared.invoker"}
)
public class MavenArchetypeConfig {

    @Bean
    RepositorySystem repositorySystem(Context context) {
        return context.repositorySystem();
    }

    @Bean
    RepositorySystemSession repositorySystemSession(Context context) {
        return context.repositorySystemSession();
    }

    @Bean
    List<RemoteRepository> remoteRepositories(Context context) {

        return context.remoteRepositories();
    }

    @Bean
    Context mavenContext() {
        ContextOverrides contextOverrides = ContextOverrides.create().withUserSettings(true).build();
        return Runtimes.INSTANCE.getRuntime().create(contextOverrides);
    }




}
