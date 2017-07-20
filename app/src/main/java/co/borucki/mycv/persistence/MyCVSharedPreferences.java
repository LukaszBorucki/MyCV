package co.borucki.mycv.persistence;

import android.content.Context;
import android.content.SharedPreferences;


public class MyCVSharedPreferences {
    private static final String PERSONAL_DATA_SHARED_PREFERENCES = "personalData";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PHONE = "phone";
    private static final String ACCESS_PERMISSION = "access_permission";

    protected final SharedPreferences mSharedPreferences;

    public MyCVSharedPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(PERSONAL_DATA_SHARED_PREFERENCES, context.MODE_PRIVATE);
    }

    public String getName() {
        return mSharedPreferences.getString(NAME, "Name");
    }

    public String getSurname() {
        return mSharedPreferences.getString(SURNAME, "Surname");
    }

    public void setName(String name) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(NAME, name);
        editor.commit();
    }

    public void setSurname(String surname) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SURNAME, surname);
        editor.commit();
    }

    public String getPhone() {
        return mSharedPreferences.getString(PHONE, "Phone No.");

    }

    public void setPhone(String phone) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(PHONE, phone);
        editor.commit();

    }

    public boolean isAccessPermited(){
        return mSharedPreferences.getBoolean(ACCESS_PERMISSION, false);
    }
    public void setAccessPermission(boolean accessPermission){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(ACCESS_PERMISSION,accessPermission);
        editor.commit();

    }

}
