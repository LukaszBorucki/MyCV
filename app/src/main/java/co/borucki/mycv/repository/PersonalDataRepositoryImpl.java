package co.borucki.mycv.repository;

import co.borucki.mycv.AndroidApplication;
import co.borucki.mycv.persistence.MyCVSharedPreferences;


public class PersonalDataRepositoryImpl implements PersonalDataRepository {
    private static PersonalDataRepositoryImpl mInstance = new PersonalDataRepositoryImpl();
    private final MyCVSharedPreferences mSharedPreferences;

    public static PersonalDataRepositoryImpl getInstance() {
        return mInstance;

    }

    public PersonalDataRepositoryImpl() {
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
}
