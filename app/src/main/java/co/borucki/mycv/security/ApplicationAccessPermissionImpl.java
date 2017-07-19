package co.borucki.mycv.security;

import co.borucki.mycv.AndroidApplication;
import co.borucki.mycv.persistence.MyCVSharedPreferences;


public class ApplicationAccessPermissionImpl implements ApplicationAccessPermission {
    private static ApplicationAccessPermissionImpl mInstance = new ApplicationAccessPermissionImpl();
    private final MyCVSharedPreferences mSharedPreferences;

    public static ApplicationAccessPermissionImpl getInstance() {
        return mInstance;

    }

    public ApplicationAccessPermissionImpl() {
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
}
