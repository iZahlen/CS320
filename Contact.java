public class Contact
{
    private static final int NumLength = 10;
    private static final byte ByteLen = 10;
    private static final byte AddressLen = 30;
    private static final String initialize = "Initial";
    private static final String initializeNum = "12345678910";
    private String contactId;
    private String fName;
    private String lName;
    private String pNum;
    private String address;

    Contact()
    {
        this.contactId = initialize;
        this.fName = initialize;
        this.lName = initialize;
        this.pNum = initialize;
        this.address = initialize;
    }

    Contact(String contactId) {
        updateContactId(contactId);
        this.fName = initialize;
        this.lName = initialize;
        this.pNum = initializeNum;
        this.address = initialize;
    }

    Contact(String contactId, String fName) {
        updateContactId(contactId);
        updateFirstName(fName);
        this.lName = initialize;
        this.pNum = initializeNum;
        this.pNum = initializeNum;
        this.address = initialize;
    }

    Contact(String contactId, String fName, String lName)
    {
        updateContactId(contactId);
        updateFirstName(fName);
        updateLastName(lName);
        this.pNum = initializeNum;
        this.address = initialize;
    }

    Contact(String contactId, String fName, String lName, String pNum)
    {
        updateContactId(contactId);
        updateFirstName(fName);
        updateLastName(lName);
        updatePhoneNumber(pNum);
        this.address = initialize;
    }

    Contact(String contactId, String fName, String lName,
            String pNum, String address) {
        updateContactId(contactId);
        updateFirstName(fName);
        updateLastName(lName);
        updatePhoneNumber(pNum);
        updateAddress(address);
    }

    protected final String getContactid()
    {
        return contactId;
    }
    protected final String getFirstName()
    {
        return fName;
    }
    protected final String getLastName()
    {
        return lName;
    }
    protected final String getPhoneNum()
    {
        return pNum;
    }
    protected final String getAddress()
    {
        return address;
    }

    protected void updateContactId(String contactId)
    {
        if (contactId == null)
        {
            throw new IllegalArgumentException("Contact ID cannot be empty");
        }
        else if (contactId.length() > ByteLen)
        {
            throw new IllegalArgumentException("Contact ID cannot be longer than " +
                    ByteLen + " characters");
        }
        else
        {
            this.contactId = contactId;
        }
    }
    protected void updateFirstName(String fName)
    {
        if (fName == null)
        {
            throw new IllegalArgumentException("First name mustn't be left blank.");
        }
        else if (fName.length() > ByteLen)
        {
            throw new IllegalArgumentException("First name mustn't be longer than " + ByteLen + " characters.");
        }
        else
        {
            this.fName = fName;
        }
    }
    protected void updateLastName(String lName)
    {
        if (lName == null)
        {
            throw new IllegalArgumentException("Last name mustn't be left blank");
        }
        else if (lName.length() > ByteLen)
        {
            throw new IllegalArgumentException("Last name mustn't exceed " + ByteLen + " characters");
        }
        else
        {
            this.lName = lName;
        }
    }
    protected void updatePhoneNumber(String phoneNumber)
    {
        String regex = "[0-9]+";
        if (phoneNumber == null)
        {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        else if (phoneNumber.length() != NumLength)
        {
            throw new IllegalArgumentException("Invalid phone number length. Please ensure it is "
                    + NumLength + " digits long.");
        }
        else if (!phoneNumber.matches(regex))
        {
            throw new IllegalArgumentException("Phone number cannot contain non-numerical characters.");
        }
        else
        {
            this.pNum = phoneNumber;
        }
    }
    protected void updateAddress(String address)
    {
        if (address == null)
        {
            throw new IllegalArgumentException("Address field mustn't be empty");
        }
        else if (address.length() > AddressLen)
        {
            throw new IllegalArgumentException("Addresses may not exceed " + AddressLen + " characters");
        }
        else
        {
            this.address = address;
        }
    }
}
