import java.util.*;

class SqueakyClean {
    static String clean(String identifier) {
        String result = "";
        for (int i = 0; i < identifier.length(); i++) {
            char c = identifier.charAt(i);
            if (c == '-') {
                result += Character.toUpperCase(identifier.charAt(i+1));
                i++;
            }
            if (c == '\0') {
                result += "CTRL";
            }
            else if (c == ' ') {
                result += "_";
            }
            else {
                result += c;
            }
        }
        return result;
    }
}
