package co.borucki.mycv.repository;


public interface PersonalDataRepository {
    String getName();

    String getSurname();

    String getPhone();

    String getEmail();

    String getWebService();

    String getHomeAddressCity();

    String getHomeAddressStreet();

    String getHomeAddressNo();

    String getHomeAddressPost();

    String getHomeAddressGoogleLocation();

    String getSkypeUserName();

    String getLinkedInProfile();

    String getGitHubProfile();

    String getPhoto();

    String getAboutPl();

    String getAboutEn();

    void setName(String name);

    void setSurname(String surname);

    void setPhone(String phone);

    void setEmail(String email);

    void setWebService(String webService);

    void setHomeAddressCity(String city);

    void setHomeAddressStreet(String street);

    void setHomeAddressNo(String houseNo);

    void setHomeAddressPost(String postCode);

    void setHomeAddressGoogleLocation(String googleLocation);

    void setSkypeUserName(String skype);

    void setLinkedInProfile(String linkedIn);

    void setGitHubProfile(String gitHub);

    void setPhoto(String photo);

    void setAboutPl(String aboutPl);

    void setAboutEn(String aboutEn);
}
