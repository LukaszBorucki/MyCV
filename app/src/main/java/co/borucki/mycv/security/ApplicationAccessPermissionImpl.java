package co.borucki.mycv.security;

import co.borucki.mycv.AndroidApplication;
import co.borucki.mycv.persistence.MyCVSharedPreferences;


public class ApplicationAccessPermissionImpl implements ApplicationAccessPermission {
    private static ApplicationAccessPermissionImpl mInstance = new ApplicationAccessPermissionImpl();
    private final MyCVSharedPreferences mSharedPreferences;

    public static ApplicationAccessPermissionImpl getInstance() {
        return mInstance;

    }

    private ApplicationAccessPermissionImpl() {
        mSharedPreferences = AndroidApplication.getSharedPreferences();
    }

    @Override
    public boolean isAccessPermission() {
        return mSharedPreferences.isAccessPermited();
    }

    @Override
    public void setAccessPermission(boolean accessPermission) {
        mSharedPreferences.setAccessPermission(accessPermission);
    }

    @Override
    public String getAccessMail() {
        return mSharedPreferences.getAccessPermissionMail();
    }

    @Override
    public void setAccessMail(String mail) {
        mSharedPreferences.setAccessPermissionMail(mail);
    }

    @Override
    public String getAccessPassword() {
        return mSharedPreferences.getAccessPermissionPassword();
    }

    @Override
    public void setAccessPassword(String password) {
        mSharedPreferences.setAccessPermissionPassword(password);
    }

    @Override
    public String getAppLanguage() {
        return mSharedPreferences.getAccessPermissionAppLanguage();
    }

    @Override
    public void setAppLanguage(String language) {
        mSharedPreferences.setAccessPermissionAppLanguage(language);
    }
}
