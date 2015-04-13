package com.starnamu.projcet.memorize_card.fragment_folder;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.starnamu.projcet.memorize_card.autosavesetting.*;

import com.starnamu.projcet.memorize_card.R;

public class SettingFragment extends Fragment {

    private int ToDayWordCounter;
    AutoSaveSetting saveSetting;
    int DefaultsSeekBar = 0;
    SeekBar seekbar;
    EditText choicecount;
    private SettingPortocol settingPortocol;

    public interface SettingPortocol {
        public void setSettingPortocol(int i);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        choicecount = (EditText) getActivity().findViewById(R.id.choicecount);
        seekbar.setProgress(DefaultsSeekBar);
        choicecount.setText(Integer.toString(DefaultsSeekBar));
    }

    public void editChoiceCountText(int progress) {
        ToDayWordCounter = progress;
        String str = Integer.toString(progress);
        choicecount.setText(str);
        settingPortocol.setSettingPortocol(ToDayWordCounter);
        setLodeSetting();
        setSaveSetting();
    }

    private void setLodeSetting() {
        try {
            saveSetting = new AutoSaveSetting("/mnt/sdcard/texxxxxxxxt.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveSetting.Ready();
        String name = saveSetting.ReadString("name", "이름없음");
        int StNum = saveSetting.ReadInt("StNum", 20011125);
        saveSetting.EndReady();
    }

    private void setSaveSetting() {
        String Name = "이경희";
        int StNum = ToDayWordCounter;
        saveSetting.Ready();
        saveSetting.WriteString("Name", Name);
        saveSetting.WriteInt("StNum", StNum);
        saveSetting.CommitWrite();
    }

    public void callProgressbar() {

        seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editChoiceCountText(progress);
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
        settingPortocol = (SettingPortocol) activity;

    }
}