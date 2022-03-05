package kwic;

import kwic.input.Input;

public class Kwic {

    public Kwic() {
    }

    public void run() {
        new Input().run();
    }

    public static void main(String[] args) {
        Kwic kwic = new Kwic();
        kwic.run();
    }
}
