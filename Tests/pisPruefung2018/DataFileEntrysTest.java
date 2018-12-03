package pisPruefung2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DataFileEntrysTest {

    //create instance of DataFileEntrys for testing
    DataFileEntrys testDataFileEntrys = new DataFileEntrys();

    //before Test create an instance of Contact for testing
    @Before
    public void addTestContactoFile() {
        Contact newTestContact = new Contact("testName", "testSurname", "testPhoneNumber",
                "testEmailAdress");
        testDataFileEntrys.addEntry(newTestContact.toString());
    }

    //checks if testDataFileEntrys an instance of DataFileentrys
    @Test
    public void testDataFileEntrysInstanceOf() {
        assertTrue(testDataFileEntrys instanceof DataFileEntrys);
    }

    //checks if Entrys.txt exists
    @Test
    public void testAddEntryFile() {
        //checks if Entrys.txt exists
        File checkFileEntrys = new File("/Users/william/Documents/coding/PisPruefungApp/Entrys.txt");
        assertTrue(checkFileEntrys.exists());
    }

    //checks if Entrys.txt is present when method showAllEntrys is called
    @Test
    public void testShowAllEntrysFile() {
        File checkFileEntrys = new File("/Users/william/Documents/coding/PisPruefungApp/Entrys.txt");
        testDataFileEntrys.showAllEntrys();
        assertTrue(checkFileEntrys.exists());
    }

    //checks if Entrys.txt is present when method search is called
    @Test
    public void testSearchFile() {
        File checkFileEntrys = new File("/Users/william/Documents/coding/PisPruefungApp/Entrys.txt");
        testDataFileEntrys.search("testName");
        assertTrue(checkFileEntrys.exists());
    }

    //checks if Filesearch works with Name as search parameter
    @Test
    public void testSearchResultName() {
        assertEquals("Name: testName, Surname: testSurname, Phone Number: testPhoneNumber, E-Mail: testEmailAdress",
                testDataFileEntrys.search("testName"));
    }

    //checks if Filesearch works with Surname as search parameter
    @Test
    public void testSearchResultSurname() {
        assertEquals("Name: testName, Surname: testSurname, Phone Number: testPhoneNumber, E-Mail: testEmailAdress",
                testDataFileEntrys.search("testSurname"));
    }

    //checks if Filesearch works with phone number as search parameter
    @Test
    public void testSearchResultPhoneNumber() {
        assertEquals("Name: testName, Surname: testSurname, Phone Number: testPhoneNumber, E-Mail: testEmailAdress",
                testDataFileEntrys.search("testPhoneNumber"));
    }

    //checks if Filesearch works with e-mail Adress as search parameter
    @Test
    public void testSearchResultEmail() {
        assertEquals("Name: testName, Surname: testSurname, Phone Number: testPhoneNumber, E-Mail: testEmailAdress",
                testDataFileEntrys.search("testEmailAdress"));
    }

    //Checks if No Match Massage is shown after faild Search
    @Test
    public void testNoMatchMassage() {
        assertEquals("No Match found in Phone Book!", testDataFileEntrys.search("TestMissedContact"));
    }

    //checks if TempEntrys.txt was deleted
    @Test
    public void testDeleteEntryTempfile() {
        File checkFileTempEntrys = new File("/Users/william/Documents/coding/PisPruefungApp/Entrys.txt");
        assertEquals(true, checkFileTempEntrys.exists());
    }

    //checks if Entry was added in File Entrys.txt
    @Test
    public void testAddEntryInFile() {
        Contact testContact = new Contact("tempName", "tempSurname", "tempPhoneNumber",
                "tempEmailAdress");
        testDataFileEntrys.addEntry(testContact.toString());
        assertEquals("Name: tempName, Surname: tempSurname, Phone Number: tempPhoneNumber, E-Mail: tempEmailAdress",
                testDataFileEntrys.search("tempName"));
        testDataFileEntrys.deleteEntry("tempName");
    }

    //Delete Test entry in Entrys.txt
    @After
    public void deleteTestContactForFile() {
        testDataFileEntrys.deleteEntry("testName");
    }
}