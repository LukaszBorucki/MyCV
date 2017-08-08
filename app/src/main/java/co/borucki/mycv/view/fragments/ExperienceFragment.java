package co.borucki.mycv.view.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.mycv.R;
import co.borucki.mycv.adapter.ExperienceAdapter;
import co.borucki.mycv.dto.EmployerDTO;
import co.borucki.mycv.dto.mappers.Mapper;
import co.borucki.mycv.model.Employer;
import co.borucki.mycv.security.ApplicationAccessPermission;
import co.borucki.mycv.security.ApplicationAccessPermissionImpl;
import co.borucki.mycv.security.MD5Encryption;

public class ExperienceFragment extends Fragment {
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    private RecyclerView mRecyclerView;
    private ExperienceAdapter mExperienceAdapter;
    private ProgressDialog mProgressDialog;

    public ExperienceFragment() {
    }

    public static ExperienceFragment newInstance() {
        return new ExperienceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_experience, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.experience_fragment_list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mExperienceAdapter = new ExperienceAdapter(getActivity());
        mRecyclerView.setAdapter(mExperienceAdapter);

        new getAllExperiences().execute();
    }


    private class getAllExperiences extends AsyncTask<Void, Void, List<EmployerDTO>> {
        @Override
        protected void onPreExecute() {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage("Lading data ...");
            mProgressDialog.setTitle("Info:");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected List<EmployerDTO> doInBackground(Void... params) {
            String link = "http://www.borucki.co/api/experience/?id="
                    + mAccessPermission.getAccessMail()
                    + "&pass="
                    + MD5Encryption.encrypt(mAccessPermission.getAccessPassword());

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            return Arrays.asList(restTemplate.getForObject(link, EmployerDTO[].class));
        }

        @Override
        protected void onPostExecute(List<EmployerDTO> employerDTOs) {
            List<Employer> myEducations = Mapper.fromEmployerDTOToEmployer(employerDTOs);
            mExperienceAdapter.setData(myEducations);
            mProgressDialog.dismiss();
        }
    }

}
