package co.borucki.mycv.repository;

import co.borucki.mycv.AndroidApplication;
import co.borucki.mycv.persistence.MyCVSharedPreferences;


public class PersonalDataRepositoryImpl implements PersonalDataRepository {
    private static PersonalDataRepositoryImpl mInstance = new PersonalDataRepositoryImpl();
    private final MyCVSharedPreferences mSharedPreferences;

    public static PersonalDataRepositoryImpl getInstance() {
        return mInstance;

    }

    private PersonalDataRepositoryImpl() {
        mSharedPreferences = AndroidApplication.getSharedPreferences();
    }

    @Override
    public String getName() {
        return mSharedPreferences.getName();
    }

    @Override
    public String getSurname() {
        return mSharedPreferences.getSurname();
    }

    @Override
    public String getPhone() {
        return mSharedPreferences.getPhone();
    }

    @Override
    public String getEmail() {
        return mSharedPreferences.getEmail();
    }

    @Override
    public String getWebService() {
        return mSharedPreferences.getWebService();
    }

    @Override
    public String getHomeAddressCity() {
        return mSharedPreferences.getHomeAddressCity();
    }

    @Override
    public String getHomeAddressStreet() {
        return mSharedPreferences.getHomeAddressStreet();
    }

    @Override
    public String getHomeAddressNo() {
        return mSharedPreferences.getHomeAddressNo();
    }

    @Override
    public String getHomeAddressPost() {
        return mSharedPreferences.getHomeAddressPost();
    }

    @Override
    public String getHomeAddressGoogleLocation() {
        return mSharedPreferences.getHomeAddressGoogleLocation();
    }

    @Override
    public String getSkypeUserName() {
        return mSharedPreferences.getSkypeUserName();
    }

    @Override
    public String getLinkedInProfile() {
        return mSharedPreferences.getLinkedInProfile();
    }

    @Override
    public String getGitHubProfile() {
        return mSharedPreferences.getGitHubProfile();
    }

    @Override
    public String getPhoto() {
        return mSharedPreferences.getPhoto();
    }

    @Override
    public String getAboutPl() {
        return mSharedPreferences.getAboutPl();
    }

    @Override
    public String getAboutEn() {
        return mSharedPreferences.getAboutEn();
    }

    @Override
    public void setName(String name) {
        mSharedPreferences.setName(name);
    }

    @Override
    public void setSurname(String surname) {
        mSharedPreferences.setSurname(surname);
    }

    @Override
    public void setPhone(String phone) {
        mSharedPreferences.setPhone(phone);
    }

    @Override
    public void setEmail(String email) {
        mSharedPreferences.setEmail(email);
    }

    @Override
    public void setWebService(String webService) {
        mSharedPreferences.setWebService(webService);
    }

    @Override
    public void setHomeAddressCity(String city) {
        mSharedPreferences.setHomeAddressCity(city);
    }

    @Override
    public void setHomeAddressStreet(String street) {
        mSharedPreferences.setHomeAddressStreet(street);
    }

    @Override
    public void setHomeAddressNo(String no) {
        mSharedPreferences.setHomeAddressNo(no);
    }

    @Override
    public void setHomeAddressPost(String post) {
        mSharedPreferences.setHomeAddressPost(post);
    }

    @Override
    public void setHomeAddressGoogleLocation(String googleLocation) {
        mSharedPreferences.setHomeAddressGoogleLocation(googleLocation);
    }

    @Override
    public void setSkypeUserName(String skype) {
        mSharedPreferences.setSkypeUserName(skype);
    }

    @Override
    public void setLinkedInProfile(String linkedIn) {
        mSharedPreferences.setLinkedInProfile(linkedIn);
    }

    @Override
    public void setGitHubProfile(String gitHub) {
        mSharedPreferences.setGitHubProfile(gitHub);
    }

    @Override
    public void setPhoto(String photo) {
        mSharedPreferences.setPhoto(photo);
    }

    @Override
    public void setAboutPl(String aboutPl) {
        mSharedPreferences.setAboutPl(aboutPl);
    }

    @Override
    public void setAboutEn(String aboutEn) {
        mSharedPreferences.setAboutEn(aboutEn);
    }
}
