package com.starnamu.projcet.memorize_card.main_fragment_folder;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by youmyeongsic on 15. 4. 11..
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<WordCard> wordCardArrayList;

    public static int ToDayWordCounter;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<WordCard> wordCardArrayList) {
        super(fm);
        this.wordCardArrayList = wordCardArrayList;
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