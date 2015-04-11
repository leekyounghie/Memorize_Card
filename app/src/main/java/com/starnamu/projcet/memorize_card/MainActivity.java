package com.starnamu.projcet.memorize_card;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.starnamu.projcet.memorize_card.awakeprocess.AwakeReceiver;
import com.starnamu.projcet.memorize_card.awakeprocess.AwakeService;
import com.starnamu.projcet.memorize_card.expandable.Group;
import com.starnamu.projcet.memorize_card.expandable.MyExpandableListAdapter;
import com.starnamu.projcet.memorize_card.main_fragment_folder.ViewPagerAdapter;
import com.starnamu.projcet.memorize_card.titletoolbar.ToolbarTitle;


public class MainActivity extends ActionBarActivity {
    Toolbar toolbar;
    /**
     * 좌측 숨겨진 메뉴와 메인화면을 담는 Layoiut
     * toolbar instanc에 toolbar의 속성을 정의하면 된다.
     * setTitle, setVisibility()등의 속성을 정의할수 있다.
     */
    DrawerLayout dlDrawer;
    /**
     * dtToggle은 상단 좌측의 그래픽 Animation
     */
    ActionBarDrawerToggle dtToggle;
    /**
     * 메인화면(바탕화면)
     */
    FrameLayout container;
    /**
     * 좌측 사이드에 숨겨진 메뉴
     */
    LinearLayout drawer;
    ExpandableListView listView;


    SparseArray<Group> groups = new SparseArray<Group>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        coustomFragmentManager();//4방향 ViewGroup
//        viewPagerManager();
        showCustomTitleAndSubtitle();

        Intent boradcastIntent = new Intent(AwakeReceiver.ACTION_START);
        sendBroadcast(boradcastIntent);

    }

    private void showCustomTitleAndSubtitle() {
        /**ToolBar를 Coustomizing하게 사용하기 위해 CoustomView정의*/
        getSupportActionBar().setCustomView(new ToolbarTitle(this));
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        /**ToolBar의 Title을 없애기 위한 코드*/
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle(null);
    }

    @Override
    protected void onStop() {
        super.onDestroy();
        AwakeService.awakenStop(this);
    }


    public void coustomFragmentManager() {



        /* 컨테이너에서 뷰페이져 선언후 바로 addview해줬습니다.*/
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.container);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = new ViewPager(this);
        viewPager.setId(R.id.mViewPager); //xml이 존재하지 않아 바로 아이디 지정해주는 메소드입니다. values/ids.xml에 아이디 추가 됬습ㄴ디ㅏ.
        viewPager.setAdapter(viewPagerAdapter);
        frameLayout.addView(viewPager);
    }


    public void init() {
        titleBar();//TitleBar 구현 Method 호출
        removeStatusBar(true);
        //SideMenu 구현중
//        drawer = (LinearLayout) findViewById(R.id.drawer);
//        drawer.addView(new SideMenu(this));
        sideMenu();
    }

    public void sideMenu() {

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, listView, groups);
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

    public void titleBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        dtToggle = new ActionBarDrawerToggle(this, dlDrawer, 0, 0);
        setSupportActionBar(toolbar);
        dlDrawer.setDrawerListener(dtToggle);
    }

    public void removeStatusBar(boolean remove) {
        if (remove) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        dtToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        dtToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (dtToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
