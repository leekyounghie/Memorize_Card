package com.starnamu.projcet.memorize_card.fragment_folder;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.starnamu.projcet.memorize_card.R;
import com.starnamu.projcet.memorize_card.autosavesetting.AutoSaveSetting;
import com.starnamu.projcet.memorize_card.database_folder.DataBaseControl;
import com.starnamu.projcet.memorize_card.database_folder.Datainterface;
import com.starnamu.projcet.memorize_card.main_fragment_folder.ViewPagerAdapter;
import com.starnamu.projcet.memorize_card.main_fragment_folder.WordCard;

import java.util.ArrayList;

public class StudyFragment extends Fragment implements Datainterface {

    private View view;
    public static int mToDayWordCounter = 0;
    AutoSaveSetting saveSetting;
    ArrayList<WordCard> cards;

    public StudyFragment() {
        setLodeSetting();
    }

    private void setLodeSetting() {
        try {
            saveSetting = new AutoSaveSetting("/mnt/sdcard/setting.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveSetting.Ready();
        int StNum = saveSetting.ReadInt("StNum", mToDayWordCounter);
        mToDayWordCounter = StNum;
        saveSetting.EndReady();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.dd_fragment_study, container, false);
        coustomFragmentManager();
        return view;
    }

    public void coustomFragmentManager() {
        /* 컨테이너에서 뷰페이져 선언후 바로 addview해줬습니다.*/
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dd_fragment_one_container);
        ViewPagerAdapter.ToDayWordCounter = mToDayWordCounter;
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager(), cards);

        /*setToDayWordCounter()안에 보여줄 카드 갯수 정의*/
        ViewPager viewPager = new ViewPager(getActivity());

        viewPager.setId(R.id.mViewPager); //xml이 존재하지 않아 바로 아이디 지정해주는 메소드입니다. values/ids.xml에 아이디 추가 됬습ㄴ디ㅏ.
        viewPager.setAdapter(viewPagerAdapter);
        frameLayout.addView(viewPager);
    }

    @Override
    public void passArrayList(ArrayList<WordCard> a) {
        cards = a;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}
