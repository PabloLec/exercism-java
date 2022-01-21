import java.util.*;

public class Anagram {
    private final String word;

    Anagram(String word) {
        this.word = word.toLowerCase();
    }

    public List<String> match(List<String> words) {
        List<String> matches = new ArrayList<>();
        for (String w : words) {
            if (isAnagram(w)) {
                matches.add(w);
            }
        }
        return matches;
    }

    public boolean isAnagram(String s2) {
        if (word.length() != s2.length()) {
            return false;
        }
        if (word.equals(s2.toLowerCase())) {
            return false;
        }
        char[] s1Array = word.toCharArray();
        char[] s2Array = s2.toLowerCase().toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        return Arrays.equals(s1Array, s2Array);
    }
}
