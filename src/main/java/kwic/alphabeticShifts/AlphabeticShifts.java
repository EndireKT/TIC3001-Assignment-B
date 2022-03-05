package kwic.alphabeticShifts;

import java.util.ArrayList;

import kwic.output.Output;

public class AlphabeticShifts {

    private ArrayList<String> al_csLine;
    private String filePath;

    public AlphabeticShifts(ArrayList<String> ar_csLine, String filePath) {
        this.al_csLine = ar_csLine;
        this.filePath = filePath;
    }

    public void run() {
        sort();
        new Output(al_csLine, filePath).run();
    }

    private void sort() {
        if (al_csLine == null || al_csLine.size() == 0) {
            return;
        }
        al_csLine.sort(String.CASE_INSENSITIVE_ORDER);
    }
}


