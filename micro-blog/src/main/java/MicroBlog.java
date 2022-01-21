class MicroBlog {
    public String truncate(String input) {
        String result = "";
        int[] chars = input.codePoints().toArray();
        for (int i = 0; i < Math.min(chars.length, 5); i++) {
            char[] ch = Character.toChars(chars[i]);
            for (char c : ch) {
                result += c;
            }
        }
        return result;
    }
}
