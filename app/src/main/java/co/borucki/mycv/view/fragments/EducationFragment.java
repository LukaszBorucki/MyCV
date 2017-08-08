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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.borucki.mycv.R;
import co.borucki.mycv.adapter.EducationAdapter;
import co.borucki.mycv.dto.MyEducationDTO;
import co.borucki.mycv.dto.mappers.Mapper;
import co.borucki.mycv.model.MyEducation;
import co.borucki.mycv.security.ApplicationAccessPermission;
import co.borucki.mycv.security.ApplicationAccessPermissionImpl;
import co.borucki.mycv.security.MD5Encryption;


public class EducationFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private EducationAdapter mEducationAdapter;
    private ProgressDialog progressDialog;
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();

    public EducationFragment() {
        // Required empty public constructor
    }

    public static EducationFragment newInstance() {

        return new EducationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_education, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.education_fragment_list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mEducationAdapter = new EducationAdapter(getActivity());
        mRecyclerView.setAdapter(mEducationAdapter);


        new GetAllMyEducationAsyncTask().execute();

    }


    private class GetAllMyEducationAsyncTask extends AsyncTask<Void, Void, List<MyEducationDTO>> {

        @Override
        protected void onPostExecute(List<MyEducationDTO> myEducationDTOList) {
            List<MyEducation> selectedList = new ArrayList<>();
            List<MyEducation> myEducations = Mapper.fromMyEducationDTOToMyEducation(myEducationDTOList);
            for (MyEducation myEducation : myEducations) {
                if (myEducation.getLanguage().equals("en")) {
                    selectedList.add(myEducation);

                }
            }
            mEducationAdapter.setData(selectedList);
            progressDialog.dismiss();
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Lading data ...");
            progressDialog.setTitle("Info:");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected List<MyEducationDTO> doInBackground(Void... params) {
            String link = "http://www.borucki.co/api/education/?id="
                    + mAccessPermission.getAccessMail()
                    + "&pass="
                    + MD5Encryption.encrypt(mAccessPermission.getAccessPassword());

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            return Arrays.asList(restTemplate.getForObject(link, MyEducationDTO[].class));

        }
    }
}
