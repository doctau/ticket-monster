package org.jboss.examples.ticketmonster.test;

import java.io.File;

import org.jboss.examples.ticketmonster.util.Resources;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;


public class TicketMonsterDeployment {

    public static WebArchive deployment() {
    	PomEquippedResolveStage resolver = Maven.configureResolverViaPlugin();
        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addAsLibraries(resolver.resolve("org.scala-lang:scala-library").withoutTransitivity().as(File.class))
                .addPackage(Resources.class.getPackage())
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsResource("import.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml");
    }
}
