package co.borucki.mycv.view;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.mycv.R;
import co.borucki.mycv.dto.PersonalDataDTO;
import co.borucki.mycv.dto.mappers.Mapper;
import co.borucki.mycv.model.PersonalData;
import co.borucki.mycv.repository.PersonalDataRepository;
import co.borucki.mycv.repository.PersonalDataRepositoryImpl;
import co.borucki.mycv.security.ApplicationAccessPermission;
import co.borucki.mycv.security.ApplicationAccessPermissionImpl;
import co.borucki.mycv.security.MD5Encryption;
import de.hdodenhof.circleimageview.CircleImageView;

public class SplashActivity extends AppCompatActivity {
    private PersonalDataRepository mRepository = PersonalDataRepositoryImpl.getInstance();
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    private String mVisitor = null;
    private String mPassword = null;
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
//        mAccessPermission.setAccessPermission(false);
        setSplashActivityData();
        if (mAccessPermission.getAccessMail().equals("mail")
                || mAccessPermission.getAccessMail() == null) {
            showAskDialogRegister();
        }

        if (!mAccessPermission.isAccessPermission()
                && (!mAccessPermission.getAccessMail().equals("mail")
                && mAccessPermission.getAccessMail() != null)) {
            showAskDialogLogin();
        }


    }

    private void setSplashActivityData() {
        mPhoneNo.setText(mRepository.getPhone());
        mNameAndSurname.setText(mRepository.getName() + " " + mRepository.getSurname());
    }

    private void showAskDialogLogin() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.splash_put_data_dialog, null);
        Rect displayRectangle = new Rect();
        Window window = this.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        dialogView.setMinimumWidth((int) (displayRectangle.width() * 0.9f));
        dialogView.setMinimumHeight((int) (displayRectangle.height() * 0.9f));
        final EditText password = (EditText) dialogView.findViewById(R.id.security_password);
        final EditText userEmail = (EditText) dialogView.findViewById(R.id.userEmail);
        userEmail.setText(mAccessPermission.getAccessMail());
        userEmail.setEnabled(false);
        builder.setView(dialogView)
                .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        new CheckPassword()
                                .execute(userEmail.getText().toString(), password.getText().toString());
                    }

                });
        builder.create().show();

    }


    private void showAskDialogRegister() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.splash_put_data_dialog_register, null);
        Rect displayRectangle = new Rect();
        Window window = this.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        dialogView.setMinimumWidth((int) (displayRectangle.width() * 0.9f));
        dialogView.setMinimumHeight((int) (displayRectangle.height() * 0.9f));

        final EditText userEmail = (EditText) dialogView.findViewById(R.id.user_email);

        builder.setView(dialogView)
                .setPositiveButton("Register", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (!userEmail.getText().toString().equals("E-mail")
                                && !userEmail.getText().toString().equals("")

                                ) {
                            new AskForPassword().execute(userEmail.getText().toString());
                            mVisitor = userEmail.getText().toString();

                        } else {
                            showAskDialogRegister();
                        }
                    }
                });
        builder.create().show();

    }

    private class CheckPassword extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            mPassword = params[1];
            String encryptedPassword = MD5Encryption.encrypt(mPassword);
            String link = "http://borucki.co/api/check_permissions/?id="
                    + params[0]
                    + "&pass="
                    + encryptedPassword;
            StringBuilder builder = new StringBuilder();
            String line;

            URL url = null;
            try {
                url = new URL(link);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                InputStream in = new BufferedInputStream(connection.getInputStream());


                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(in, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }


            return builder.toString();

        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("200")) {
                mAccessPermission.setAccessPassword(mPassword);
                mAccessPermission.setAccessPermission(true);
                new GetMyPersonalDataAsyncTask().execute();
            } else {
                showAskDialogLogin();
            }
        }


    }


    private class AskForPassword extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            String link = "http://borucki.co/api/new_user/?id=" + params[0].toUpperCase();

            StringBuilder builder = new StringBuilder();
            String line;

            URL url = null;
            try {
                url = new URL(link);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                InputStream in = new BufferedInputStream(connection.getInputStream());


                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(in, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }


            return builder.toString();

        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("200")) {
                mAccessPermission.setAccessMail(mVisitor);
                finish();
            } else {
                showAskDialogRegister();
            }

        }
    }

    private class GetMyPersonalDataAsyncTask extends AsyncTask<Void, Void, PersonalDataDTO> {

        @Override
        protected void onPostExecute(PersonalDataDTO personalDataDTO) {
            PersonalData personalData = Mapper.fromPersonalDataDTOToPersonalData(personalDataDTO);
            mRepository.setName(personalData.getName());
            mRepository.setSurname(personalData.getSurname());
            mRepository.setPhone(personalData.getPhoneNo());
            mNameAndSurname.setText(mRepository.getName() + " " + mRepository.getSurname());
            mPhoneNo.setText(mRepository.getPhone());
        }

        @Override
        protected PersonalDataDTO doInBackground(Void... params) {
            String link = "http://www.borucki.co/api/personal_data/?id="
                    + mAccessPermission.getAccessMail()
                    + "&pass="
                    + MD5Encryption.encrypt(mAccessPermission.getAccessPassword());

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            String d = restTemplate.toString();
            return restTemplate.getForObject(link, PersonalDataDTO.class);

        }
    }

}