package kwic.circularShift;

import kwic.alphabeticShifts.AlphabeticShifts;

import java.util.ArrayList;

/*
 * do these:
 *      start with { {[a111], [a222], [a333]},
 *                   {[b111], [b222], [b333]} }
 *      for each "line", do these:
 *          start with { {[a111], [a222], [a333]},
 *              take first word, [a111],
 *              put at the back,
 *              generate new string, [a222 a333 a111]
 *              repeat until the end of arraylist
 *              output: { [a222 a333 a111],
 *                        [a333 a111 a222],
 *                        [a111 a222 a333] }
 *         repeat until the end
 *         output: { [a222 a333 a111],
 *                    [a333 a111 a222],
 *                    [a111 a222 a333],
 *                    [b222 b333 b111],
 *                    [b333 b111 b222],
 *                    [b111 b222 b333], }
 */

/**
 * Receive ArrayList<ArrayList<String><String>> from Input and perform circular shift
 */
public class CircularShift {

    private ArrayList<ArrayList<String>> al_al_words;
    private ArrayList<String> al_csline;
    private String filePath;

    public CircularShift(ArrayList<ArrayList<String>> al_al_words, String filePath) {
        this.al_al_words = al_al_words;
        this.filePath = filePath;
    }

    public void run() {
        al_csline = new ArrayList<String>();

        for (ArrayList<String> line : al_al_words) {
            for (int i = 0; i < line.size(); i++) {
                al_csline.add(constructLine(line));
                line = shiftByOne(line);
            }
        }

        new AlphabeticShifts(al_csline, filePath).run();
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
}
