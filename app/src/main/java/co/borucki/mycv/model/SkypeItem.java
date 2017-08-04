package co.borucki.mycv.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import co.borucki.mycv.R;


public class SkypeItem extends CvItem {
    private final String skypeUserName = "l_borucki";

    public SkypeItem(String caption, int icon) {
        super(icon, caption);
    }

    @Override
    public void performAction(Context context) {
        if (appInstalledOrNot("com.skype.raider", context)) {


            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("skype:" + skypeUserName + "?call"));
            context.startActivity(intent);
        } else {
            Toast.makeText(context, context.getString(R.string.error_no_skype), Toast.LENGTH_LONG).show();
        }
    }

    private boolean appInstalledOrNot(String uri, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return false;
    }
}

