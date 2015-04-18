package com.starnamu.projcet.memorize_card.database_folder;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.View;

import com.starnamu.projcet.memorize_card.main_fragment_folder.WordCard;

import java.util.ArrayList;

public class DataBaseControl {
    public static final String TAG = "MainActivity";
    DataBaseService database;

    private ArrayList<WordCard> wordCardArrayList;

    public DataBaseControl(Context context) {
        wordCardArrayList = new ArrayList<WordCard>();
        init(context);
        initData();
        goLev1();
    }

    public void init(Context context) {
        if (database != null) {
            database.close();
            database = null;
        }

        database = DataBaseService.getInstance(context);
        database.open();
    }

    public ArrayList<WordCard> getArrayList() {
        return wordCardArrayList;
    }

    public void initData() {
        database.initData();
    }


    public void AddCursorData(Cursor outCursor) {
        int recordCount = outCursor.getCount();
        String Word;
        String Translate;
        //adapter.clear();

        // get column index
        int wordCodeCol = outCursor.getColumnIndex("WORD");
        int wordMeaning = outCursor.getColumnIndex("MEANING");
        StringBuilder wordCode = new StringBuilder();
        if (recordCount > 0) {
            for (int i = 0; i < recordCount; i++) {
                outCursor.moveToNext();
                Word = outCursor.getString(wordCodeCol);
                Translate = outCursor.getString(wordMeaning);
                wordCardArrayList.add(new WordCard(Word, 1, Translate));

                if (i == 10) {
                    break;
                }
            }
        }
        outCursor.close();
        Datainterface datainterface = null;
        datainterface.passArrayList(wordCardArrayList);
    }

    public void goLev1() {
        Cursor cursor = database.queryWordsTable(1);
        AddCursorData(cursor);
    }

    public void goLev2(View v) {
        String queryData = "";
        Cursor cursor = database.queryWordsTable(2);
        AddCursorData(cursor);
    }

    public void goLev3(View v) {
        String queryData = "";
        Cursor cursor = database.queryWordsTable(3);
        AddCursorData(cursor);
    }

    public void upWord1(View v) {
        database.queryWordsUpdate("UP", "when");
    }

    public void upWord2(View v) {
        database.queryWordsUpdate("UP", "id");
    }

    public void upWord3(View v) {
        database.queryWordsUpdate("UP", "sure");
    }

    public static void println(String msg) {
        Log.d(TAG, msg);
    }


}

/* public String AddCursorData(Cursor outCursor) {
        String parma = "";
        int recordCount = outCursor.getCount();
        println("cursor count : " + recordCount + "\n");

        //adapter.clear();

        // get column index
        int wordCodeCol = outCursor.getColumnIndex("WORD");
        int wordMeaning = outCursor.getColumnIndex("MEANING");
        StringBuilder wordCode = new StringBuilder();
        if (recordCount > 0) {
            for (int i = 0; i < recordCount; i++) {
                outCursor.moveToNext();
                wordCode.append(outCursor.getString(wordCodeCol));
                wordCode.append(outCursor.getString(wordMeaning));
                wordCode.append("");
                //adapter.set(i, wordCode);
                if (i == 10) {
                    break;
                }
            }
        }

        outCursor.close();
        return wordCode.toString();
    }*/