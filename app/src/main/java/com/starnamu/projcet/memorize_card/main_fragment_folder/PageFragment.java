package com.starnamu.projcet.memorize_card.main_fragment_folder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.starnamu.projcet.memorize_card.R;


/**
 * Created by youmyeongsic on 15. 4. 5..
 */

/*
* 뷰페이져 안에 있는 Fragment입니다.  support.v4.frament입니다.
* */
public class PageFragment extends Fragment {

    WordCard wordCard;
    Animation animation;
    TextView viewPager_tranlate;
    TextView viewPager_level;
    TextView viewPager_word;

    public PageFragment(WordCard wordCard) {

        this.wordCard = wordCard;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_pagefragment, container, false);
        viewPager_word = (TextView) view.findViewById(R.id.main_viewpager_word);
        viewPager_level = (TextView) view.findViewById(R.id.main_viewpager_level);
        viewPager_tranlate = (TextView) view.findViewById(R.id.main_viewpager_translate);
        viewPager_tranlate.setVisibility(View.INVISIBLE);
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.flow);
        animation.setAnimationListener(new FlowAnimationListener());
        Button tranlate_button = (Button) view.findViewById(R.id.translate_button);

        tranlate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager_tranlate.setVisibility(View.VISIBLE);
                viewPager_tranlate.startAnimation(animation);


            }
        });
        viewPager_word.setText(wordCard.getWord());
        viewPager_level.setText("Level : " + wordCard.getLevel());
        viewPager_tranlate.setText(wordCard.getTranslate());
        return view;

    }

    private class FlowAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
