import java.util.*;

class RotationalCipher {

    Map<Integer, Character> map = new HashMap<>();

    {
        char letter = 'a';
        for (int i = 0; i < 26; i++) {
            map.put(i, letter);
            letter++;
        }
    }

    int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    int getKeyFromValue(Character value) {
        for (int key : map.keySet()) {
            if (map.get(key) == value) {
                return key;
            }
        }

        return -1;
    }

    String rotate(String data) {
        String result = "";

        for (int i = 0; i < data.length(); i++) {
            char character = data.charAt(i);
            boolean isLowerCase = Character.isLowerCase(character);
            character = Character.toLowerCase(character);

            int originalKey = getKeyFromValue(character);
            if (originalKey == -1) {
                result += character;
                continue;
            }

            int newKey = originalKey + shiftKey;
            newKey -= 26 * (Math.floor(newKey / 26));

            char newCharacter = map.get(newKey);
            if (!isLowerCase) {
                newCharacter = Character.toUpperCase(newCharacter);
            }

            result += newCharacter;
        }

        return result;
    }

}
