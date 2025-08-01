package edu.sdmesa.cisc191;

import java.lang.reflect.Method;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import edu.gatech.cc.*;

public class TestResultListener implements TestExecutionListener {

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        System.out.println("Number of tests to execute : " + testPlan.countTestIdentifiers(TestIdentifier::isTest));
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        System.out.println("Finished executing all tests.");
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        if (testIdentifier.isTest()) {
            System.out.println("Starting execution of test case : " + testIdentifier.getDisplayName());
        }
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        if (testIdentifier.isTest()) {
            System.out.println("Finished execution of test case : " + testIdentifier.getDisplayName());

            if (testExecutionResult.getStatus() == TestExecutionResult.Status.FAILED) {
                testExecutionResult.getThrowable().ifPresent(throwable -> {
                	showStudentImage(testIdentifier.getDisplayName());
                    System.out.println("Execution of test case failed : " + throwable.getMessage());
                });
            }
        }
    }

    @Override
    public void executionSkipped(TestIdentifier testIdentifier, String reason) {
        if (testIdentifier.isTest()) {
            System.out.println("Execution of test case ignored : " + testIdentifier.getDisplayName());
        }
    }
    
    private void showStudentImage(String testName) {
        // Remove "()" from displayName if present
        if (testName.endsWith("()")) {
            testName = testName.substring(0, testName.length() - 2);
        }

        // Strip "test" prefix and lowercase first letter
        String logicMethod = testName.replaceFirst("test", "");
        logicMethod = Character.toLowerCase(logicMethod.charAt(0)) + logicMethod.substring(1);

        try {
            System.out.println("[DEBUG] Attempting to call Logic." + logicMethod + "(DigitalPicture)");

            // Derive filenames
            String inputFile = switch (logicMethod) {
                case "makeSunset", "flipHorizontal", "flipVertical", "blur" -> "fireFall.png";
                default -> "bees.png";
            };

            // Solution file assumes naming convention like: beesZeroBlue.png
            String solutionFile = switch (logicMethod) {
                case "zeroBlue" -> "beesZeroBlue.png";
                case "blackAndWhite" -> "beesBlackAndWhite.png";
                case "negative" -> "beesNegative.png";
                case "makeSunset" -> "fireFallMakeSunset.png";
                case "flipHorizontal" -> "fireFallFlipHorizontal.png";
                case "flipVertical" -> "fireFallFlipVertical.png";
                case "blur" -> "fireFallBlur.png";
                default -> throw new IllegalArgumentException("No solution image mapped for: " + logicMethod);
            };

            // Load images
            Picture studentImage = new Picture(inputFile);
            		studentImage.setTitle(logicMethod + " - Student Image");
            Picture solutionImage = new Picture(solutionFile);
            		solutionImage.setTitle(logicMethod+" - Expected Image - Solution");
//            		solutionImage.explore();

            // Apply logic to student's image
            Method method = Logic.class.getMethod(logicMethod, DigitalPicture.class);
            method.invoke(null, studentImage);
            
            // Show both images
            System.out.println("[INFO] Showing student image and expected solution image.");
    		studentImage.explore();
    		solutionImage.explore();

        } catch (NoSuchMethodException e) {
            System.out.println("[ERROR] No such method in Logic: " + logicMethod + "()");
        } catch (Exception e) {
            System.out.println("[ERROR] Failed to invoke Logic." + logicMethod + ": " + e.getMessage());
            e.printStackTrace();
        }
    }


    
}
