package co.borucki.mycv.view;


import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.mycv.R;
import co.borucki.mycv.repository.PersonalDataRepository;
import co.borucki.mycv.repository.PersonalDataRepositoryImpl;
import co.borucki.mycv.security.ApplicationAccessPermission;
import co.borucki.mycv.security.ApplicationAccessPermissionImpl;
import de.hdodenhof.circleimageview.CircleImageView;

public class SplashActivity extends AppCompatActivity {
    private PersonalDataRepository mRepository = PersonalDataRepositoryImpl.getInstance();
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();

    @BindView(R.id.splash_activity_circle_image)
    CircleImageView mImage;
    @BindView(R.id.splash_activity_name_and_surname)
    TextView mNameAndSurname;
    @BindView(R.id.splash_activity_phone_no)
    TextView mPhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        mPhoneNo.setText(mRepository.getPhone());
        mNameAndSurname.setText(mRepository.getName() + " " + mRepository.getSurname());
        if (!mAccessPermission.isAccessPermission()) {
            showAskDialog();

        }


    }

    private void showAskDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.splash_put_data_dialog, null);
        final EditText password = (EditText) dialogView.findViewById(R.id.security_password);
//        final EditText fianceName = (EditText) dialogView.findViewById(R.id.fianceName);

        builder.setView(dialogView)
                .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (password.getText().toString().equals("123456789")
                                ) {
//TODO import data from internet and set as Shared Preferences
                            mRepository.setName("Łukasz");
                            mRepository.setSurname("Borucki");
                            mRepository.setPhone("+48 123 123 123");
                            mAccessPermission.setAccessPermission(true);
                        } else {
                            showAskDialog();
                        }
                    }
                });
        builder.create().show();

    }

}
