package kwic.characters;

import java.util.ArrayList;

public class Characters {

    String inputText;
    ArrayList<String> al_line = new ArrayList<String>();
    ArrayList<String> al_words_ofALine = new ArrayList<String>();
    ArrayList<ArrayList<String>> al_words = new ArrayList<ArrayList<String>>();


    public Characters(String inputText) {
        this.inputText = inputText;
    }

    public void setChar() {
        for (String s : inputText.split("\\r?\\n")) {
            al_line.add(s);
        }

        for (String s : al_line) {
            //      al_words_ofALine.add()
        }
    }

    public void character_char() {

    }

    public void character_word() {

    }

}
