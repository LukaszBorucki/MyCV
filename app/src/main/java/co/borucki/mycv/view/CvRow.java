package co.borucki.mycv.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.borucki.mycv.R;
import co.borucki.mycv.model.CvItem;
import co.borucki.mycv.model.MailItem;
import co.borucki.mycv.model.NoItem;
import co.borucki.mycv.model.PhoneItem;
import co.borucki.mycv.model.SkypeItem;
import co.borucki.mycv.model.WebItem;


public class CvRow extends LinearLayout {
    public CvRow(final Context context, final CvItem cvItem) {
        super(context);

        setupLayout(context);
        ImageView imageField = setupIcon(context, cvItem);
        TextView textField = setupTextField(context, cvItem);
        addViews(imageField, textField);
        if (cvItem instanceof WebItem) {
            final WebItem webItem = (WebItem) cvItem;

        }


        if (cvItem instanceof PhoneItem) {
            final PhoneItem phoneItem = (PhoneItem) cvItem;
        }
        if (cvItem instanceof MailItem) {
            final MailItem mailItem = (MailItem) cvItem;
        }
        if (cvItem instanceof SkypeItem) {
            final SkypeItem mailItem = (SkypeItem) cvItem;
        }
        if (cvItem instanceof NoItem) {
            final NoItem noItem = (NoItem) cvItem;
        }
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cvItem.performAction(context);
            }
        });
    }


    private void addViews(ImageView imageField, TextView textField) {
        this.addView(imageField);
        this.addView(textField);
    }

    private void setupLayout(Context context) {
        this.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                convertDpToPixel(64, context)));
        this.setPadding(convertDpToPixel(16, context), 0,convertDpToPixel(16, context),0);

        this.setOrientation(LinearLayout.HORIZONTAL);
    }

    @NonNull
    private TextView setupTextField(Context context, CvItem cvItem) {
        TextView textField = new TextView(context);
        textField.setText(cvItem.getCaption());

        textField.setTextColor(ContextCompat.getColor(context, R.color.checked));

        textField.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textField.setGravity(Gravity.CENTER_VERTICAL);
        textField.setPadding(convertDpToPixel(32, context), 0, 0, 0);
        textField.setTextSize(24);
        return textField;
    }

    @NonNull
    private ImageView setupIcon(Context context, CvItem cvItem) {
        ImageView imageField = new ImageView(context);
        imageField.setImageResource(cvItem.getIcon());
        LayoutParams imageFieldParams = new LayoutParams(convertDpToPixel(24, context), convertDpToPixel(24, context));
        imageField.setLayoutParams(imageFieldParams);
        imageFieldParams.gravity = Gravity.CENTER_VERTICAL;
        return imageField;
    }


    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private int pxToDp(int px) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }
}
