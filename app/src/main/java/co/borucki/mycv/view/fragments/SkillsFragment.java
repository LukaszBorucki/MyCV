package co.borucki.mycv.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.borucki.mycv.R;


public class SkillsFragment extends Fragment {
    public SkillsFragment() {
    }
    public static SkillsFragment newInstance(){
        return new SkillsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_skills, container, false);
    }
}
