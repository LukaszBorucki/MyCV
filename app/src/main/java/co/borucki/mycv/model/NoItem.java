package co.borucki.mycv.model;

import android.content.Context;
import android.net.Uri;


public class NoItem extends CvItem {
    private Uri uri;

    public NoItem(String caption, int icon) {
        super(icon, caption);

    }
    @Override
    public void performAction(Context context){

    }
}