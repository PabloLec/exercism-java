class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        stringToVerify = stringToVerify.trim().replace("-", "");
        if (!stringToVerify.matches("[0-9]{9}[0-9X]{1}")) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < stringToVerify.length(); i++) {
            char c = stringToVerify.charAt(i);
            int digit;
            if (c == 'X') {
                digit = 10;
            } else {
                digit = Character.getNumericValue(c);
            }
            sum += digit * (10 - i);
        }

        return sum % 11 == 0;
    }

}
