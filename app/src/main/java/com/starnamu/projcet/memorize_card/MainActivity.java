package com.starnamu.projcet.memorize_card;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.starnamu.projcet.memorize_card.awakeprocess.AwakeReceiver;
import com.starnamu.projcet.memorize_card.awakeprocess.AwakeService;
import com.starnamu.projcet.memorize_card.fragment_folder.SettingFragment;
import com.starnamu.projcet.memorize_card.fragment_folder.StatisticsFragment;
import com.starnamu.projcet.memorize_card.fragment_folder.StudyFragment;
import com.starnamu.projcet.memorize_card.fragment_folder.SideFragment;
import com.starnamu.projcet.memorize_card.titletoolbar.ToolbarTitle;

public class MainActivity extends ActionBarActivity implements SideFragment.choiceFragmentListener,
        SettingFragment.SettingPortocol {
    final String TAG = "MainActivity";
    int mCurrentFragmentIndex;
    public final static int STUDYFRAGMENT = 0;
    public final static int SETTINGFRAGMENT = 1;
    public final static int STATISTICSTHREEFRAGMENT = 2;
    /*settingFragment에서 넘어오는 값으로 변경해야함*/
    private int mToDayWordCounter;

    Toolbar toolbar;
    Bundle CardCount = null;
    /*
     * 좌측 숨겨진 메뉴와 메인화면을 담는 Layoiut
     * toolbar instanc에 toolbar의 속성을 정의하면 된다.
     * setTitle, setVisibility()등의 속성을 정의할수 있다.
     */
    DrawerLayout dlDrawer;
    /*
     * dtToggle은 상단 좌측의 그래픽 Animation
     */
    ActionBarDrawerToggle dtToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Intent boradcastIntent = new Intent(AwakeReceiver.ACTION_START);
        sendBroadcast(boradcastIntent);
    }

    @Override
    protected void onStop() {
        super.onDestroy();
        AwakeService.awakenStop(this);
    }

    public void init() {
        titleBar();//TitleBar 구현 Method 호출
        removeStatusBar(true);
        CardCount = new Bundle();
        CardCount.putInt("cordConunt", mToDayWordCounter);

    }

    /*TitleBar 설정 method*/
    public void titleBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle(null);
        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        dtToggle = new ActionBarDrawerToggle(this, dlDrawer, 0, 0);
        setSupportActionBar(toolbar);
        dlDrawer.setDrawerListener(dtToggle);
        getSupportActionBar().setCustomView(new ToolbarTitle(this));
        getSupportActionBar().setDisplayShowCustomEnabled(true);
    }

    @Override
    public void onClickChoice(int id) {
        switch (id) {
            case R.id.Study:
                mCurrentFragmentIndex = STUDYFRAGMENT;
                fragmentReplace(mCurrentFragmentIndex);
                Toast.makeText(this, "첫번째 프래그 먼트 크릭", Toast.LENGTH_LONG).show();
                break;

            case R.id.Setting:
                mCurrentFragmentIndex = SETTINGFRAGMENT;
                fragmentReplace(mCurrentFragmentIndex);
                Toast.makeText(this, "두번째 프래그 먼트 크릭", Toast.LENGTH_LONG).show();
                break;

            case R.id.Statistics:
                mCurrentFragmentIndex = STATISTICSTHREEFRAGMENT;
                fragmentReplace(mCurrentFragmentIndex);
                Toast.makeText(this, "세번째 프래그 먼트 크릭", Toast.LENGTH_LONG).show();
                break;

            default:
                mCurrentFragmentIndex = STUDYFRAGMENT;
                fragmentReplace(mCurrentFragmentIndex);
        }
    }

    public void fragmentReplace(int mFragmentIndex) {
        Fragment newFragment;
        newFragment = getFragment(mFragmentIndex);
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.replace(R.id.container, newFragment);
        transaction.commit();
    }

    public Fragment getFragment(int idx) {
        Fragment newFragment = null;
        switch (idx) {
            case STUDYFRAGMENT:
                newFragment = new StudyFragment();
                StudyFragment.mToDayWordCounter = mToDayWordCounter;
                break;
            case SETTINGFRAGMENT:
                newFragment = new SettingFragment();
                break;
            case STATISTICSTHREEFRAGMENT:
                newFragment = new StatisticsFragment();
                break;
            default:
                break;
        }
        return newFragment;
    }

    @Override
    public void setSettingPortocol(int i) {
        mToDayWordCounter = i;
    }


    /**
     * 아래 내용은 아직 건드릴게 없습니다 keep 하세요
     */
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
