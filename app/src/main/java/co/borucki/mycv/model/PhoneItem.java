package co.borucki.mycv.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;


public class PhoneItem extends CvItem {
    private Uri uri;

    public PhoneItem(String phoneNo, int icon) {
        super(icon, phoneNo);
        uri = Uri.parse("tel:" + phoneNo);
    }

    @Override
    public void performAction(Context context) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        context.startActivity(intent);

    }
}
