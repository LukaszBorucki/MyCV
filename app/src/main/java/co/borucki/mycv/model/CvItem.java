package co.borucki.mycv.model;

import android.content.Context;



public abstract class CvItem {
    private int icon;
    private String caption;

    public int getIcon() {
        return icon;
    }

    public String getCaption() {
        return caption;
    }

    public CvItem(int icon, String caption) {

        this.icon = icon;
        this.caption = caption;
    }
    public abstract void performAction(Context context);
}
