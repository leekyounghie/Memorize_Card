package com.starnamu.projcet.memorize_card.main_fragment_folder;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.starnamu.projcet.memorize_card.R;

import java.util.ArrayList;

/**
 * Created by youmyeongsic on 15. 4. 5..
 */
/*
* ViewPager 프래그먼트 모듈입니다. 어뎁터랑 같이 선언되있어요.
* */
public class Fragment_ViewPager extends Fragment {
    FragmentManager manager;

    public Fragment_ViewPager(FragmentManager manager)

    {
        this.manager = manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.fragmet_viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(manager);
        viewPager.setAdapter(viewPagerAdapter);


        return view;
    }


    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private ArrayList<WordCard> wordCardArrayList = new ArrayList<WordCard>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);


            for (int i = 0; i < Vocabulary.Word.length; i++) {
                WordCard wordCard = new WordCard();
                wordCard.setWord(Vocabulary.Word[i]);
                wordCard.setLevel(1);
                wordCardArrayList.add(wordCard);
            }


        }


        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            PageFragment pageFragment = new PageFragment(wordCardArrayList.get(position));


            return pageFragment;
        }

        @Override
        public int getCount() {
            return wordCardArrayList.size();
        }
    }
}
