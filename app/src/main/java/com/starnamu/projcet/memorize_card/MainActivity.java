package com.starnamu.projcet.memorize_card;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.starnamu.projcet.memorize_card.awakeprocess.AwakeReceiver;
import com.starnamu.projcet.memorize_card.awakeprocess.AwakeService;
import com.starnamu.projcet.memorize_card.fragment_folder.OneFragment;
import com.starnamu.projcet.memorize_card.fragment_folder.SideFragment;
import com.starnamu.projcet.memorize_card.fragment_folder.ThreeFragment;
import com.starnamu.projcet.memorize_card.fragment_folder.TwoFragment;
import com.starnamu.projcet.memorize_card.main_fragment_folder.ViewPagerAdapter;
import com.starnamu.projcet.memorize_card.titletoolbar.ToolbarTitle;


public class MainActivity extends ActionBarActivity implements SideFragment.choiceFragmentListener {

    final String TAG = "MainActivity";
    int mCurrentFragmentIndex;
    public final static int ONEFRAGMENT = 0;
    public final static int TWOFRAGMENT = 1;
    public final static int THREEFRAGMENT = 2;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

//        coustomFragmentManager();
        showCustomTitleAndSubtitle();

        Intent boradcastIntent = new Intent(AwakeReceiver.ACTION_START);
        sendBroadcast(boradcastIntent);

    }

    private void showCustomTitleAndSubtitle() {
        /**ToolBar를 Coustomizing하게 사용하기 위해 CoustomView정의*/
        getSupportActionBar().setCustomView(new ToolbarTitle(this));
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        /**ToolBar의 Title을 없애기 위한 코드*/

    }

    @Override
    protected void onStop() {
        super.onDestroy();
        AwakeService.awakenStop(this);
    }


//    public void coustomFragmentManager() {
//        /* 컨테이너에서 뷰페이져 선언후 바로 addview해줬습니다.*/
//        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.container);
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        ViewPager viewPager = new ViewPager(this);
//        viewPager.setId(R.id.mViewPager); //xml이 존재하지 않아 바로 아이디 지정해주는 메소드입니다. values/ids.xml에 아이디 추가 됬습ㄴ디ㅏ.
//        viewPager.setAdapter(viewPagerAdapter);
//        frameLayout.addView(viewPager);
//    }

    public void init() {
        titleBar();//TitleBar 구현 Method 호출
        removeStatusBar(true);
    }

    public void titleBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle(null);
        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        dtToggle = new ActionBarDrawerToggle(this, dlDrawer, 0, 0);
        setSupportActionBar(toolbar);
        dlDrawer.setDrawerListener(dtToggle);
    }

    @Override
    public void onClickChoice(int id) {

        switch (id) {
            case R.id.Study:
                mCurrentFragmentIndex = ONEFRAGMENT;
                fragmentReplace(mCurrentFragmentIndex);
                Toast.makeText(this, "첫번째 프래그 먼트 크릭", Toast.LENGTH_LONG).show();
                break;

            case R.id.Setting:
                mCurrentFragmentIndex = TWOFRAGMENT;
                fragmentReplace(mCurrentFragmentIndex);
                break;

            case R.id.Statistics:
                mCurrentFragmentIndex = THREEFRAGMENT;
                fragmentReplace(mCurrentFragmentIndex);
                break;

            default:
                mCurrentFragmentIndex = ONEFRAGMENT;
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
            case ONEFRAGMENT:
                newFragment = new OneFragment();
                break;
            case TWOFRAGMENT:
                newFragment = new TwoFragment();
                break;
            case THREEFRAGMENT:
                newFragment = new ThreeFragment();
                break;
            default:
                break;
        }
        return newFragment;
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
