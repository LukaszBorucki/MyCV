package co.borucki.mycv.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;


public class WebItem extends CvItem {
    private Uri uri;

    public WebItem( String caption,int icon, String url) {
        super(icon, caption);
        this.uri = Uri.parse(url);
    }
    @Override
    public void performAction(Context context){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        context.startActivity(intent);

    }
}
