public class PigLatinTranslator {
    private String vowels = "aeiouy";
    private String consonants = "bcdfghjklmnpqrstvwxz";

    public String translate(String str) {
        Character firstLetter = str.charAt(0);
        if (vowels.contains(firstLetter.toString()) || str.substring(0, 2) == "xr" || str.substring(0, 2) == "yt") {
            return str + "ay";
        }

        String cluster = "";
        String after = "";

        for (Character c : str.toCharArray()) {
            if (consonants.contains(c.toString())) {
                cluster += c;
            } else {
                after += c;
                break;
            }
        }

        System.out.println(cluster);
        System.out.println(after);

        if (after == "y") {
            return str.substring(cluster.length(), str.length()) + cluster + "ay";
        }

        if (after == "u" && cluster.endsWith("q")) {
            return str.substring(cluster.length() + 1, str.length()) + cluster + "uay";
        }

        return str.substring(cluster.length(), str.length()) + cluster + "ay";

    }

}
