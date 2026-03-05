public class Address {

    private static Long idCounter = 1L;

    private Long addressId;
    private String street;
    private String city;
    private String county;
    private String postalCode;
    private String country;
    private boolean isDefault;
    private Customer customer;

    public Address();
    public Address(String street, String city, String county, String postalCode, String country);

    public void makeDefault();
    public String getFullAddress();

    public Long getAddressId();
    public String getStreet();
    public void setStreet(String street);
    public String getCity();
    public void setCity(String city);
    public String getCounty();
    public void setCounty(String county);
    public String getPostalCode();
    public void setPostalCode(String postalCode);
    public String getCountry();
    public void setCountry(String country);
    public boolean isDefault();
    public void setDefault(boolean isDefault);
    public Customer getCustomer();
    public void setCustomer(Customer customer);

    @Override
    public String toString();
}