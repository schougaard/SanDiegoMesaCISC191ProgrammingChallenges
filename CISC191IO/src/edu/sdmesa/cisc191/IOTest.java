package edu.sdmesa.cisc191;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Lead Author(s):
 * 
 * @author Tasha Frankie
 * @author Allan Schougaard
 * 
 */

class IOTest
{

	@Test
	void testReadTestResultsExists()
	{
		String results = IO.readTestResults("TestResult.csv");
		assertTrue(results.startsWith("Alex,Smith,99,A"));
		assertTrue(results.contains("Jolene,Schmidt,100,A"));
		assertTrue(results.endsWith("Mackinzie,Jensen,86,B"));
	}

//	@Test
//	void testReadTestResultsDoesNotExist()
//	{
//		String results = IO.readTestResults("IDoNotExist.csv");
//		assertEquals("", results);
//	}
	
//  @Test
//  void testStartTestResults()
//  {
//     // Note: Be sure to close the files so they can be opened for reading
//     IO.startTestResults("NewTestResults.csv", "Julie,Brown,100,A");
//     String results = IO.readTestResults("NewTestResults.csv");
//     assertTrue(results.startsWith("Julie,Brown,100,A"));
//     IO.startTestResults("NewTestResults.csv", "Davy,Jones,30,F");
//     results = IO.readTestResults("NewTestResults.csv");
//     assertTrue(results.startsWith("Davy,Jones,30,F"));
//     assertFalse(results.contains("Julie,Brown,100,A"));
//  }

//   @Test
//   void testAppendTestResults()
//   {
//      // Note: With each run, a new set of data may be appended to the file
//      IO.appendTestResult("NewTestResults.csv", "Peter,Jensen,89,B");
//      String results = IO.readTestResults("NewTestResults.csv");
//      assertTrue(results.endsWith("Peter,Jensen,89,B"));
//      IO.appendTestResult("NewTestResults.csv", "Alice,Westergaard,100,A");
//      results = IO.readTestResults("NewTestResults.csv");
//      assertTrue(results.contains("Peter,Jensen,89,B"));
//      assertTrue(results.endsWith("Alice,Westergaard,100,A"));
//   }

//	@Test
//	void testReadDateTime()
//	{
//		// In this test you will "read" the current time from a time server on the internet.
//		// You can see that the server responds with by entering the URL in a browser
//		// and selecting Raw Data. The timestamps alwasy have the same length.
//		String dateTimeBefore = IO.readDateTime("http://worldtimeapi.org/api/ip");
//		// Hint: use URL: https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/net/URL.html
//		// or URI: https://docs.oracle.com/en%2Fjava%2Fjavase%2F21%2Fdocs%2Fapi%2F%2F/java.base/java/net/URI.html
//		// Hint: use String's indexOf("\"datetime\":\", 0)
//		assertTrue(dateTimeBefore.startsWith("202"));
//		assertTrue(dateTimeBefore.contains("T"));
//		assertTrue(dateTimeBefore.endsWith(":00")); // depending on your timezone
//		// Wait a sec...
//		Thread.sleep(1000);
//		String dateTimeAfter = IO.readDateTime("http://worldtimeapi.org/api/ip");
//		long timeBefore = java.sql.Timestamp.valueOf(dateTimeBefore).getTime();
//		long timeAfter = java.sql.Timestamp.valueOf(dateTimeAfter).getTime();
//		// Check that time moves forward
//		assertTrue(timeAfter > timeBefore);
//	}

}
