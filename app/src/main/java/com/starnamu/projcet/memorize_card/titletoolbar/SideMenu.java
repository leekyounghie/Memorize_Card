package com.starnamu.projcet.memorize_card.titletoolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.starnamu.projcet.memorize_card.R;
import com.starnamu.projcet.memorize_card.expandable.Group;
import com.starnamu.projcet.memorize_card.expandable.MyExpandableListAdapter;

/**
 * Created by starnamu on 2015-04-08.
 * 수정중
 */
public class SideMenu extends LinearLayout {

    SparseArray<Group> groups = new SparseArray<Group>();
    Context mContext;

    public SideMenu(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public SideMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public void init() {

//        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View root = inflater.inflate(R.id.sidelayout, this, true);

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(mContext, listView, groups);
        listView.setAdapter(adapter);

        Group group = new Group("설정" + 1);
        for (int i = 1; i < 30; i++) {
            group.children.add(i + " 장 선택");
        }
        groups.append(0, group);

        Group group1 = new Group("통계" + 2);
        group1.children.add("카드별");
        group1.children.add("일별");
        group1.children.add("주별");
        group1.children.add("월별");
        groups.append(1, group1);
    }

}


