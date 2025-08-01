package edu.sdmesa.cisc191;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.runner.JUnitCore;

/**
 * Lead Author(s):
 * 
 * @author Dom David
 * 
 * Other contributors:
 * 
 * Allan Schougaard
 * 
 * References:
 * @see Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *      Problem Solving.
 *      https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * @see Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt,
 *      J. D., & Stein, C. (n.d.). JUnit 5 user guide. JUnit 5.
 *      https://junit.org/junit5/docs/current/user-guide/
 * 
 * @version 2025.01.25.001
 * 
 * Responsibilities of class:
 * Test the function of Logic.java
 * 
 */

public class TestLogic {

    public static void main(String[] args) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
            .selectors(DiscoverySelectors.selectClass(Tests.class))
            .build();

        Launcher launcher = LauncherFactory.create();

        // Listener for live test logging
        TestResultListener liveListener = new TestResultListener();
        launcher.registerTestExecutionListeners(liveListener);

        // Listener for summary stats (including success count)
        SummaryGeneratingListener summaryListener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(summaryListener);

        // Run tests
        launcher.execute(request);

        // Output summary
        TestExecutionSummary summary = summaryListener.getSummary();

        System.out.println("------------------------------------------------");
        System.out.println("Number of tests found     : " + summary.getTestsFoundCount());
        System.out.println("Number of tests succeeded : " + summary.getTestsSucceededCount());
        System.out.println("Number of tests failed    : " + summary.getTestsFailedCount());
        System.out.println("Number of tests skipped   : " + summary.getTestsSkippedCount());
        System.out.println("------------------------------------------------");

        if (!summary.getFailures().isEmpty()) {
            System.out.println("Failures:");
            summary.getFailures().forEach(failure ->
                System.out.println(" - " + failure.getTestIdentifier().getDisplayName() +
                                   ": " + failure.getException().getMessage())
            );
        }
    }
}
