package cisc191.sdmesa.edu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Lead Author(s):
 * @author Tasha Frankie
 * @author Allan Schougaard 
 * 
 * Other contributors:
 * None
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., Rancourt, J. D., & Stein, C. (n.d.). 
 * JUnit 5 user guide. JUnit 5. 
 * https://junit.org/junit5/docs/current/user-guide/
 * 
 * Version/date: 1.0  
 * 
 * Responsibilities of class:
 * Test CheckoutBill and BankAccount classes
 */

/**
 * Your mission, should you choose to accept it:
 * 
 * For each of the test methods below create a method in the boat class that
 * makes the test run and pass.
 * 
 * Read the test methods to understand what the ArrayChallenge class methods
 * should do. The assertEquals methods check to see if the two arguments are
 * equal. If they are equal the test passes; if not, the test will be marked as
 * failed and the execution stops.
 * 
 * To run the tests from the main menu, select Run -> Run.
 * 
 * To implement a test method:
 * 
 * 1. Uncomment the entire test method. To uncomment a block, select the block
 * and hold down Ctrl while typing /
 * 
 * 2. To make the test compile and run: implement a method with the correct
 * signature, but returning a fake value, such as -1, null or similar. After
 * this the test method should run but fail.
 * 
 * 3. To make the tests pass: Then change the method to return the correct value
 * and run the test again.
 * 
 */

class TestExceptions
{
	@Test
	void testCheckoutBillSetBillAmount()
	{
		CheckoutBill bill = new CheckoutBill();

		// The following statement checks that the call to setBillAmount does not throw
		// an Exception
		assertDoesNotThrow(() -> {
			bill.setBillAmount(0.01);
		});

		// The following statement checks that the call to setBillAmount throws an
		// IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			bill.setBillAmount(0);
		});

	}

//	@Test
//	void testCheckoutBillSetTipPercent()
//	{
//		CheckoutBill bill = new CheckoutBill();
//
//		// The following statement checks that the call to setTipPercent does not throw
//		// an Exception
//		assertDoesNotThrow(() -> {
//			bill.setTipPercent(0);
//		});
//
//		// The following statement checks that the call to setTipPercent throws an
//		// IllegalArgumentException
//		assertThrows(IllegalArgumentException.class, () -> {
//			bill.setTipPercent(-0.1);
//		});
//	}
//
//	@Test
//	void testCheckoutBillCalculateTotalBill()
//	{
//		CheckoutBill bill1 = new CheckoutBill();
//		bill1.setBillAmount(200);
//		bill1.setTipPercent(20);
//		assertEquals(240, bill1.calculateTotalBill());
//
//		CheckoutBill bill2 = new CheckoutBill();
//		bill2.setBillAmount(200);
//		assertThrows(IllegalStateException.class, () -> {
//			bill2.calculateTotalBill();
//		});
//
//		CheckoutBill bill3 = new CheckoutBill();
//		bill3.setTipPercent(20);
//		assertThrows(IllegalStateException.class, () -> {
//			bill3.calculateTotalBill();
//		});
//	}
//
//	@Test
//	void testMain()
//	{
//      // main should not allow the program to crash
//		assertDoesNotThrow(() -> {
//			CheckoutBill.main(null);
//		});
//	}
//
//	@Test
//	void testBankAccountDepositWithdraw() throws Exception
//	{
//		BankAccount account = new BankAccount();
//		account.deposit(200);
//		assertEquals(200, account.getBalance());
//		account.withdraw(150);
//		assertEquals(50, account.getBalance());
//		account.deposit(200);
//		assertEquals(250, account.getBalance());
//		account.withdraw(250);
//		assertEquals(0, account.getBalance());
//	}
//
//	@Test
//	void testBankAccountDepositException() throws Exception
//	{
//		InvalidAmountException invalidAmountException = new InvalidAmountException(123.45);
//		// Test that invalidAmountException is-an Exception
//		assertTrue(invalidAmountException instanceof Exception);
//		
//		BankAccount account = new BankAccount();
//		account.deposit(100);
//		Exception exception = assertThrows(InvalidAmountException.class, () -> {
//			account.deposit(-0.01);
//		});
//		assertEquals("Negative amount: $-0.01 is not allowed", exception.getMessage());
//      assertEquals(100, account.getBalance());
//	}
//
	@Test
	void testBankAccountWithdrawException1() throws Exception
	{
		BankAccount account = new BankAccount();
		account.deposit(200);
		Exception exception = assertThrows(InvalidAmountException.class, () -> {
			account.withdraw(-0.02);
		});
		assertEquals("Negative amount: $-0.02 is not allowed", exception.getMessage());
		assertEquals(200, account.getBalance());
	}
//
//	@Test
//	void testBankAccountWithdrawException2() throws Exception
//	{
//		InsufficientFundsException insufficientFundsException = new InsufficientFundsException(1.11, 1.12);
//		// Test that insufficientFundsException is-an Exception
//		assertTrue(insufficientFundsException instanceof Exception);
//	
//		BankAccount account = new BankAccount();
//		account.deposit(299.98);
//		Exception exception2 = assertThrows(InsufficientFundsException.class, () -> {
//			// Try to withdraw more than balance
//			account.withdraw(299.99);
//		});
//		assertEquals("Withdrawing amount: $299.99 that is larger than balance: $299.98 is not allowed",
//							exception2.getMessage());
//       assertEquals(299.98, account.getBalance());
//	}
//
//	@Test
//	void testWithdrawAsMuchPossible() throws Exception
//	{
//		BankAccount account1 = new BankAccount();
//		account1.deposit(400);
//		assertEquals(400, account1.withdrawAsMuchPossible(400));
//	    assertEquals(0, account1.getBalance());
//	
//		BankAccount account2 = new BankAccount();
//		account2.deposit(100);
//		// Only withdraw as much as is available in the account
//		// Hint: re-use withdraw
//		assertEquals(100, account2.withdrawAsMuchPossible(200));
//		assertEquals(0, account2.getBalance());
//	
//		assertThrows(InvalidAmountException.class, () -> {
//			account2.withdrawAsMuchPossible(-0.01);
//		});
//		assertEquals(0, account2.getBalance());
//	}

}
