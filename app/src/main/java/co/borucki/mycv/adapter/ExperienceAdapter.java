package co.borucki.mycv.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.mycv.R;
import co.borucki.mycv.model.Branch;
import co.borucki.mycv.model.Employer;
import co.borucki.mycv.model.PeriodOfEmployment;
import co.borucki.mycv.model.Project;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.EmployerViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private RecyclerView mRecyclerViewPeriods;
    private RecyclerView mRecyclerViewProjects;
    private final List<Employer> mData = new ArrayList<>();
    private ExperienceAdapterPeriods mExperienceAdapterPeriods;
    private ExperienceAdapterProjects mExperienceAdapterProjects;

    public ExperienceAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public EmployerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.fragment_experience_single_row, parent, false);

        mRecyclerViewPeriods = (RecyclerView) view.findViewById(R.id.experience_periods);
        LinearLayoutManager linearLayoutManagerPeriods = new LinearLayoutManager(parent.getContext());
        mRecyclerViewPeriods.setLayoutManager(linearLayoutManagerPeriods);
        DividerItemDecoration dividerItemDecorationPeriods = new DividerItemDecoration(parent.getContext(), linearLayoutManagerPeriods.getOrientation());
        mRecyclerViewPeriods.addItemDecoration(dividerItemDecorationPeriods);
        mExperienceAdapterPeriods = new ExperienceAdapterPeriods(parent.getContext());
        mRecyclerViewPeriods.setAdapter(mExperienceAdapterPeriods);

        mRecyclerViewProjects = (RecyclerView) view.findViewById(R.id.experience_projects);
        LinearLayoutManager linearLayoutManagerProjects = new LinearLayoutManager(parent.getContext());
        mRecyclerViewProjects.setLayoutManager(linearLayoutManagerProjects);
        DividerItemDecoration dividerItemDecorationProjects = new DividerItemDecoration(parent.getContext(), linearLayoutManagerProjects.getOrientation());
        mRecyclerViewProjects.addItemDecoration(dividerItemDecorationProjects);
        mExperienceAdapterProjects = new ExperienceAdapterProjects(parent.getContext());
        mRecyclerViewProjects.setAdapter(mExperienceAdapterProjects);

        return new EmployerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployerViewHolder holder, int position) {
        Employer employer = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();
        String nameOfBranchInUsedLanguage = null;
        for (Branch branch : employer.getBranch()) {
            if (branch.getLanguage().equals("en")) {
                nameOfBranchInUsedLanguage = branch.getBranchName();
            }
        }
        holder.mEmployerBranch.setText(nameOfBranchInUsedLanguage);
        holder.mEmployerName.setText(employer.getCompanyName());
        byte[] decodedByte = Base64.decode(employer.getLogotype(), 0);
        holder.mLogotype.setImageBitmap(BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length));
        List<PeriodOfEmployment> periodOfEmployments = new ArrayList<>();
        for (PeriodOfEmployment periodOfEmployment : employer.getPeriodOfEmployment()) {
            if (periodOfEmployment.getLanguage().equals("en")) {
                periodOfEmployments.add(periodOfEmployment);
            }
        }
        List<Project> projects = new ArrayList<>();
        for (Project project : employer.getProjects()) {
            if (project.getLanguage().equals("en")) {
                projects.add(project);
            }
        }
        mExperienceAdapterProjects.setData(projects);
        mExperienceAdapterPeriods.setData(periodOfEmployments);
    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<Employer> employers) {
        mData.clear();
        mData.addAll(employers);
        notifyDataSetChanged();
    }

    public class EmployerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.experience_branch)
        TextView mEmployerBranch;

        @BindView(R.id.experience_company_name)
        TextView mEmployerName;

        @BindView(R.id.experience_imageView)
        ImageView mLogotype;

        public EmployerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
//        mOnLongClickListener = onLongClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
//        mOnClickListener = onClickListener;
    }
}
