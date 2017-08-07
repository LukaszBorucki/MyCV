package co.borucki.mycv.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import co.borucki.mycv.R;
import co.borucki.mycv.repository.PersonalDataRepository;
import co.borucki.mycv.repository.PersonalDataRepositoryImpl;



public class MailItem extends CvItem {
    private PersonalDataRepository mRepository = PersonalDataRepositoryImpl.getInstance();
    private final String[] RECEIVER_ARRAY = new String[]{
            mRepository.getEmail()};

    public MailItem(String caption, int icon) {
        super(icon, caption);
    }

    @Override
    public void performAction(Context context) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, RECEIVER_ARRAY);
        intent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.mail_service_subject));
        intent.putExtra(Intent.EXTRA_TEXT, context.getString(R.string.mail_service_message));
        context.startActivity(intent);

    }
}
