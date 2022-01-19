import java.util.*;

public class Robot {
    private static List<String> names = new ArrayList<String>();
    private String name = "";

    private String getRandomChar() {
        Random random = new Random();
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return Character.toString(candidateChars.charAt(random.nextInt(candidateChars.length())));
    }

    private int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10);
    }

    Robot() {
        reset();
    }

    public String getName() {
        return this.name;
    }

    public void reset() {
        this.name = "";
        this.name += getRandomChar() + getRandomChar();
        this.name += getRandomInt();
        this.name += getRandomInt();
        this.name += getRandomInt();

        if (this.names.contains(this.name))
            reset();
        this.names.add(this.name);
    }
}
