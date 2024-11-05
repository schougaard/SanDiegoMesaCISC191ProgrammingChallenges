package edu.sdmesa.cisc191;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
//	
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
//
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
//
//	@Test
//	void testReadDateTime_timeapi()  throws InterruptedException
//	{
//		final String API_URL = "https://timeapi.io/api/time/current/zone?timeZone=utc";
//		final String TIMESTAMP = "YYYY-MM-DDThh:mm:ss.tttttt"; //-hh:mm";
//	
//		// In this test you will "read" the current time from a time server on the internet.
//		// You can see that the server responds with by entering the URL in a browser
//		// and selecting Raw Data. The timestamps always have the same length and format.
//		String dateTimeBefore = IO.readDateTime(API_URL);
//	
//		// Hint: read  URL: https://docs.oracle.com/javase/tutorial//networking/urls/readingURL.html
//		// Hint: use  URL url = new URI(api).toURL();
//		// Hint: use String's indexOf("\"dateTime\":\", 0)
//		assertTrue(dateTimeBefore.startsWith("202"));
//		assertTrue(dateTimeBefore.contains("T"));
//	    	assertTrue(dateTimeBefore.length() == TIMESTAMP.length());
//	
//		// Wait a second
//		Thread.sleep(1000);  // throws InterruptedException
//		String dateTimeAfter = IO.readDateTime(API_URL);
//
//		DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//		LocalDateTime time_0 = LocalDateTime.parse(dateTimeBefore,fmt); // strip timezone data
//		LocalDateTime time_1 = LocalDateTime.parse(dateTimeAfter,fmt);
//
//		// Check that time moves forward
//		assertTrue(time_1.isAfter(time_0));
//	}

}
