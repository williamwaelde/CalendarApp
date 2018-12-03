package pisPruefung2018;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    Contact newTestContact = new Contact("testName", "testSurname", "testPhoneNumber",
            "testEmailAdress");

    //tests if new instance of Contact is created
    @Test
    public void testContactInstanceOf() {
        assertTrue(newTestContact instanceof Contact);
    }

    //checks if getName() method works
    @Test
    public void testGetName() {
        assertEquals("testName", newTestContact.getName());
    }

    //double checks getName() method with false argument
    @Test
    public void testIfWrongNameRetrurn() {
        String wrongTestName = "wrongTestName";
        assertFalse(wrongTestName.equals(newTestContact.getName()));
    }

    //checks if getSurname() method works
    @Test
    public void testGetSurname() {
        assertEquals("testSurname", newTestContact.getSurname());
    }

    @Test
    public void testIfWrongGetSurname() {
        String wrongTestSurname = "wrongTestSurname";
        assertFalse(wrongTestSurname.equals(newTestContact.getSurname()));
    }

    //double checks getSurname() method with false argument
    @Test
    public void testGetPhoneNumber() {
        assertEquals("testPhoneNumber", newTestContact.getPhoneNumber());
    }

    //checks if getPhoneNumber() method works
    @Test
    public void testIfWrongGetPhoneNumber() {
        String wrongTestPhoneNumber = "wrongTestPhoneNumber";
        assertFalse(wrongTestPhoneNumber.equals(newTestContact.getPhoneNumber()));
    }

    //tests if email is correct from getEmailAdress() method
    @Test
    public void testGetEmailAdress() {
        assertEquals("testEmailAdress", newTestContact.getEmailAdress());
    }

    //double checks getEmailAdress() method with false argument
    @Test
    public void testIfWrongGetEmailAdress() {
        String wrongTestEmailAdress = "wrongTestEmailAdress";
        assertFalse(wrongTestEmailAdress.equals(newTestContact.getEmailAdress()));
    }

    //tests if toString() method works
    @Test
    public void testToString() {
        String expected = "Name: testName, Surname: testSurname, Phone Number: testPhoneNumber, E-Mail: testEmailAdress";
        assertEquals(expected, newTestContact.toString());
    }

    //tests if toString() method works correct with flase argument
    @Test
    public void testifWrongToString() {
        String wrongToString = "Name: 0, Surname: 0, Phone Number: 0, E-Mail: 0";
        assertFalse(wrongToString.equals(newTestContact.toString()));
    }

}