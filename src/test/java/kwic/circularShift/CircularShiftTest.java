package kwic.circularShift;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CircularShiftTest {

    @Test
    void runTest() {
        ArrayList<ArrayList<String>> al_al_words = new ArrayList<ArrayList<String>>();

        ArrayList<String> input1 = new ArrayList<>();
        input1.add("a111");
        input1.add("a222");
        input1.add("a333");

        ArrayList<String> input2 = new ArrayList<>();
        input2.add("b111");
        input2.add("b222");
        input2.add("b333");

        al_al_words.add(input1);
        al_al_words.add(input2);

        ArrayList<String> al_csline = new ArrayList<String>();
        for (ArrayList<String> line : al_al_words) {
            for (int i = 0; i < line.size(); i++) {
                al_csline.add(constructLine(line));
                line = shiftByOne(line);
            }
        }
        System.out.println("Done");
    }

    private ArrayList<String> shiftByOne(ArrayList<String> input) {
        String temp = input.get(0);
        input.remove(0);
        input.add(temp);
        return input;
    }

    private String constructLine(ArrayList<String> input) {
        StringBuilder line = new StringBuilder();
        for (String s : input) {
            line.append(s);
            line.append(" ");
        }
        return line.deleteCharAt(line.length() - 1).toString();
    }

    @Test
    void constructLineTest() {

        ArrayList<String> input = new ArrayList<>();
        input.add("a111");
        input.add("a222");
        input.add("a333");

        StringBuilder line = new StringBuilder();
        for (String s : input) {
            line.append(s);
            line.append(" ");
        }
        String output = line.deleteCharAt(line.length() - 1).toString();

        assertEquals("a111 a222 a333", output);
    }
}