package com.starnamu.projcet.memorize_card.fragment_folder;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.starnamu.projcet.memorize_card.R;

public class SettingFragment extends Fragment {

    private int ToDayWordCounter = 5;

    SeekBar seekbar;

    public interface ActivityFragmentProtocol {
        public void activityAsInFragment(int i);
    }

    private ActivityFragmentProtocol activityFragmentProtocol;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFragmentProtocol.activityAsInFragment(ToDayWordCounter);


    }

    @Override
    public void onStart() {
        super.onStart();
        callProgressbar();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        seekbar = (SeekBar) getActivity().findViewById(R.id.seekbar);
    }

    public void callProgressbar() {
        seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dd_fragment_setting, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activityFragmentProtocol = (ActivityFragmentProtocol) activity;

    }
}