package kwic.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import kwic.circularShift.CircularShift;

/**
 * receive ArrayList<String> from inputmedium
 * convert to ArrayList<ArrayList<String><String>>
 * { [a111 a222 a333],
 * [b111 b222 b333] }
 * =>>
 * { {[a111], [a222], [a333]},
 * {[b111], [b222], [b333]} }
 * pass ArrayList<ArrayList<String>> to circularshift
 */
public class Input {

    private static Scanner inputScanner = new Scanner(System.in);
    private String filePath;
    private File file;
    private ArrayList<String> al_lines;
    // D:\My Files\School Documents\Repository\TIC3001-Assignment-B\Input and Expected Output\TitlesInput0.txt
    private ArrayList<ArrayList<String>> al_al_words;

    public Input() {
    }

    public void run() {
        al_lines = new ArrayList<>();
        al_al_words = new ArrayList<>();

        System.out.println("Enter filepath to check for KWIC:");

        getProjectPath();
        boolean isFileExist = isFileValid();

        try {
            while (!isFileExist) {
                System.out.println("Invalid File Path with File Name");
                System.out.println("Please key in one of the following:");
                System.out.println("1. Enter filepath with the format <filepath>\\<filename>.txt.");
                System.out.println("2. Enter \"Exit\" to leave the program.");
                System.out.println("3. Enter \"Default\" to run sample KWIC input text.");
                getProjectPath();

                if (filePath.equals("Exit")) {
                    return;
                } else if (filePath.equals("Default")) {
                    // todo give a better one
                    filePath = "D:\\My Files\\School Documents\\Repository\\TIC3001-Assignment-B\\"
                            + "Input and Expected Output\\TitlesInput0.txt";
                }
                isFileExist = isFileValid();
            }

            readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        breakDownToWords();
        new CircularShift(al_al_words, filePath).run();
    }

    private void breakDownToWords() {
        for (String line : al_lines) {
            ArrayList<String> al_words = new ArrayList<String>();
            for (String word : line.split(" ")) {
                al_words.add(word);
            }
            al_al_words.add(al_words);
        }
    }

    private void readFile() {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                al_lines.add(line);
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getProjectPath() {
        try {
            this.filePath = inputScanner.nextLine().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isFileValid() {

        this.file = new File(filePath);

        if (file.isDirectory() || !file.isFile()) {
            return false;
        }
        return true;
    }
}
