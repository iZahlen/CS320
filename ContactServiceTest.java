import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest
{
    protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
            addressTest;
    protected String tooLongContactId, tooLongFirstName, tooLongLastName,
            tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

    @BeforeEach
    void setUp() {
        contactId = "1029F847A6";
        firstNameTest = "Zazie";
        lastNameTest = "Rainyday";
        phoneNumberTest = "6789998212";
        addressTest = "42 P Sherman WW, Sydney 20000";
        tooLongContactId = "112233445566778899";
        tooLongFirstName = "ZAHLEN WAS HERE";
        tooLongLastName = "I LOVE YOU ALEXIS";
        tooLongPhoneNumber = "87711243513536123312";
        tooShortPhoneNumber = "123456";
        tooLongAddress = "P Sherman 42 Wallaby Way Sydney, NSW 20000";
    }

    @Test
    void newContactTest()
    {
        ContactService service = new ContactService();
        service.newContact();
        assertAll("Service",
                ()
                        -> assertNotNull(service.getContactList().get(0).getContactid()),
                ()
                        -> assertEquals("INITIAL",
                        service.getContactList().get(0).getFirstName()),
                ()
                        -> assertEquals("INITIAL",
                        service.getContactList().get(0).getLastName()),
                ()
                        -> assertEquals("1235559999",
                        service.getContactList().get(0).getPhoneNum()),
                ()
                        -> assertEquals("INITIAL",
                        service.getContactList().get(0).getAddress()));

        service.newContact(firstNameTest);
        assertAll("Service",
                ()
                        -> assertNotNull(service.getContactList().get(1).getContactid()),
                ()
                        -> assertEquals(firstNameTest,
                        service.getContactList().get(1).getFirstName()),
                ()
                        -> assertEquals("INITIAL",
                        service.getContactList().get(1).getLastName()),
                ()
                        -> assertEquals("1235559999",
                        service.getContactList().get(1).getPhoneNum()),
                ()
                        -> assertEquals("INITIAL",
                        service.getContactList().get(1).getAddress()));

        service.newContact(firstNameTest, lastNameTest);
        assertAll("Service",
                ()
                        -> assertNotNull(service.getContactList().get(2).getContactid()),
                ()
                        -> assertEquals(firstNameTest,
                        service.getContactList().get(2).getFirstName()),
                ()
                        -> assertEquals(lastNameTest,
                        service.getContactList().get(2).getLastName()),
                ()
                        -> assertEquals("1235559999",
                        service.getContactList().get(2).getPhoneNum()),
                ()
                        -> assertEquals("INITIAL",
                        service.getContactList().get(2).getAddress()));

        service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
        assertAll("Service",
                ()
                        -> assertNotNull(service.getContactList().get(3).getContactid()),
                ()
                        -> assertEquals(firstNameTest,
                        service.getContactList().get(3).getFirstName()),
                ()
                        -> assertEquals(lastNameTest,
                        service.getContactList().get(3).getLastName()),
                ()
                        -> assertEquals(phoneNumberTest,
                        service.getContactList().get(3).getPhoneNum()),
                ()
                        -> assertEquals("INITIAL",
                        service.getContactList().get(3).getAddress()));

        service.newContact(firstNameTest, lastNameTest, phoneNumberTest,
                addressTest);
        assertAll("Service",
                ()
                        -> assertNotNull(service.getContactList().get(4).getContactid()),
                ()
                        -> assertEquals(firstNameTest,
                        service.getContactList().get(4).getFirstName()),
                ()
                        -> assertEquals(lastNameTest,
                        service.getContactList().get(4).getLastName()),
                ()
                        -> assertEquals(phoneNumberTest,
                        service.getContactList().get(4).getPhoneNum()),
                ()
                        -> assertEquals(addressTest,
                        service.getContactList().get(4).getAddress()));
    }

    @Test
    void deleteContactTest()
    {
        ContactService service = new ContactService();
        service.newContact();
        assertThrows(Exception.class, () -> service.deleteContact(contactId));
        assertAll(()
                -> service.deleteContact(
                service.getContactList().get(0).getContactid()));
    }

    @Test
    void updateFirstNameTest() throws Exception
    {
        ContactService service = new ContactService();
        service.newContact();
        service.updateFirstName(service.getContactList().get(0).getContactid(),
                firstNameTest);
        assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
        assertThrows(IllegalArgumentException.class,
                ()
                        -> service.updateFirstName(
                        service.getContactList().get(0).getContactid(),
                        tooLongFirstName));
        assertThrows(IllegalArgumentException.class,
                ()
                        -> service.updateFirstName(
                        service.getContactList().get(0).getContactid(), null));
        assertThrows(Exception.class,
                () -> service.updateFirstName(contactId, firstNameTest));
    }

    @Test
    void updateLastNameTest() throws Exception
    {
        ContactService service = new ContactService();
        service.newContact();
        service.updateLastName(service.getContactList().get(0).getContactid(),
                lastNameTest);
        assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
        assertThrows(IllegalArgumentException.class,
                ()
                        -> service.updateLastName(
                        service.getContactList().get(0).getContactid(),
                        tooLongLastName));
        assertThrows(IllegalArgumentException.class,
                ()
                        -> service.updateLastName(
                        service.getContactList().get(0).getContactid(), null));
        assertThrows(Exception.class,
                () -> service.updateLastName(contactId, lastNameTest));
    }

    @Test
    void updatePhoneNumberTest() throws Exception
    {
        ContactService service = new ContactService();
        service.newContact();
        service.updatePhoneNumber(service.getContactList().get(0).getContactid(),
                phoneNumberTest);
        assertEquals(phoneNumberTest,
                service.getContactList().get(0).getPhoneNum());
        assertThrows(IllegalArgumentException.class,
                ()
                        -> service.updatePhoneNumber(
                        service.getContactList().get(0).getContactid(),
                        tooLongPhoneNumber));
        assertThrows(IllegalArgumentException.class,
                ()
                        -> service.updatePhoneNumber(
                        service.getContactList().get(0).getContactid(),
                        tooShortPhoneNumber));
        assertThrows(
                IllegalArgumentException.class,
                ()
                        -> service.updatePhoneNumber(
                        service.getContactList().get(0).getContactid(), contactId));
        assertThrows(IllegalArgumentException.class,
                ()
                        -> service.updatePhoneNumber(
                        service.getContactList().get(0).getContactid(), null));
        assertThrows(Exception.class,
                () -> service.updatePhoneNumber(contactId, lastNameTest));
    }

    @Test
    void updateAddressTest() throws Exception
    {
        ContactService service = new ContactService();
        service.newContact();
        service.updateAddress(service.getContactList().get(0).getContactid(),
                addressTest);
        assertEquals(addressTest, service.getContactList().get(0).getAddress());
        assertThrows(IllegalArgumentException.class,
                ()
                        -> service.updateAddress(
                        service.getContactList().get(0).getContactid(),
                        tooLongAddress));
        assertThrows(IllegalArgumentException.class,
                ()
                        -> service.updateAddress(
                        service.getContactList().get(0).getContactid(), null));
        assertThrows(Exception.class,
                () -> service.updateAddress(contactId, addressTest));
    }
}