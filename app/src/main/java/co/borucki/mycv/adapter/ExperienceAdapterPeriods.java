package co.borucki.mycv.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.mycv.R;
import co.borucki.mycv.model.Branch;
import co.borucki.mycv.model.Employer;
import co.borucki.mycv.model.PeriodOfEmployment;


public class ExperienceAdapterPeriods extends RecyclerView.Adapter<ExperienceAdapterPeriods.PeriodsViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final List<PeriodOfEmployment> mData = new ArrayList<>();

    public ExperienceAdapterPeriods(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public PeriodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.fragment_experience_periods_single_row, parent, false);
        return new PeriodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeriodsViewHolder holder, int position) {
        PeriodOfEmployment periodOfEmployment = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();
       holder.mPeriodFrom.setText(periodOfEmployment.getFrom());
       holder.mPeriodTo.setText(periodOfEmployment.getTo());
       holder.mPeriodPosition.setText(periodOfEmployment.getPosition());
    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<PeriodOfEmployment> periodOfEmployments) {
        mData.clear();
        mData.addAll(periodOfEmployments);
        notifyDataSetChanged();
    }

    public class PeriodsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.experience_period_from)
        TextView mPeriodFrom;

        @BindView(R.id.experience_period_to)
        TextView mPeriodTo;

        @BindView(R.id.experience_period_position)
        TextView mPeriodPosition;

        public PeriodsViewHolder(View itemView) {
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
