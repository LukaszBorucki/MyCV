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
import android.widget.Toast;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.borucki.mycv.LocaleHelper;
import co.borucki.mycv.R;
import co.borucki.mycv.adapter.SkillsTechnologiesAdapter;
import co.borucki.mycv.adapter.SkillsTraitsAdapter;
import co.borucki.mycv.dto.MySkillsDTO;
import co.borucki.mycv.dto.mappers.Mapper;
import co.borucki.mycv.model.MySkills;
import co.borucki.mycv.security.ApplicationAccessPermission;
import co.borucki.mycv.security.ApplicationAccessPermissionImpl;
import co.borucki.mycv.security.MD5Encryption;


public class SkillsFragment extends Fragment {
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    List<MySkills> mMySkillses;
    private ProgressDialog mProgressDialog;
    private RecyclerView mRecyclerViewTraits;
    private RecyclerView mRecyclerViewTechnologies;
    private SkillsTraitsAdapter mSkillsTraitsAdapter;
    private SkillsTechnologiesAdapter mSkillsTechnologiesAdapter;

    public SkillsFragment() {
    }

    public static SkillsFragment newInstance() {
        return new SkillsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_skills, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerViewTraits = (RecyclerView) view.findViewById(R.id.skills_fragment_list_view_traits);
        LinearLayoutManager linearLayoutManagerTraits = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerViewTraits.setLayoutManager(linearLayoutManagerTraits);
        DividerItemDecoration dividerItemDecorationTraits = new DividerItemDecoration(getActivity(), linearLayoutManagerTraits.getOrientation());
        mRecyclerViewTraits.addItemDecoration(dividerItemDecorationTraits);
        mSkillsTraitsAdapter = new SkillsTraitsAdapter(getActivity());
        mRecyclerViewTraits.setAdapter(mSkillsTraitsAdapter);

        mRecyclerViewTechnologies = (RecyclerView) view.findViewById(R.id.skills_fragment_list_view_technology);
        LinearLayoutManager linearLayoutManagerTechnologies = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerViewTechnologies.setLayoutManager(linearLayoutManagerTechnologies);
        DividerItemDecoration dividerItemDecorationTechnologies = new DividerItemDecoration(getActivity(), linearLayoutManagerTechnologies.getOrientation());
        mRecyclerViewTechnologies.addItemDecoration(dividerItemDecorationTechnologies);
        mSkillsTechnologiesAdapter = new SkillsTechnologiesAdapter(getActivity());
        mRecyclerViewTechnologies.setAdapter(mSkillsTechnologiesAdapter);

        if (LocaleHelper.isOnLine(getContext())) {
            new GetAllMySkillsAsyncTask().execute();
        } else {
            Toast.makeText(getContext(), R.string.no_internet, Toast.LENGTH_LONG).show();
        }

    }


    private class GetAllMySkillsAsyncTask extends AsyncTask<Void, Void, List<MySkillsDTO>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage(getString(R.string.progress_dialog_text));
            mProgressDialog.setTitle(getString(R.string.progress_dialog_title));
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected List<MySkillsDTO> doInBackground(Void... params) {
            String link = "http://www.borucki.co/api/skills/?id="
                    + mAccessPermission.getAccessMail()
                    + "&pass="
                    + MD5Encryption.encrypt(mAccessPermission.getAccessPassword());

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            return Arrays.asList(restTemplate.getForObject(link, MySkillsDTO[].class));
        }

        @Override
        protected void onPostExecute(List<MySkillsDTO> mySkillsDTOs) {
            super.onPostExecute(mySkillsDTOs);
            List<MySkills> mySkillsListTraits = new ArrayList<>();
            List<MySkills> mySkillsListTechnology = new ArrayList<>();
            mMySkillses = Mapper.fromMySkillsDTOToMySkills(mySkillsDTOs);
            for (MySkills mMySkillse : mMySkillses) {
                if (mMySkillse.getType().equals("technology")) {
                    mySkillsListTechnology.add(mMySkillse);
                } else {
                    if (mMySkillse.getLanguage().equals(mAccessPermission.getAppLanguage())) {
                        mySkillsListTraits.add(mMySkillse);
                    }
                }
            }


            mSkillsTechnologiesAdapter.setData(mySkillsListTechnology);
            mSkillsTraitsAdapter.setData(mySkillsListTraits);


            mProgressDialog.dismiss();


        }
    }
}
