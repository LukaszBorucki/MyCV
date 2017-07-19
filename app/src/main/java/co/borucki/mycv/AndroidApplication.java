package co.borucki.mycv;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import co.borucki.mycv.persistence.MyCVSharedPreferences;


public class AndroidApplication extends Application {
    private static MyCVSharedPreferences mMyCVSharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyCVSharedPreferences = new MyCVSharedPreferences(this);
//        mDatabase = new DatabaseCache();
//        mDatabase = OpenHelperManager.getHelper(this, DatabaseOrmImpl.class);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    public static MyCVSharedPreferences getSharedPreferences() {
        return mMyCVSharedPreferences;
    }
}
