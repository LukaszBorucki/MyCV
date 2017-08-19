package co.borucki.mycv.model;


public class PersonalData {
    private String name;
    private String surname;
    private String phoneNo;
    private String email;
    private String city;
    private String street;
    private String houseNo;
    private String postCode;
    private String gitHub;
    private String webService;
    private String skype;
    private String linkedIn;
    private String googleLocation;
    private String photo;
    private String aboutPl;
    private String aboutEn;


    public PersonalData() {
    }

    public PersonalData(String name, String surname, String phoneNo, String email, String city, String street, String houseNo, String postCode, String gitHub, String webService, String skype, String linkedIn, String googleLocation, String photo, String aboutPl, String aboutEn) {
        this.name = name;
        this.surname = surname;
        this.phoneNo = phoneNo;
        this.email = email;
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
        this.postCode = postCode;
        this.gitHub = gitHub;
        this.webService = webService;
        this.skype = skype;
        this.linkedIn = linkedIn;
        this.googleLocation = googleLocation;
        this.photo = photo;
        this.aboutPl = aboutPl;
        this.aboutEn = aboutEn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    public String getWebService() {
        return webService;
    }

    public void setWebService(String webService) {
        this.webService = webService;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGoogleLocation() {
        return googleLocation;
    }

    public void setGoogleLocation(String googleLocation) {
        this.googleLocation = googleLocation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAboutPl() {
        return aboutPl;
    }

    public void setAboutPl(String aboutPl) {
        this.aboutPl = aboutPl;
    }

    public String getAboutEn() {
        return aboutEn;
    }

    public void setAboutEn(String aboutEn) {
        this.aboutEn = aboutEn;
    }
}
