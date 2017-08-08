package co.borucki.mycv.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
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
import co.borucki.mycv.model.MySkills;


public class SkillsTechnologiesAdapter extends RecyclerView.Adapter<SkillsTechnologiesAdapter.MySkillsViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private List<ImageView> mImageViews = new ArrayList<>();
    private final List<MySkills> mData = new ArrayList<>();

    public SkillsTechnologiesAdapter(Context context) {

        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MySkillsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.skills_technologies_single_row, parent, false);

        return new MySkillsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MySkillsViewHolder holder, int position) {
        MySkills mySkills = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();
        Context context = holder.itemView.getContext();

        holder.mText.setText(mySkills.getName());
        if (mySkills.getLevel() - 1 > 0) {
            holder.mImageView1.setBackgroundColor(ContextCompat.getColor(context, R.color.checked));
        }
        if (mySkills.getLevel() - 1 > 1) {
            holder.mImageView2.setBackgroundColor(ContextCompat.getColor(context, R.color.checked));
        }
        if (mySkills.getLevel() - 1 > 2) {
            holder.mImageView3.setBackgroundColor(ContextCompat.getColor(context, R.color.checked));
        }
        if (mySkills.getLevel() - 1 > 3) {
            holder.mImageView4.setBackgroundColor(ContextCompat.getColor(context, R.color.checked));
        }
        if (mySkills.getLevel() - 1 > 4) {
            holder.mImageView5.setBackgroundColor(ContextCompat.getColor(context, R.color.checked));
        }
        if (mySkills.getLevel() - 1 > 5) {
            holder.mImageView6.setBackgroundColor(ContextCompat.getColor(context, R.color.checked));
        }

    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<MySkills> mySkillsList) {
        mData.clear();
        mData.addAll(mySkillsList);
        notifyDataSetChanged();
    }

    public class MySkillsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.skills_technologies_single_row_text)
        TextView mText;
        @BindView(R.id.skills_technologies_single_row_1)
        ImageView mImageView1;
        @BindView(R.id.skills_technologies_single_row_2)
        ImageView mImageView2;
        @BindView(R.id.skills_technologies_single_row_3)
        ImageView mImageView3;
        @BindView(R.id.skills_technologies_single_row_4)
        ImageView mImageView4;
        @BindView(R.id.skills_technologies_single_row_5)
        ImageView mImageView5;
        @BindView(R.id.skills_technologies_single_row_6)
        ImageView mImageView6;


        public MySkillsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mImageViews.add((ImageView) itemView.findViewById(R.id.skills_technologies_single_row_1));
            mImageViews.add((ImageView) itemView.findViewById(R.id.skills_technologies_single_row_2));
            mImageViews.add((ImageView) itemView.findViewById(R.id.skills_technologies_single_row_3));
            mImageViews.add((ImageView) itemView.findViewById(R.id.skills_technologies_single_row_4));
            mImageViews.add((ImageView) itemView.findViewById(R.id.skills_technologies_single_row_5));
            mImageViews.add((ImageView) itemView.findViewById(R.id.skills_technologies_single_row_6));
        }
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
//        mOnLongClickListener = onLongClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
//        mOnClickListener = onClickListener;
    }

}
