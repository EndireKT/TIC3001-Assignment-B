package kwic;

import kwic.characters.Characters;
import kwic.circularShift.CircularShift;
import kwic.input.Input;

import java.util.Scanner;

public class Kwic {

    private static Scanner inputScanner = new Scanner(System.in);
    private Input input;

    public Kwic(String filePath) {
        input = new Input(filePath);
    }

    public void run() {
        Characters characters = input.run();
        CircularShift circularShift = new CircularShift(characters);
        circularShift.setup();
    }

    public static String getProjectPath() {
        System.out.println("Enter filepath to check for KWIC:");
        String filePath = inputScanner.nextLine().trim();
        // todo validate the path

        return filePath;
    }

    public static void main(String[] args) {
        String filePath = getProjectPath();
        Kwic kwic = new Kwic(filePath);
        kwic.run();
    }
}
