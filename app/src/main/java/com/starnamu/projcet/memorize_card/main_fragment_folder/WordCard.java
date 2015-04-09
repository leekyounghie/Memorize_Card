package com.starnamu.projcet.memorize_card.main_fragment_folder;

import java.lang.String; /**
 * Created by youmyeongsic on 15. 4. 6..
 */
public class WordCard {
    private String Word;
    private int Level = 1;
    private String Translate;

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getTranslate() {
        return Translate;
    }

    public void setTranslate(String translate) {
        Translate = translate;
    }
}
