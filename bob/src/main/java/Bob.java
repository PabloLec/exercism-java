public class Bob {
    private String question = "Sure.";
    private String yell = "Whoa, chill out!";
    private String yellQuestion = "Calm down, I know what I'm doing!";
    private String nothing = "Fine. Be that way!";
    private String whatever = "Whatever.";

    public String hey(String message) {
        message = message.trim();
        if (message.isEmpty()) {
            return nothing;
        }
        if (message.endsWith("?")) {
            if (message.matches(".*[a-zA-Z].*") && message.toUpperCase().equals(message)) {
                return yellQuestion;
            }
            return question;
        }
        if (message.matches(".*[a-zA-Z].*") && message.toUpperCase().equals(message)) {
            return yell;
        }
        return whatever;
    }
}
