package co.borucki.mycv.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import co.borucki.mycv.R;
import co.borucki.mycv.model.MyEducation;



public class EducationArrayAdapter extends ArrayAdapter<MyEducation> {

    public EducationArrayAdapter(@NonNull Context context, @NonNull List<MyEducation> objects) {
        super(context, 0, objects);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        final Task task = getItem(position);
//        Task item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.education_single_row, parent, false);

        }


//        TextView itemNo = (TextView) convertView.findViewById(R.id.singleRowNo);
//        TextView itemText = (TextView) convertView.findViewById(R.id.singleRowText);
//        CheckBox itemCheckBox = (CheckBox) convertView.findViewById(R.id.checkBox);

//        itemNo.setText(String.valueOf(position + 1));
//        itemText.setText(item.getValue());
//        itemCheckBox.setChecked(item.isCompleted());
//        itemCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//            }
//        });
        return convertView;
    }
}
