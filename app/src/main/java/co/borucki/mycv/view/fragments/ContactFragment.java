package co.borucki.mycv.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import co.borucki.mycv.R;
import co.borucki.mycv.model.MailItem;
import co.borucki.mycv.model.PhoneItem;
import co.borucki.mycv.model.SkypeItem;
import co.borucki.mycv.model.WebItem;
import co.borucki.mycv.repository.PersonalDataRepository;
import co.borucki.mycv.repository.PersonalDataRepositoryImpl;
import co.borucki.mycv.view.CvRow;


public class ContactFragment extends Fragment {
    private PersonalDataRepository mRepository = PersonalDataRepositoryImpl.getInstance();
    private LinearLayout rowHolder;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        rowHolder = (LinearLayout) view.findViewById(R.id.contactFragmentRowHolder);
        setupRows();
        return view;
    }

    private void setupRows() {
        CvRow[] arrayRows = new CvRow[]{
                new CvRow(getActivity(), new PhoneItem(mRepository.getPhone(), R.drawable.ic_phone_dark_blue_24dp)),
                new CvRow(getActivity(), new MailItem(mRepository.getEmail(), R.drawable.ic_mail_dark_blue_24dp)),
                new CvRow(getActivity(), new WebItem(mRepository.getWebService(), R.drawable.ic_www_dark_blue_24dp, "http://" + mRepository.getWebService())),
                new CvRow(getActivity(), new WebItem(mRepository.getHomeAddressStreet()
                        + " "
                        + mRepository.getHomeAddressNo()
                        + "\n"
                        + mRepository.getHomeAddressPost()
                        + " "
                        + mRepository.getHomeAddressCity()
                        , R.drawable.ic_home_address_dark_blue_24dp, mRepository.getHomeAddressGoogleLocation())),

                new CvRow(getActivity(), new WebItem(mRepository.getGitHubProfile(), R.drawable.ic_github_dark_blue_24dp, "http://github.com/"
                        + mRepository.getGitHubProfile())),
                new CvRow(getActivity(), new WebItem(mRepository.getLinkedInProfile(), R.drawable.ic_linkedin_dark_blue_24dp, "http://www.linkedin.com/in/"
                        + mRepository.getLinkedInProfile())),
                new CvRow(getActivity(), new SkypeItem(mRepository.getSkypeUserName(), R.drawable.ic_skype_dark_blue_24dp))};
        for (CvRow item : arrayRows)
            rowHolder.addView(item);


    }

}