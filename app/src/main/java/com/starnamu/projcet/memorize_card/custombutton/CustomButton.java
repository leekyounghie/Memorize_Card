package com.starnamu.projcet.memorize_card.custombutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.starnamu.projcet.memorize_card.R;

/**
 * Created by starnamu on 2015-04-09.
 */
public class CustomButton extends Button implements View.OnClickListener {

    Context mContext;

    public CustomButton(Context context) {
        super(context);
        init(context);
        mContext = context;
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        mContext = context;
    }

    public void init(Context context) {

        setText("Custom Button");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                0.0f);

        setLayoutParams(params);


    }

    @Override
    public void onClick(View v) {
        Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.button_trans);
        startAnimation(anim);
    }
}
