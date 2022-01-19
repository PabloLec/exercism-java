import java.util.*;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                if (list.contains(c)) {
                    return false;
                } else {
                    list.add(c);
                }
            }
        }

        return true;
    }

}
