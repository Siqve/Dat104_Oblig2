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
	
	InputControl controller = new InputControl();

	assertTrue(controller.isValidFornavn(f1));
	assertTrue(controller.isValidFornavn(f2));
	assertTrue(controller.isValidFornavn(f3));	
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
