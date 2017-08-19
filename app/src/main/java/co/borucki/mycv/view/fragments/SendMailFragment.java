package co.borucki.mycv.view.fragments;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;


import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import co.borucki.mycv.LocaleHelper;
import co.borucki.mycv.Mail;
import co.borucki.mycv.R;
import co.borucki.mycv.dto.MailUserAuthorizationDTO;
import co.borucki.mycv.dto.mappers.Mapper;
import co.borucki.mycv.model.MailUserAuthorization;
import co.borucki.mycv.repository.PersonalDataRepository;
import co.borucki.mycv.repository.PersonalDataRepositoryImpl;
import co.borucki.mycv.repository.SendMessageText;
import co.borucki.mycv.repository.SendMessageTextImpl;
import co.borucki.mycv.security.ApplicationAccessPermission;
import co.borucki.mycv.security.ApplicationAccessPermissionImpl;
import co.borucki.mycv.security.MD5Encryption;

public class SendMailFragment extends Fragment {
    private ProgressDialog progressDialog;
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    private SendMessageText mSendMessageText = SendMessageTextImpl.getInstance();
    private PersonalDataRepository mRepository = PersonalDataRepositoryImpl.getInstance();
    private EditText sendText;
    private Button sendButton;
    private MailUserAuthorization mailUserAuthorization;
    private Button clearButton;
    private boolean isSent = false;

    public SendMailFragment() {
    }

    public static SendMailFragment newInstance() {
        return new SendMailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_send_mail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle(getString(R.string.progress_dialog_title));
        progressDialog.setMessage(getString(R.string.progress_dialog_mail_text));

        sendButton = (Button) view.findViewById(R.id.send_mail_button);
        clearButton = (Button) view.findViewById(R.id.send_mail_clear);

        sendText = (EditText) view.findViewById(R.id.send_mail_text);
        sendText.setText(mSendMessageText.getText());


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSendMessageText.setText("");
                sendText.setText("");
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sendText.getText().toString().trim().equals("")
                        && !sendText.getText().toString().equals("Treść wiadomości")
                        && !sendText.getText().toString().equals("Message content")) {
                if(LocaleHelper.isOnLine(getContext())) {
                    progressDialog.show();
                    new GetMailAuthorizationData().execute();
                }
                else{
                    Toast.makeText(getContext(),getString(R.string.no_internet),Toast.LENGTH_LONG).show();
                }
                } else {
                    Toast.makeText(getContext(), R.string.send_mail_error_message, Toast.LENGTH_LONG).show();
                }
            }
        });
        sendText.addTextChangedListener(new InputValidator());

    }


    private class GetMailAuthorizationData extends AsyncTask<Void, Void, MailUserAuthorizationDTO> {

        @Override
        protected void onPostExecute(MailUserAuthorizationDTO mailUserAuthorizationDTO) {
            mailUserAuthorization = Mapper.fromMailUserAuthorizationDTOToMailUserAuthorization(mailUserAuthorizationDTO);
            sendMessage();

        }

        @Override
        protected MailUserAuthorizationDTO doInBackground(Void... params) {
            String link = "http://www.borucki.co/api/mail/?id="
                    + mAccessPermission.getAccessMail()
                    + "&pass="
                    + MD5Encryption.encrypt(mAccessPermission.getAccessPassword());

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            return restTemplate.getForObject(link, MailUserAuthorizationDTO.class);

        }

        private void sendMessage() {
            String[] recipients = {mRepository.getEmail()};
            SendEmailAsyncTask email = new SendEmailAsyncTask();
            email.m = new Mail(mailUserAuthorization.getMailUserName(), mailUserAuthorization.getMailUserPassword());
            email.m.set_from(mAccessPermission.getAccessMail());
            email.m.setBody(sendText.getText().toString());
            email.m.set_to(recipients);
            email.m.set_host(mailUserAuthorization.getMailHost());
            email.m.set_port(String.valueOf(mailUserAuthorization.getMailSmtpPort()));
            email.m.set_sport(String.valueOf(mailUserAuthorization.getMailSmtpPort()));
            email.m.set_subject(getString(R.string.send_mail_subject) + " <" + mAccessPermission.getAccessMail() + ">");
            email.execute();
        }
    }


    class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
        Mail m;

        public SendEmailAsyncTask() {
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (isSent) {
                Toast.makeText(getContext(), R.string.message_sent, Toast.LENGTH_LONG).show();
                sendText.setText(null);
                mSendMessageText.setText("");
            } else {
                Toast.makeText(getContext(), R.string.message_not_send, Toast.LENGTH_LONG).show();
            }
            progressDialog.dismiss();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                if (m.send()) {
                    isSent = true;
                } else {
                    isSent = false;
                }
                return true;
            } catch (AuthenticationFailedException e) {
                e.printStackTrace();
                return false;
            } catch (MessagingException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    private class InputValidator implements TextWatcher {
        public void afterTextChanged(Editable s) {
            mSendMessageText.setText(s.toString());
//            Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

        }
    }
}
