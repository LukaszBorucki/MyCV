package co.borucki.mycv.view.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.borucki.mycv.R;
import co.borucki.mycv.adapter.EducationArrayAdapter;
import co.borucki.mycv.model.MyEducation;


public class EducationFragment extends Fragment {
    private LinearLayout rowHolder;
    private List<MyEducation> myEducationList;
    private ArrayAdapter<MyEducation> myEducationArrayAdapter;
    ListView listView;
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

        View view = inflater.inflate(R.layout.fragment_education, container, false);
        listView = (ListView) view.findViewById(R.id.education_fragment_list_view);


        myEducationList = new ArrayList<>();
        myEducationArrayAdapter = new EducationArrayAdapter(getActivity().getApplicationContext(), myEducationList);
        listView.setAdapter(myEducationArrayAdapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
myEducationList.add(new MyEducation("2017","2015", "PWR", "IZ", "asdasdas", "asdasdasd", "asdasdasdas", "asdasd" ,"pl","fsdf"));
myEducationList.add(new MyEducation("2017","2015", "PWR", "IZ", "asdasdas", "asdasdasd", "asdasdasdas", "asdasd" ,"pl","fsdf"));
myEducationArrayAdapter.notifyDataSetChanged();

    }
}
