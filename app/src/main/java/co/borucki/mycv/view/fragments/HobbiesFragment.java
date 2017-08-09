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
import co.borucki.mycv.adapter.HobbiesAdapter;
import co.borucki.mycv.adapter.LanguageAdapter;
import co.borucki.mycv.dto.HobbiesDTO;
import co.borucki.mycv.dto.LanguageDTO;
import co.borucki.mycv.dto.mappers.Mapper;
import co.borucki.mycv.model.Hobbies;
import co.borucki.mycv.model.Language;
import co.borucki.mycv.security.ApplicationAccessPermission;
import co.borucki.mycv.security.ApplicationAccessPermissionImpl;
import co.borucki.mycv.security.MD5Encryption;


public class HobbiesFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private HobbiesAdapter mHobbiesAdapter;
    private ProgressDialog progressDialog;
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();

    public HobbiesFragment() {
        // Required empty public constructor
    }

    public static HobbiesFragment newInstance() {

        return new HobbiesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_hobbies, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.hobbies_fragment_list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mHobbiesAdapter = new HobbiesAdapter(getActivity());
        mRecyclerView.setAdapter(mHobbiesAdapter);


        new GetAllLanguagesAsyncTask().execute();

    }


    private class GetAllLanguagesAsyncTask extends AsyncTask<Void, Void, List<HobbiesDTO>> {

        @Override
        protected void onPostExecute(List<HobbiesDTO> hobbiesDTOs) {
            List<Hobbies> selectedList = new ArrayList<>();
            List<Hobbies> hobbies = Mapper.fromHobbiesDTOToHobbies(hobbiesDTOs);
            for (Hobbies hobbiesForeach : hobbies) {
                if (hobbiesForeach.getLanguage().equals("en")) {
                    selectedList.add(hobbiesForeach);

                }
            }
            mHobbiesAdapter.setData(selectedList);
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
        protected List<HobbiesDTO> doInBackground(Void... params) {
            String link = "http://www.borucki.co/api/hobbies/?id="
                    + mAccessPermission.getAccessMail()
                    + "&pass="
                    + MD5Encryption.encrypt(mAccessPermission.getAccessPassword());

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            return Arrays.asList(restTemplate.getForObject(link, HobbiesDTO[].class));

        }
    }
}
