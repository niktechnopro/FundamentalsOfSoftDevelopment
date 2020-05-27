package samplepackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
	BankAccount myBank;

	@Before
	public void setUp() throws Exception {
		myBank = new BankAccount();
	}

	@Test
	public void testDeposit() {
		myBank.deposit(100);
		assertEquals(myBank.balance, 100, 0.0);
	}

	@Test
	public void testWithdraw() {
		myBank.deposit(200);
		myBank.withdraw(100);
		assertEquals(myBank.balance, 100, 0.0);
	}

}
