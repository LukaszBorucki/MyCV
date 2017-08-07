package co.borucki.mycv.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.mycv.R;
import co.borucki.mycv.model.MySkills;


public class SkillsTraitsAdapter extends RecyclerView.Adapter<SkillsTraitsAdapter.MySkillsViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final List<MySkills> mData = new ArrayList<>();

    public SkillsTraitsAdapter(Context context) {

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

        holder.mText.setText(mySkills.getName());

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
        @BindView(R.id.skills_traits_single_row_text)
        TextView mText;


        public MySkillsViewHolder(View itemView) {
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
