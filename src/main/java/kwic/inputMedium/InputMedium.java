package kwic.inputMedium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class InputMedium {
    public static String readFile(String fileLocation) {
        // D:\My Files\School Documents\Repository\TIC3001-Assignment-B\Input and Expected Output\Output0.txt
        File file = new File(fileLocation);
        StringBuffer sb = new StringBuffer();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Invalid File Path\n");
            e.printStackTrace();
        }
        return sb.toString();
    }
}
