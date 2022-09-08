package io.quarkus.sample.superheroes.fight.config;

import java.util.Arrays;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.config.MeterFilter;

@Singleton
public class CustomConfiguration {
    
    @ConfigProperty(name = "application.runtime")
    String appRuntime;

    @ConfigProperty(name = "quarkus.application.name")
    String appName;

    /** Define common tags that apply globally */
    @Produces
    @Singleton
    public MeterFilter configureAllRegistries() {
        return MeterFilter.commonTags(Arrays.asList(
                Tag.of("application", appName), 
                Tag.of("runtime", appRuntime)));
    }

}