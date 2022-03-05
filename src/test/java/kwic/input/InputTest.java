package kwic.input;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class InputTest {

    private ArrayList<String> al_lines = new ArrayList<String>();
    private ArrayList<ArrayList<String>> al_al_words = new ArrayList< ArrayList<String> >();

    @Test
    public void run() {

    }

    @Test
    void breakDownToWords() {

        //al_lines.add("a111 a222 a333");
       // al_lines.add("b111 b222 b333");
        al_lines.add("1 Revolutionary Road");

        for (String line : al_lines) {
            ArrayList<String> al_words = new ArrayList<String>();
            for (String word : line.split(" ")) {
                al_words.add(word);
            }
            al_al_words.add(al_words);
        }

        System.out.println("done");
    }
}
