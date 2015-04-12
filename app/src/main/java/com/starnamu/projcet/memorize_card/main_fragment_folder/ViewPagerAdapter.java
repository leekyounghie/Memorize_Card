package com.starnamu.projcet.memorize_card.main_fragment_folder;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by youmyeongsic on 15. 4. 11..
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<WordCard> wordCardArrayList = new ArrayList<WordCard>();


    public static int ToDayWordCounter;

   /* public void setToDayWordCounter(int toDayWordCounter) {
        ToDayWordCounter = toDayWordCounter;
    }*/

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        init();
    }

    public void init() {
        for (int i = 0; i < ToDayWordCounter; i++) {
            WordCard wordCard = new WordCard();
            wordCard.setWord(Vocabulary.Word[i]);
            wordCard.setLevel(1);
            wordCard.setTranslate(Vocabulary.Translate[i]);
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