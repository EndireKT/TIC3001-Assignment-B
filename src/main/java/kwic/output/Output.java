package kwic.output;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Output {

    private ArrayList<String> al_asLine;
    private String filePath;
    private StringBuilder output;

    public Output(ArrayList<String> al_asLine, String filePath) {
        this.al_asLine = al_asLine;
        this.filePath = filePath;
    }

    public void run() {
        output = new StringBuilder();

        System.out.println();
        System.out.println("The output of KWIC is as followed: \n");
        printArrayList();
        writeToFile();
    }

    private void printArrayList() {
        for (int i = 0; i < al_asLine.size(); i++) {
            System.out.println(al_asLine.get(i));
            output.append(al_asLine.get(i));
            output.append("\n");
        }
    }

    private void writeToFile() {
        String fileContent = output.toString();
        filePath = extractPath(filePath);
        filePath = filePath + "\\Output.txt";

        try {
            File file = new File(filePath);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String extractPath(String filePath) {
        int pos = filePath.lastIndexOf(File.separator);
        if (pos > -1) {
            return filePath.substring(0, pos);
        } else {
            return filePath;
        }
    }
}
