package co.borucki.mycv.repository;

import co.borucki.mycv.AndroidApplication;
import co.borucki.mycv.persistence.MyCVSharedPreferences;

/**
 * Created by Lukasz on 2017-08-19.
 */

public class SendMessageTextImpl implements SendMessageText {
    private static SendMessageTextImpl mInstance = new SendMessageTextImpl();
    private final MyCVSharedPreferences mSharedPreferences;

    public static SendMessageTextImpl getInstance() {
        return mInstance;

    }

    private SendMessageTextImpl() {
        mSharedPreferences = AndroidApplication.getSharedPreferences();
    }

    @Override
    public void setText(String text) {
        mSharedPreferences.setMessageText(text);
    }

    @Override
    public String getText() {
        return mSharedPreferences.getMessageText();
    }
}
