package onlinestore;

public class Customer extends ThirdParty {
	
    public String firstName;
    public String lastName;

    public Customer(String firstName, String lastName, String phoneNumber)
    {
    	super(phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
