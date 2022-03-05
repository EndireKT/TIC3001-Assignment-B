package kwic.output;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;


class OutputTest {

    @Test
    void writeToFile() {
        String str = "Sample Output";

        String filePath = "D:\\My Files\\School Documents\\Repository\\TIC3001-Assignment-B\\Input and Expected Output";
        filePath = filePath + "\\testOutput.txt";

        try {
            File file = new File(filePath);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

    @Test
    void extractPath() {
        String filePath = "D:\\My Files\\School Documents\\Repository\\TIC3001-Assignment-B\\Input and Expected Output\\TitlesInput0.txt";
        String path;

        int pos = filePath.lastIndexOf(File.separator);
        if (pos > -1){
            path = filePath.substring(0, pos);
        } else {
            path = filePath;
        }
    }
}