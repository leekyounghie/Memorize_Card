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
import com.starnamu.projcet.memorize_card.main_fragment_folder.ViewPagerAdapter;

public class StudyFragment extends Fragment {

    View view;

    public StudyFragment() {
        // Required empty public constructor
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
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        ViewPager viewPager = new ViewPager(getActivity());
        viewPager.setId(R.id.mViewPager); //xml이 존재하지 않아 바로 아이디 지정해주는 메소드입니다. values/ids.xml에 아이디 추가 됬습ㄴ디ㅏ.
        viewPager.setAdapter(viewPagerAdapter);
        frameLayout.addView(viewPager);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}