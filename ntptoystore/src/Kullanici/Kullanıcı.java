package Kullanici;

public class Kullanıcı {

    private String name;
    private String lastName;
    private String pass;
    private String userId;
    private String email;
    private String country;
    private int phoneNo;

    public Kullanıcı() {
    }

    public Kullanıcı(String name, String lastName, String pass, String userId, String email,String country,int phoneNo) {
        this.name = name;
        this.lastName = lastName;
        this.pass = pass;
        this.userId = userId;
        this.email = email;
        this.country=country;
        this.phoneNo=phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
    

}
