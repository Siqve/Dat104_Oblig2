package no.hvl.dat104.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat104.utils.InputControl;

public class LoginTest {

	@Test
	public void validFirstNameShouldBeAllowed() {
		String f1 = "Pål";
		String f2 = "Per";
		String f3 = "Per-arne";
		String f4 = "Bob Kåre";

		InputControl controller = new InputControl();

		assertTrue(controller.isValidFornavn(f1));
		assertTrue(controller.isValidFornavn(f2));
		assertTrue(controller.isValidFornavn(f3));
		assertTrue(controller.isValidFornavn(f4));
	}

	@Test
	public void invalidFirstNameShouldNotBeAllowed() {

		String f1 = "xXxS@nD3xXx";
		String f2 = "[L33t]Ovr1d[xD]";
		String f3 = "twitch.tv/siqveMinecraftLetsplays";

		InputControl controller = new InputControl();

		assertFalse(controller.isValidFornavn(f1));
		assertFalse(controller.isValidFornavn(f2));
		assertFalse(controller.isValidFornavn(f3));

	}

	@Test
	public void validSurnameNameShouldBeAllowed() {
		String f1 = "Eriksen";
		String f2 = "Ålesen";
		String f3 = "Bajsen";

		InputControl controller = new InputControl();

		assertTrue(controller.isValidEtternavn(f1));
		assertTrue(controller.isValidEtternavn(f2));
		assertTrue(controller.isValidEtternavn(f3));

	}

	public void invalidSurnameNameShouldNotBeAllowed() {

		String f1 = "3rikS@n";
		String f2 = "s234234";
		String f3 = ")(*&^%$%^&*(";

		InputControl controller = new InputControl();

		assertFalse(controller.isValidEtternavn(f1));
		assertFalse(controller.isValidEtternavn(f2));
		assertFalse(controller.isValidEtternavn(f3));

	}

	@Test
	public void invalidPhoneNumberShouldNotBeAllowed() {

		String n1 = "99125312";
		String n2 = "54da3254";
		String n3 = "as123243";
		String n4 = "wwddasrg";

		InputControl controller = new InputControl();

		assertTrue(controller.isValidMobilnummer(n1));
		assertFalse(controller.isValidMobilnummer(n2));
		assertFalse(controller.isValidMobilnummer(n3));
		assertFalse(controller.isValidMobilnummer(n4));

	}

}
