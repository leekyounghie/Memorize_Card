/*
package com.starnamu.projcet.memorize_card;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.starnamu.projcet.memorize_card.fragment_folder.OneFragment;
import com.starnamu.projcet.memorize_card.fragment_folder.ThreeFragment;
import com.starnamu.projcet.memorize_card.fragment_folder.TwoFragment;

*/
/**
 * Created by starnamu on 2015-04-10.
 *//*

public class MainActivity_1 extends ActionBarActivity {

    /*/
/*********************************************************************
 final String TAG = "MainActivity";

 int mCurrentFragmentIndex;
 public final static int FRAGMENT_ONE = 0;
 public final static int FRAGMENT_TWO = 1;
 public final static int FRAGMENT_THREE = 2;

 @Override protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main_1);

 Button bt_oneFragment = (Button) findViewById(R.id.bt_oneFragment);
 bt_oneFragment.setOnClickListener(this);
 Button bt_twoFragment = (Button) findViewById(R.id.bt_twoFragment);
 bt_twoFragment.setOnClickListener(this);
 Button bt_threeFragment = (Button) findViewById(R.id.bt_threeFragment);
 bt_threeFragment.setOnClickListener(this);

 mCurrentFragmentIndex = FRAGMENT_ONE;

 fragmentReplace(mCurrentFragmentIndex);
 }

 public void fragmentReplace(int reqNewFragmentIndex) {

 Fragment newFragment = null;

 Log.d(TAG, "fragmentReplace " + reqNewFragmentIndex);

 newFragment = getFragment(reqNewFragmentIndex);

 // replace fragment
 final FragmentTransaction transaction = getSupportFragmentManager()
 .beginTransaction();

 transaction.replace(R.id.ll_fragment, newFragment);

 // Commit the transaction
 transaction.commit();

 }

 private Fragment getFragment(int idx) {
 Fragment newFragment = null;

 switch (idx) {
 case FRAGMENT_ONE:
 newFragment = new OneFragment();
 break;
 case FRAGMENT_TWO:
 newFragment = new TwoFragment();
 break;
 case FRAGMENT_THREE:
 newFragment = new ThreeFragment();
 break;

 default:
 Log.d(TAG, "Unhandle case");
 break;
 }

 return newFragment;
 }

 @Override public void onClick(View v) {

 switch (v.getId()) {

 case R.id.bt_oneFragment:
 mCurrentFragmentIndex = FRAGMENT_ONE;
 fragmentReplace(mCurrentFragmentIndex);
 break;
 case R.id.bt_twoFragment:
 mCurrentFragmentIndex = FRAGMENT_TWO;
 fragmentReplace(mCurrentFragmentIndex);
 break;
 case R.id.bt_threeFragment:
 mCurrentFragmentIndex = FRAGMENT_THREE;
 fragmentReplace(mCurrentFragmentIndex);
 break;

 }

 }
 /*/
/*********************************************************
 }
 */
