package kwic.input;

import kwic.characters.Characters;
import kwic.inputMedium.InputMedium;

public class Input {

    private String fileLocation;

    public Input(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Characters run() {
        String inputText = InputMedium.readFile(fileLocation);
        System.out.println("Contents of File: ");
        System.out.println(inputText);

        Characters characters = new Characters(inputText);
        characters.setChar();

        return characters;
    }
}
