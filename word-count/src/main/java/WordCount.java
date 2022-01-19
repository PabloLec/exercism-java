import java.util.*;

public class WordCount {
    private Map<String, Integer> wordCount = new HashMap<>();

    public Map<String, Integer> phrase(String raw) {
        String clean = raw.replaceAll("[^a-zA-Z0-9 \'\n,]", "");
        String[] words = clean.split("[ \n,]");

        for (String word : words) {
            if (word.length() == 0)
                continue;
            word = word.toLowerCase();
            if (word.charAt(0) == '\'')
                word = word.substring(1, word.length());
            if (word.charAt(word.length() - 1) == '\'')
                word = word.substring(0, word.length() - 1);

            if (wordCount.containsKey(word)) {
                wordCount.replace(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }

}
