package com.starnamu.projcet.memorize_card.main_fragment_folder_1;

/**
 * Created by starnamu on 2015-04-06.
 */
public class WordCard {
    private String Words;
    private String Interpretation;
    private int CardClass;

    public WordCard(String words, String interpretation, int cardClass) {
        Words = words;
        Interpretation = interpretation;
        CardClass = cardClass;
    }

    public String getWords() {
        return Words;
    }

    public void setWords(String words) {
        Words = words;
    }

    public String getInterpretation() {
        return Interpretation;
    }

    public void setInterpretation(String interpretation) {
        Interpretation = interpretation;
    }

    public int getCardClass() {
        return CardClass;
    }

    public void setCardClass(int cardClass) {
        CardClass = cardClass;
    }
}
