package com.starnamu.projcet.memorize_card.titletoolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by starnamu on 2015-04-09.
 */
public class SideMenu_1 extends ViewGroup {

    Context mContext;
    Button SettingButton;
    Button StudyButton;
    Button TestButton;

    public SideMenu_1(Context context) {
        super(context);
        mContext = context;
        init(context);
    }

    public SideMenu_1(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    public void init(Context context) {
        SettingButton = new Button(context);
        StudyButton = new Button(context);
        TestButton = new Button(context);

        addView(SettingButton);
        addView(StudyButton);
        addView(TestButton);

    }
}
